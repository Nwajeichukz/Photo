package chuks.com.nwajei.Exception;

import chuks.com.nwajei.dto.PictureAppResponse;
import chuks.com.nwajei.enums.ResponseCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

//Explain
@Slf4j
@ControllerAdvice
public class GlobalExceptionMapper extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApiException.class )
    public ResponseEntity<PictureAppResponse<?>> handleEmptyInput (ApiException apiException){
        return new ResponseEntity<>(
                new PictureAppResponse<>(apiException.getMessage(), Collections.singletonList(apiException.getMessage())),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<PictureAppResponse<?>> handleNoSuchElement(NoSuchElementException noSuchElementException){
        return new ResponseEntity<>(
                new PictureAppResponse<>(noSuchElementException.getMessage(), Collections.singletonList(noSuchElementException.getMessage())),
                HttpStatus.NOT_FOUND);
    }


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>("PLEASE CHANGE HTTP RETRUN TYPE", HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String responseDescription = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
        PictureAppResponse response = new PictureAppResponse(ResponseCodeEnum.INVALID_INPUT.getCode(), responseDescription);
        return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
    }
}
