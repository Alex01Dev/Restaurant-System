/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteamli;

/**
 *
 * @author PC 11
 */
public class pilaClientes {
     public int dato;
     public int platillo;
     public int bebida;
     public int postre;
     public double costo;
    public pilaClientes siguiente;
    
    
    //Constructor cuando la pila está vacía
     public pilaClientes(int d, pilaClientes n, int pl, int po, int be, double co)
    {
        platillo = pl;
        bebida = be;
        postre = po;
        dato = d;
        siguiente =  n;
        costo = co;
        
    }
    
    public pilaClientes(int d, int pl, int po, int be, double co){
        this.platillo = pl;
        this.bebida = be;
        this.postre = po;
        this.dato = d;
        this.costo = co;
        this.siguiente = null; 
    }
}
