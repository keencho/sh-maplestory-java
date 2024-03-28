package com.sh.maplestory.external.open_api.dto.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    T data;
    Error error;

    public static <T> Response<T> error(Error error) {
        return new Response<>(null, error);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(data, null);
    }

    public boolean isSuccess() {
        return this.error == null;
    }
}
