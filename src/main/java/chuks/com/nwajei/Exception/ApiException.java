package chuks.com.nwajei.Exception;

import lombok.Data;

@Data
public class ApiException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    public ApiException(String message, String errorCode, String errorMessage) {
        super(message);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ApiException(String message) {
        super(message);
        this.errorMessage = errorMessage;
    }

}
