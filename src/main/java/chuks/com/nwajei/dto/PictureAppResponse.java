package chuks.com.nwajei.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class PictureAppResponse<T> {
    private int status;

    private String message;

    private final String timeStamp = String.valueOf(LocalDateTime.now());

    private T data;

    public PictureAppResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public PictureAppResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public PictureAppResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}