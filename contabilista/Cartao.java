package com.example.hugomocho.teste1;

/**
 * Created by Hugo Mochão on 19/07/2017.
 */

public class Cartao {

    private int dinheiro;
    private int numero;
    private String banco;


public Cartao(int numero, String banco){
    this.numero=numero;
    this.banco=banco;
    dinheiro = 0;

    }

public void setDinheiro(int quantidade){
    dinheiro=quantidade;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void addDinheiro(int quantidade){
    dinheiro+=quantidade;
    }

public void removeDinheiro(int quantidade){
        dinheiro-=quantidade;
    }


        }
