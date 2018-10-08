package com.example.springtrac.dao;

import com.example.springtrac.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    //@Resource(name = "dataSource")
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User query(Integer id) {
        User user = jdbcTemplate.query("SELECT * from t_user where id= ?", new Object[]{id}, new ResultSetExtractor<User>() {
            @Override
            public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                User user = new User();
                user.setId(id);
                user.setName(resultSet.getNString("name"));
                user.setAmount(resultSet.getBigDecimal("amount"));
                return user;
            }
        });
        return user;
    }
}
