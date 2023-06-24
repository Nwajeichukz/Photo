package chuks.com.nwajei.controller;

import chuks.com.nwajei.dto.PictureAppResponse;
import chuks.com.nwajei.dto.PostPictureDto;
import chuks.com.nwajei.services.picService.PictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/pic")
@RequiredArgsConstructor
public class PictureController {
    private final PictureService pictureService;

    @GetMapping
    public ResponseEntity<PictureAppResponse<Map<String, Object>>> getAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(pictureService.getAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PictureAppResponse<?>> getByID(@PathVariable long id) {
        return ResponseEntity.ok(pictureService.getByID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PictureAppResponse<?>> remove(@PathVariable long id){
        return ResponseEntity.ok(pictureService.remove(id));
    }

    @PostMapping("/create")
    public ResponseEntity<PictureAppResponse<?>> saved( @Valid @RequestBody PostPictureDto pic) {
        return ResponseEntity.ok(pictureService.saved(pic));
    }
}