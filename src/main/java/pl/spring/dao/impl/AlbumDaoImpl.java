package pl.spring.dao.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.spring.dao.AlbumDao;
import pl.spring.model.Album;

@Repository
@Transactional
public class AlbumDaoImpl extends AbstractJpaDaoImpl<Album> implements AlbumDao {

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
            .where(album.name.eq(title))
            .fetchOne();
  }

}
