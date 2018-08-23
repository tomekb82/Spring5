package pl.sages.persistance.impl.hibernate;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.sages.persistance.UserDao;
import pl.sages.persistance.model.User;

@Repository
@Transactional
public class UserDaoImpl extends AbstractHibernateDaoImpl<User> implements UserDao {

  public UserDaoImpl() {
    super(User.class);
  }

  @Override
  public User findByEmail(String email) {
    return getCurrentSession().createQuery("from " + User.class.getSimpleName() + " where email = :email", User.class)
        .setParameter("email", email)
        .uniqueResult();
  }

}
