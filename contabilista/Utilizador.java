package com.example.hugomocho.teste1;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

/**
 * Created by Hugo Mochão on 19/07/2017.
 */



public class Utilizador {

    private String id;
    private String password;
    private List<Cartao> cartoes;
    private String nome;

    public Utilizador(String id, String password, String nome){
        this.id=id;
        this.password=password;
        this.nome=nome;
        cartoes = new ArrayList<Cartao>();
        }


    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword(){
        return password;
    }

    public void addCartao(int numero, String banco){
        cartoes.add(new Cartao(numero, banco));
    }

    public String getId(){
        return id;
    }
}
