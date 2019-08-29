package com.example.userservice.dao.impl;

import com.example.userservice.dao.UserDao;
import com.example.userservice.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Boolean DEFAULT_ENABLED_VALUE = Boolean.TRUE;

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String query = "select * from `user` where `enabled`=1";
        return jdbcTemplate.query(query, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getBoolean("enabled")
                ));
    }

    @Override
    public User save(User user) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("user").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email", user.getEmail());
        parameters.put("password", user.getPassword());
        parameters.put("name", user.getName());
        parameters.put("lastName", user.getLastName());
        parameters.put("enabled", DEFAULT_ENABLED_VALUE);

        Number id = insert.executeAndReturnKey(parameters);
        return findById((long)id);
    }

    @Override
    public User findById(Long id) {
        String query = "select * from `user` where `id`=? and `enabled`=1";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getBoolean("enabled")
                ));
    }

    @Override
    public User update(Long id, User user) {
        String query = "update `user` set `email`=?, `password`=?, `name`=?, `lastName`=? where `id`=?";
        jdbcTemplate.update(query, user.getEmail(), user.getPassword(), user.getName(), user.getLastName(), user.isEnabled(), id);
        return findById(id);
    }

    @Override
    public Integer countPostsByUserId(Long id) {
        String query = "select count(*) from post where user_id=?";
        return jdbcTemplate.queryForObject(query, Integer.class, id);
    }

    @Override
    public User delete(Long id) {
        String query = "update `user` set `enabled`=? where id=?";
        jdbcTemplate.update(query, Boolean.FALSE, id);
        return findById(id);
    }

    @Override
    public User restore(Long id) {
        String query = "update `user` set `enabled`=? where id=?";
        jdbcTemplate.update(query, Boolean.TRUE, id);
        return findById(id);
    }
}
