package chuks.com.nwajei.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class LoginDto {
    @NotBlank(message = "Email should not be blank")
    private String Email;

    @NotBlank(message = "Password should not be blank")
    private String password;

}
