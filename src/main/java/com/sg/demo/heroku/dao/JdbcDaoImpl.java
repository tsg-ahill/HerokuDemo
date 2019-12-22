/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.demo.heroku.dao;

import com.sg.demo.heroku.model.Llama;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author austynhill
 */
@Repository
public class JdbcDaoImpl implements Dao<Llama> {

    @Autowired
    JdbcTemplate heySQL;
    private static String SQL_LAST_ID = "SELECT LAST_INSERT_ID()";

    @Override @Transactional
    public Llama create(Llama toAdd) {
        heySQL.update("INSERT INTO llamaherd(name) VALUES(?)",
                toAdd.getName());
        int id = heySQL.queryForObject(SQL_LAST_ID, Integer.class);
        toAdd.setId(id);
        return toAdd;
    }

    @Override @Transactional
    public Llama get(int llamaId) {
        Llama aLlama = heySQL.queryForObject("SELECT * FROM llamaherd WHERE id = ?",
                new LlamaMapper(), llamaId);
        return aLlama;
    }

    @Override @Transactional
    public List<Llama> getAll() {
        List<Llama> herd = heySQL.query("SELECT * FROM llamaherd", new LlamaMapper());
        return herd;
    }

    @Override
    public void update(int id, Llama toUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override @Transactional
    public void delete(int llamaId) {
        heySQL.update("DELETE FROM llamaherd WHERE id = ?", llamaId);
    }

    public static final class LlamaMapper implements RowMapper<Llama> {

        @Override
        public Llama mapRow(ResultSet rs, int index) throws SQLException {
            Llama aLlama = new Llama();
            aLlama.setId(rs.getInt("id"));
            aLlama.setName(rs.getString("name"));
            return aLlama;
        }
    }

}
