package spkt.nhom16.Service;

import java.util.List;
import java.util.Optional;

import spkt.nhom16.Entity.Store;
import spkt.nhom16.Entity.Users;

public interface IStoreService {
	Store findById(Long id) ;
	
	List<Store> findByUserStore(Users userStore);
	<S extends Store> S save(S entity);

	Optional<Store> findByName(String storeName);

	Boolean checkStoreExist(String storeName);
}
