package com.ss.hw.dao;

import com.ss.hw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> findAll() {
        return jdbcTemplate.query("select * from customer", ((resultSet, i) ->
                new Customer(resultSet.getLong("id"),
                        resultSet.getString("fName"),
                        resultSet.getString("lName"))));
    }
}