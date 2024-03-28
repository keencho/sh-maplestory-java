package com.sh.maplestory.external.open_api;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class MaplestoryRestTemplate extends RestTemplate {
    public MaplestoryRestTemplate() {
        this.setErrorHandler(new ErrorHandler());
    }

    static class ErrorHandler implements ResponseErrorHandler {

        @Override
        public boolean hasError(ClientHttpResponse response) {
            return false;
        }

        @Override
        public void handleError(ClientHttpResponse response) {
        }
    }
}
