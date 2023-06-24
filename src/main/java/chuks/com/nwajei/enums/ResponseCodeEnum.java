package chuks.com.nwajei.enums;

public enum ResponseCodeEnum {

    SUCCESS(0,"Success"),

    ERROR(-1, "Error"),

    INVALID_INPUT(-2, "Invalid input was Entered");

    int code;
    String description;

    ResponseCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
