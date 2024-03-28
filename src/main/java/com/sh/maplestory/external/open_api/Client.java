package com.sh.maplestory.external.open_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.maplestory.external.open_api.dto.res.Error;
import com.sh.maplestory.external.open_api.dto.res.character.*;
import com.sh.maplestory.external.open_api.dto.res.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class Client {

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final String url;
    private final String key;
    private final ObjectMapper objectMapper;

    public Client(String key, ObjectMapper objectMapper) {
        this.url = "https://open.api.nexon.com/maplestory";
        this.key = key;
        this.objectMapper = objectMapper;
    }

    final MaplestoryRestTemplate restTemplate = new MaplestoryRestTemplate();

    /**
     * 캐릭터 식별자 (ocid) 조회
     *
     * @param characterName
     * @return
     */
    public Response<CharacterOcid> getOcid(String characterName) {
        return this.call(HttpMethod.GET, "/v1/id", Map.of("character_name", characterName), CharacterOcid.class);
    }

    /**
     * 기본 정보 조회
     *
     * @param ocid
     * @param date
     * @return
     */
    public Response<CharacterBasic> getCharacterBasic(String ocid, LocalDate date) {
        return this.call(HttpMethod.GET, "/v1/character/basic", this.buildCharacterParams(ocid, date), CharacterBasic.class);
    }

    /**
     * 인기도 정보 조회
     *
     * @param ocid
     * @param date
     * @return
     */
    public Response<CharacterPopularity> getCharacterPopularity(String ocid, LocalDate date) {
        return this.call(HttpMethod.GET, "/v1/character/popularity", this.buildCharacterParams(ocid, date), CharacterPopularity.class);
    }

    /**
     * 종합 능력치 정보 조회
     *
     * @param ocid
     * @param date
     * @return
     */
    public Response<CharacterStat> getCharacterStat(String ocid, LocalDate date) {
        return this.call(HttpMethod.GET, "/v1/character/stat", this.buildCharacterParams(ocid, date), CharacterStat.class);
    }

    /**
     * 하이퍼스탯 정보 조회
     *
     * @param ocid
     * @param date
     * @return
     */
    public Response<CharacterHyperStat> getCharacterHyperStat(String ocid, LocalDate date) {
        return this.call(HttpMethod.GET, "/v1/character/hyper-stat", this.buildCharacterParams(ocid, date), CharacterHyperStat.class);
    }

    private <T> Response<T> call(HttpMethod method, String path, Map<String, String> data, Class<T> clazz) {
        var headers = new HttpHeaders();
        headers.set("accept", "application/json");
        headers.set("x-nxopen-api-key", this.key);

        var reqUrl = this.url + path;

        if (method == HttpMethod.GET) {
            reqUrl += this.convertToQueryString(data);
        }

        var entity = new HttpEntity<>(method == HttpMethod.GET ? null : data, headers);

        var res = restTemplate.exchange(reqUrl, method, entity, JsonNode.class);

        if (!res.getStatusCode().is2xxSuccessful()) {
            try {
                var body = res.getBody();
                assert body != null;

                if (!body.has("error")) {
                    throw new RuntimeException();
                }

                return Response.error(objectMapper.treeToValue(body.get("error"), Error.class));
            } catch (JsonProcessingException | RuntimeException e ) {
                return Response.error(new Error("JSON Parsing Error", "The request failed and the type conversion failed."));
            }
        }

        try {
            return Response.success(objectMapper.treeToValue(res.getBody(), clazz));
        } catch (JsonProcessingException e) {
            return Response.error(new Error("JSON Parsing Error", "The request was successful, but the type conversion failed."));
        }
    }

    private Map<String, String> buildCharacterParams(String ocid, LocalDate date) {
        var map = new HashMap<String, String>();
        map.put("ocid", ocid);

        if (date != null) {
            map.put("date", dateFormatter.format(date));
        }

        return map;
    }

    private String convertToQueryString(Map<String, String> data) {
        if (data == null) {
            return "";
        }

        var queryStringBuilder = new StringBuilder("?");
        for (var entry : data.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();

            if (queryStringBuilder.length() > 1) {
                queryStringBuilder.append("&");
            }

            queryStringBuilder.append(key)
                    .append("=")
                    .append(value);
        }
        return queryStringBuilder.toString();
    }

}
