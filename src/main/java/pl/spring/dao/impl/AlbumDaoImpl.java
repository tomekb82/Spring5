package pl.spring.dao.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import pl.spring.dao.springdata.CustomAlbumDao;
import pl.spring.model.Album;

import static pl.spring.model.QAlbum.album;

@Repository
public class AlbumDaoImpl extends AbstractJpaDaoImpl<Album> implements CustomAlbumDao/*AlbumDao*/ {

  public AlbumDaoImpl() {
    super(Album.class);
  }

  /*@Override
  public Album findByName(String name) {
    return entityManager.createQuery("from " + Album.class.getSimpleName() + " where name = :name", Album.class)
        .setParameter("name", name)
        .getSingleResult();
  }*/

  @Override
  public Album findByName(String name) {
    return new JPAQueryFactory(entityManager)
            .selectFrom(album)
            .where(album.name.eq(name))
            .fetchOne();
  }

}
