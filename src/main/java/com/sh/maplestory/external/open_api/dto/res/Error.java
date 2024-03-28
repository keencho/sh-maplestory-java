package com.sh.maplestory.external.open_api.dto.res;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Error {
    String name;
    String message;

    public Error(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
