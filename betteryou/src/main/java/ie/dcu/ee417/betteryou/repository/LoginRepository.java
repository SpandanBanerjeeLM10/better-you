package ie.dcu.ee417.betteryou.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.dcu.ee417.betteryou.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    
	Login save(Login login);

	Optional<Login> findByUserNameAndPassword(String userName, String password);

	 
}
