package spkt.nhom16.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import spkt.nhom16.Entity.Users;

public interface IUserService {

	void deleteAll();

	void delete(Users entity);

	void deleteById(Long id);

	long count();

	Optional<Users> findById(Long id);

	List<Users> findAll(Sort sort);

	Page<Users> findAll(Pageable pageable);

	List<Users> findAll();

	<S extends Users> S save(S entity);

	Page<Users> findByuserNameContaining(String name, Pageable pageable);

	List<Users> findByuserNameContaining(String name);

	Users Login(String userName, String passWord);

	void updateUser(Long id, String fullname, String phone, String email, String address);

	Boolean checkUsersExist(String userName);

	Optional<Users> findByUserName(String userName);

}
