package sample.data.jpa.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import sample.data.jpa.domain.entity.customer;
import sample.data.jpa.domain.entity.employee;
import sample.data.jpa.manager.CustomerManager;
import sample.data.jpa.manager.EmployeeManager;
import sample.data.jpa.pageTools.PageableTools;
import sample.data.jpa.pageTools.SortDto;


@Service
public class CustomerService  {
	@Autowired
	private CustomerManager customerManager;
	@Autowired
	private EmployeeManager employeeManager;
	@Autowired
	private ICustomerService iCustomerService;
	
	public List<customer> getList(){
		List<customer> listUser=new ArrayList<customer>();
		customer customer = new customer("xx1", "xxs1", "/kk/ss/ee.jpg");	
		customer customer2 = new customer("xx2", "xxs2", "/kk/ss/ee.jpg");	
		listUser.add(customer);
		listUser.add(customer2);
		customerManager.batchInsertCustomer(listUser);
		//customerManager.addCustomer(customer);
	   return customerManager. findAll1();
	}
	
	public  List<customer> pageList(Integer page, Integer pageSize){
		
//		StringBuffer sql=new StringBuffer();
//		sql.append("select * from ").append("customer where 1=1 ");
//		Object name=params.get("name");
//		if(!StringUtils.isEmpty(params.get("name"))){
//			sql.append(" and name like '%'").append((String)name).append("'%'");
//		}
		//Pageable pageable =new PageRequest(page, pageSize);
	    //Page<customer> datas = iCustomerService.findAll(pageable);
	    Page<customer> datas = iCustomerService.findAll(PageableTools.basicPage(page, pageSize, new SortDto("ASC", "updateTime")));
	    List<customer> list=new ArrayList<customer>();
	    for(customer c:datas){
	    	list.add(c);
	    }
	    
		return list;
	}
    
	public List<employee> getListem(){
		
		
	   return employeeManager. findAll1();
	}
  
}
