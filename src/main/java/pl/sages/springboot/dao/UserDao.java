package pl.sages.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acacko on 24.08.18
 */
public interface UserDao extends JpaRepository<User, Long> {
}
