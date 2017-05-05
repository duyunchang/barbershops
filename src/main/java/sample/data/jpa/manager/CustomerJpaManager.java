package sample.data.jpa.manager;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sample.data.jpa.domain.entity.customer;

public interface CustomerJpaManager extends JpaRepository<customer, Long> {

	@Query("FROM customer l where l.isDelete!=1  ORDER BY l.updateTime ASC")
	public List<customer> findAll1();

	//实现分页功能  
	Page<customer> findByIsDeleteNotAndNameLike(Integer isDelete,String name,Pageable pageable);  
}
