package chuks.com.nwajei.controller;

import chuks.com.nwajei.model.Picture;
import chuks.com.nwajei.services.PictureServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PictureController {

    private final PictureServices pictureServices;

    public PictureController(PictureServices pictureServices) {
        this.pictureServices = pictureServices;
    }

    @GetMapping("/")
    public String hello() {
       return "Hello chukwudi";
    }

    @GetMapping("/picture")
    public Iterable<Picture> get() {
        return pictureServices.get();
    }

    @GetMapping("/picture/{id}")
    public Picture get(@PathVariable Integer id) {
        Picture pic = pictureServices.get(id);
        if (pic == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return pic;
    }

    @DeleteMapping("/picture/{id}")
    public void delete(@PathVariable Integer id){
       pictureServices.remove(id);
    }

    @PostMapping("/picture")
    public Picture create(@RequestBody @Valid Picture picture) {
        return pictureServices.saved(picture);
    }
}