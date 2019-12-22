/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.demo.heroku.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author austynhill
 */

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode @ToString
public class Llama {
    private int id;
    private String name;
}
