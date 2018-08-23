package pl.sages.persistance.impl.springdata;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sages.persistance.AbstractDao;
import pl.sages.persistance.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

  User findByEmail(String email);

  Stream<User> findByPassword(String email);

}
