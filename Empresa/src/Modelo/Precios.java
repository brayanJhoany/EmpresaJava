/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Brayan Escobar
 */
public class Precios {
    private double b93;
    private double b95;
    private double b97;
    private double disel;
    private double kerosene;

    public Precios(double b93, double b95, double b97, double disel, double kerosene) {
        this.b93 = b93;
        this.b95 = b95;
        this.b97 = b97;
        this.disel = disel;
        this.kerosene = kerosene;
    }

    public double getB93() {
        return b93;
    }

    public void setB93(double b93) {
        this.b93 = b93;
    }

    public double getB95() {
        return b95;
    }

    public void setB95(double b95) {
        this.b95 = b95;
    }

    public double getB97() {
        return b97;
    }

    public void setB97(double b97) {
        this.b97 = b97;
    }

    public double getDisel() {
        return disel;
    }

    public void setDisel(double disel) {
        this.disel = disel;
    }

    public double getKerosene() {
        return kerosene;
    }

    public void setKerosene(double kerosene) {
        this.kerosene = kerosene;
    }
    
    
}
