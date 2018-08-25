package pl.sages.persistance.impl.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.UserDao;
import pl.sages.persistance.model.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractJpaDaoImpl<User> implements UserDao {

  public UserDaoImpl() {
    super(User.class);
  }

  @Override
  public User findByEmail(String email) {
    return entityManager.createQuery("from " + User.class.getSimpleName() + " where email = :email", User.class)
        .setParameter("email", email)
        .getResultStream().findFirst().orElse(null);
  }

}
