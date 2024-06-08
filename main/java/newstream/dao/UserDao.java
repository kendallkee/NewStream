package newstream.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import newstream.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
