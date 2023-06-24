package chuks.com.nwajei.services.picService;

import chuks.com.nwajei.Entity.Picture;
import chuks.com.nwajei.Exception.ApiException;
import chuks.com.nwajei.dto.PictureAppResponse;
import chuks.com.nwajei.dto.PictureDto;
import chuks.com.nwajei.dto.PostPictureDto;
import chuks.com.nwajei.enums.ResponseCodeEnum;
import chuks.com.nwajei.repo.PictureRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class PictureServicesImpl implements PictureService {
    private final PictureRepo repo;

    public PictureAppResponse<Map<String, Object>> getAll(Pageable pageable) {
        Page<PictureDto> pic = repo.findAll(pageable).map(PictureDto::new);

        Map<String, Object> page = Map.of(
                "page", pic.getNumber(),
                "totalPages", pic.getTotalPages(),
                "totalElements", pic.getTotalElements(),
                "size", pic.getSize(),
                "content", pic.getContent()
        );

        return new PictureAppResponse<>(0, "success", page);
    }

    public PictureAppResponse<?> getByID(long id) {
        Picture pic = repo.findById(id).orElseThrow();

        PictureDto picture = new PictureDto();
        picture.setId(pic.getId());
        picture.setFilename(pic.getFilename());

        return new PictureAppResponse<>("Successfully Retrieved", picture );

    }

    public PictureAppResponse<?> remove(long id){
        repo.deleteById(id);
        return new PictureAppResponse<>(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getDescription());
    }

    public PictureAppResponse<?> saved(PostPictureDto pic){

        if (CollectionUtils.isEmpty(Collections.singleton(pic.getFilename())))
            throw new ApiException("filename is required");

        Picture picture = new Picture();
        picture.setFilename(pic.getFilename());
        repo.save(picture);
        return new PictureAppResponse<>(0, "Successful");
    }

}