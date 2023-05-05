package chuks.com.nwajei.repo;


import chuks.com.nwajei.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PictureRepo extends JpaRepository<Picture, Integer> {
}
