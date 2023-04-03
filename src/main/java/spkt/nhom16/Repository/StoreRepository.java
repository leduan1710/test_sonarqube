package spkt.nhom16.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spkt.nhom16.Entity.Store;
import spkt.nhom16.Entity.Users;

@Transactional
@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
	//vendor
	@Override
	Optional<Store> findById(Long id) ;
	List<Store> findByUserStore(Users userStore);
	
	<S extends Store> S save(S entity);
	
	Optional<Store> findByName(String storeName);
}
