package pl.spring.dao.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.spring.model.Album;

// Spring Data Dao
@Repository
public interface AlbumDao extends JpaRepository<Album, Long>, CustomAlbumDao {

    Album findByIdAndName(Long id, String name);
}