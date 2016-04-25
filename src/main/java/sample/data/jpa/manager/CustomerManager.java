package sample.data.jpa.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sample.data.jpa.domain.entity.customer;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerManager {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional(readOnly = true)
    public List<customer>  findAll1(){
        String sql = "SELECT * FROM customer l where l.isDelete!=1  ORDER BY l.updateTime ASC";
        RowMapper<customer> rm = BeanPropertyRowMapper.newInstance(customer.class);     
       
        return  jdbcTemplate.query(sql, rm);   
    }

	  @Transactional
	  public void deleCustomer(customer u) {  
	      String sql = "delete from customer c where c.id=?";
	      
	      jdbcTemplate.update(sql, u.getId());  
	  }
	  
	  @Transactional
	  public void  batchdeleCustomer(List<customer> listUser) {  
	      String sql = "delete from customer c where c.id=?";
	      
	      jdbcTemplate.batchUpdate(sql,setParametersDelId(listUser));
	  }
	  
	  /**
	     * 设置参预置数
	     * @param listUser
	     * @return
	     */
	  private List<Object[]> setParametersDelId(List<customer> listUser){
	       List<Object[]> parameters = new ArrayList<Object[]>();
	       for (customer u : listUser) {
	           parameters.add(new Object[] { u.getId()});
	       }
	       return parameters;
	   }
	  
	 @Transactional
	 public void addCustomer(customer u) {  
	      String sql = "insert into customer(name,c_desc,pictureAddress,isDelete,updateTime,creatTime,updater,creater) values(?,?,?,?,?,?,?,?)";
	       
	      jdbcTemplate.update(sql, u.getName(),u.getC_desc(),u.getPictureAddress(),u.getIsDelete(),u.getUpdateTime(),u.getCreatTime(),u.getUpdater(),u.getCreater());  
	  } 
    
    @Transactional
    public Integer batchInsertCustomer(List<customer> listUser) {
        String sql = "insert into customer(name,c_desc,pictureAddress,isDelete,updateTime,creatTime,updater,creater) values(?,?,?,?,?,?,?,?)";
        jdbcTemplate.batchUpdate(sql,setParametersAdd(listUser));
        return 0;
    }

    /**
     * 设置参预置数
     * @param listUser
     * @return
     */
    private List<Object[]> setParametersAdd(List<customer> listUser){
        List<Object[]> parameters = new ArrayList<Object[]>();
        for (customer u : listUser) {
            parameters.add(new Object[] { u.getName(),u.getC_desc(),u.getPictureAddress(),u.getIsDelete(),u.getUpdateTime(),u.getCreatTime(),u.getUpdater(),u.getCreater()});
        }
        return parameters;
    }
    
}