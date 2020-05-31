/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public abstract class Merce {
    private String codice;
    private double prezzoUnitario;
    
    public Merce(String in_codice, double in_prezzo){
        this.codice=in_codice;
        this.prezzoUnitario=in_prezzo;  
    }
    public String getCodice(){
        return codice;
    }
    public abstract void SetCodice();
    public double getPrezzo(){
        return prezzoUnitario;
    }
    public abstract void SetPrezzo();
    public abstract double calcolaImporto();
    public abstract String ToString();
}
