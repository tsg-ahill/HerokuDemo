/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.demo.heroku.controller;

import com.sg.demo.heroku.dao.Dao;
import com.sg.demo.heroku.model.Llama;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author austynhill
 */
@RestController
public class Controller {
    
    private Dao<Llama> herd;

    @Autowired
    public Controller(Dao<Llama> herd) {
        this.herd = herd;
    }
    
    @GetMapping("/")
    public String rootWelcome(){
        return "Welcome to the Llama Herd. Consult ReadMe for Endpoints.";
    }
    
    
    @PostMapping("/herd/llama/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Llama addLlama(@RequestBody Llama aLlama){
        return herd.create(aLlama);
    }

    @GetMapping("/herd/all")
    public List<Llama> getHerd(){
        return herd.getAll();
    }
    
    @GetMapping("/herd/llama/{id}")
    public Llama getHerd(@PathVariable int id){
        return herd.get(id);
    }
    
    @PutMapping("/herd/llama/update/{id}")
    public void updateLlama(@PathVariable int id, @RequestBody Llama aLlama){
        herd.update(id, aLlama);
    }
    
    @DeleteMapping("/herd/llama/delete/{id}")
    public void deleteLlama(@PathVariable int id){
        Llama aLlama = herd.get(id);
        if(aLlama != null){
            herd.delete(id);
        }
    }

    
}
