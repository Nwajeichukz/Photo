package chuks.com.nwajei.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class PostPictureDto {
    @NotBlank(message = "file name cant be blank")
    private String filename;
}
