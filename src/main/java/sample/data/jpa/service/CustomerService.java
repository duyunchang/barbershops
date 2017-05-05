package sample.data.jpa.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.entity.customer;
import sample.data.jpa.manager.CustomerJpaManager;

@Service
public class CustomerService  {

	@Autowired
	private CustomerJpaManager customerJpaManager;
	
	@Transactional
	public  Page<customer> getList(String name,Pageable pageable){
		
		 Page<customer> pages=customerJpaManager.findByIsDeleteNotAndNameLike(1,name,pageable);  
//	     Iterator<customer> it=pages.iterator();  
//	     while(it.hasNext()){  
//	         System.out.println("value:"+((customer)it.next()).getId());  
//	     }  
		return  pages;
	}
	
	
}
