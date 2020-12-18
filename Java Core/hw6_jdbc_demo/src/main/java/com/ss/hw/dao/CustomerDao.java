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

    public Customer findById(Long id) {
        return jdbcTemplate.queryForObject("select * from customer wher id = ?",
                new Object[]{id},
                ((resultSet, i) ->
                        new Customer(resultSet.getLong("id"),
                                resultSet.getString("fName"),
                                resultSet.getString("lName"))));
    }

    public int save(Customer customer) {
        return jdbcTemplate.update("insert into customer (fname, lname, id) values (?,?,?)",
                customer.getfName(), customer.getlName(), customer.getId());
    }
}
