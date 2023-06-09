package chuks.com.nwajei.repo;


import chuks.com.nwajei.Entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PictureRepo extends JpaRepository<Picture, Long> {
    Optional<Picture> findById(long id);
}
