package chuks.com.nwajei.services;

import chuks.com.nwajei.model.Picture;
import chuks.com.nwajei.repo.PictureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServices {

    @Autowired
    PictureRepo repo;


    public Iterable<Picture> get() {
        return repo.findAll();
    }

    public Picture get(Integer id) {
        return repo.findById(id).orElse(null);

    }

    public void remove(Integer id){
        repo.deleteById(id);
    }


    public Picture saved(Picture picture){
        repo.save(picture);
        return picture ;
    }

}

