/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteamli;

/**
 *
 * @author Gerardo Bonilla
 */
public class nodoStock {
    public int dato;
    public nodoStock siguiente;
    
    //Constructor 
    public nodoStock(int d, nodoStock n)
    {
        dato = d;
        siguiente =  n;
        
    }
    
    public nodoStock(int d){
        this.dato = d;
        this.siguiente = null; 
    }
}
