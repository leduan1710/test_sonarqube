package spkt.nhom16.Service.Ipml;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spkt.nhom16.Entity.Store;
import spkt.nhom16.Entity.Users;
import spkt.nhom16.Repository.StoreRepository;
import spkt.nhom16.Service.IStoreService;
@Service
public class StoreServiceImpl implements IStoreService{
	@Autowired
	StoreRepository storeRepository;
	@Override
	public Store findById(Long id) {
		// TODO Auto-generated method stub
		return storeRepository.findById(id).get();
	}
	@Override
	public List<Store> findByUserStore(Users userStore) {
		return storeRepository.findByUserStore(userStore);
	}
	@Override
	public <S extends Store> S save(S entity) {
		// TODO Auto-generated method stub
		return storeRepository.save(entity);
	}
	
	@Override
	public Optional<Store> findByName(String storeName) {
		return storeRepository.findByName(storeName);
	}
	
	@Override
	public Boolean checkStoreExist(String storeName) {
		Optional<Store> optUser = findByName(storeName);
		if(optUser.isPresent()) {
			return true;
		}
		return false;
	}
}
