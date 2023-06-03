package ie.dcu.ee417.betteryou.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ie.dcu.ee417.betteryou.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	
}
