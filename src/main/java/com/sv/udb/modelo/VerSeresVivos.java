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
public class VerSeresVivos {
    private int codiSer;
    private String nombSer;
    private String descSer;
    private int perteSer;
    private String perteNombSer;
    
    public VerSeresVivos(){
    }

    public VerSeresVivos(int codiSer, int perteSer,String perteNombSer, String nombSer, String descSer) {
        this.codiSer = codiSer;
        this.nombSer = nombSer;
        this.descSer = descSer;
        this.perteSer = perteSer;
        this.perteNombSer = perteNombSer;
    }

    public int getCodiSer() {
        return codiSer;
    }

    public void setCodiSer(int codiSer) {
        this.codiSer = codiSer;
    }

    public String getNombSer() {
        return nombSer;
    }

    public void setNombSer(String nombSer) {
        this.nombSer = nombSer;
    }

    public String getDescSer() {
        return descSer;
    }

    public void setDescSer(String descSer) {
        this.descSer = descSer;
    }

    public int getPerteSer() {
        return perteSer;
    }

    public void setPerteSer(int perteSer) {
        this.perteSer = perteSer;
    }

    public String getPerteNombSer() {
        return perteNombSer;
    }

    public void setPerteNombSer(String perteNombSer) {
        this.perteNombSer = perteNombSer;
    }

    @Override
    public String toString() {
        return nombSer;
    }
    
    
}
