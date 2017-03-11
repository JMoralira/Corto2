/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Jose Lira
 */
public class SeresVivos {
     private int codiSere;
    private String nombSere;
    private String descSere;
   private int codiRefeSere;
   
public SeresVivos(){
}

    public SeresVivos(int codiSere, String nombSere, String descSere, int codiRefeSere) {
        this.codiSere = codiSere;
        this.nombSere = nombSere;
        this.descSere = descSere;
        this.codiRefeSere = codiRefeSere;
    }

    public int getCodiSere() {
        return codiSere;
    }

    public void setCodiSere(int codiSere) {
        this.codiSere = codiSere;
    }

    public String getNombSere() {
        return nombSere;
    }

    public void setNombSere(String nombSere) {
        this.nombSere = nombSere;
    }

    public String getDescSere() {
        return descSere;
    }

    public void setDescSere(String descSere) {
        this.descSere = descSere;
    }

    public int getCodiRefeSere() {
        return codiRefeSere;
    }

    public void setCodiRefeSere(int codiRefeSere) {
        this.codiRefeSere = codiRefeSere;
    }

    @Override
    public String toString() {
        return nombSere;
    }


}


