package chuks.com.nwajei.dto;

import chuks.com.nwajei.Entity.Picture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class PictureDto {
    private long id;
    private String filename;

    public PictureDto(Picture picture) {
        id = picture.getId();
        this.filename = picture.getFilename();
    }

    public PictureDto() {

    }
}
