package com.fintech.credx.exceptions;

import com.fintech.credx.common.enums.ErrorCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException {

    private final ErrorCode code;

    public ApiException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public ApiException(ErrorCode code, String customMessage) {
        super(code.getMessage());
        this.code = code;
    }

}
