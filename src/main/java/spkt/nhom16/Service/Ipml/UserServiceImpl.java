package spkt.nhom16.Service.Ipml;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import spkt.nhom16.Entity.Users;
import spkt.nhom16.Repository.UserRepository;
import spkt.nhom16.Service.*;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	UserRepository userRepository;
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public List<Users> findByuserNameContaining(String name) {
		return userRepository.findByuserNameContaining(name);
	}
	@Override
	public Page<Users> findByuserNameContaining(String name, Pageable pageable) {
		return userRepository.findByuserNameContaining(name, pageable);
	}
	@Override
	public <S extends Users> S save(S entity) {
		return userRepository.save(entity);
	}
	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}
	@Override
	public Page<Users> findAll(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	@Override
	public List<Users> findAll(Sort sort) {
		return userRepository.findAll(sort);
	}
	@Override
	public Optional<Users> findById(Long id) {
		return userRepository.findById(id);
	}
	@Override
	public long count() {
		return userRepository.count();
	}
	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	@Override
	public void delete(Users entity) {
		userRepository.delete(entity);
	}
	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}
	@Override
	public Optional<Users> findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	@Override
	public Boolean checkUsersExist(String userName) {
		Optional<Users> optUser = findByUserName(userName);
		if(optUser.isPresent()) {
			return true;
		}
		return false;
	}
	@Override
	public void updateUser(Long id, String fullname, String phone, String email, String address) {
		userRepository.updateUser(id, fullname, phone, email, address);
	}
	@Override
	public Users Login(String userName, String passWord) {
		Optional<Users> optUser = findByUserName(userName);
		if(optUser.isPresent() && optUser.get().getPassWord().trim().equals(passWord)) {
			return optUser.get();
		}
		return null;
	}
	
}
