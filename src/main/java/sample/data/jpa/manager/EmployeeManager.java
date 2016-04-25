package sample.data.jpa.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.entity.employee;

import java.sql.*;
import java.util.List;

@Repository
public class EmployeeManager {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional(readOnly = true)
    public List<employee>  findAll(){
        String sql = "SELECT l.id,l.name,l.isDelete ,l.c_DESC,l.pictureAddress FROM employee l where l.isDelete!=1 ORDER BY l.updateTime ASC";
        return (List<employee>) jdbcTemplate.query(sql, new RowMapper<employee>(){

            @Override
            public employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            	employee stu = new employee();
            	stu.setName(rs.getString("name"));
                stu.setE_desc(rs.getString("desc"));
                
                stu.setPictureAddress(rs.getString("pictureAddress"));
                stu.setIsDelete(rs.getInt("isDelete"));
                return stu;
            }

        });
    }
    
    @Transactional(readOnly = true)
    public List<employee>  findAll1(){
        String sql = "SELECT * FROM employee l where l.isDelete!=1  ORDER BY l.updateTime ASC";
        RowMapper<employee> rm = BeanPropertyRowMapper.newInstance(employee.class);           
        return jdbcTemplate.query(sql, rm);   
    }
    
}