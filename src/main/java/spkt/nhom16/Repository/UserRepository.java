	package spkt.nhom16.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spkt.nhom16.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	List<Users> findByuserNameContaining(String name);
	Page<Users> findByuserNameContaining(String name, Pageable pageable);
	Optional<Users> findByUserName(String userName);

	@Transactional
	@Modifying
	@Query(value = "update Users set Users.full_name = ?2, Users.phone = ?3, Users.email = ?4, Users.addresses = ?5 where Users.user_id = ?1", nativeQuery = true)
	void updateUser(@Param(value ="id") Long id, @Param(value = "fullname") String fullname, 
			@Param(value = "phone") String phone,@Param(value = "email") String email, @Param(value = "address")String address);

}
