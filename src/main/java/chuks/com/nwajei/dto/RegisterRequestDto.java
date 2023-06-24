package chuks.com.nwajei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class RegisterRequestDto {
    @NotBlank(message = "FirstName should not be blank")
    private String firstname;

    @NotBlank(message = "LastName should not be blank")
    private String lastname;

    @NotBlank(message = "UserName should not be blank")
    private String username;

    @javax.validation.constraints.Pattern(regexp = "(\\w+@)(\\w+\\.com)", message = "wrong email format")
    private String email;

    @NotBlank(message = "Password should not be blank")
    private String password;

    @NotBlank(message = "confirmPassword should not be blank")
    private String confirmPassword;
}
