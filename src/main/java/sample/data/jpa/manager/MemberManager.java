package sample.data.jpa.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sample.data.jpa.domain.entity.memberinfo;

import java.sql.*;
import java.util.List;

@Repository
public class MemberManager {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly = true)
    public List<memberinfo>  findAll1(){
        String sql = "SELECT * FROM memberinfo l where l.isDelete!=1  ORDER BY l.updateTime ASC";
        RowMapper<memberinfo> rm = BeanPropertyRowMapper.newInstance(memberinfo.class);           
        return jdbcTemplate.query(sql, rm);   
    }
    
}