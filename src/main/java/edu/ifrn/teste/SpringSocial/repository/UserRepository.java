package edu.ifrn.teste.SpringSocial.repository;

import edu.ifrn.teste.SpringSocial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByName(final String name);
}
