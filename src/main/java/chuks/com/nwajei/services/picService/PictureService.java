package chuks.com.nwajei.services.picService;

import chuks.com.nwajei.dto.PictureAppResponse;
import chuks.com.nwajei.dto.PostPictureDto;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface PictureService {
    PictureAppResponse<Map<String, Object>> getAll(Pageable pageable);
    PictureAppResponse<?> saved(PostPictureDto pic);
    PictureAppResponse<?> getByID(long id);
    PictureAppResponse<?> remove(long id);
}
