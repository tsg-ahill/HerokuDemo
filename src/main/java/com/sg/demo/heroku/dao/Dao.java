/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.demo.heroku.dao;

import java.util.List;

/**
 *
 * @author austynhill
 */
public interface Dao<T> {
    
    public T create(T toAdd);
    public T get(int id);
    public List<T> getAll();
    public void update(int id, T toUpdate);
    public void delete(int id);
    
}
