/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteamli;

import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo Bonilla
 */
public class metodosStock {
    protected nodoStock inicio,fin;
    
    public metodosStock(){
        inicio = null;
        fin = null;
    }
    public boolean listaVacia (){
        if(inicio == null){
            return true;
        }else{
            return false;
        }
    }
    
    public void agregarAlFin(int d){
        if(!listaVacia()){
            fin.siguiente=new nodoStock( d);
            fin=fin.siguiente;
        }else{
            inicio= fin = new nodoStock(d);
        }
    }
    
    public int eliminarPrincipio(String elemento){
        //System.out.println("El valor eliminado fue: "+ inicio.dato);
        if(listaVacia()){
             StringBuilder mensaje = new StringBuilder();
                mensaje.append("--- Ya no hay "+elemento+" ---\n");
                 JOptionPane.showMessageDialog(null, mensaje.toString(), ""
                         + "Información", JOptionPane.INFORMATION_MESSAGE);
                 return 0;
        }else{
           if(inicio == fin){
            inicio = fin = null;
            StringBuilder mensaje = new StringBuilder();
                mensaje.append("--- Esta fue la última pieza de "+elemento+" ya no hay más ---\n");
                 JOptionPane.showMessageDialog(null, mensaje.toString(), ""
                         + "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
               inicio = inicio.siguiente;
            } 
        }
        return 1;
        
    }
    
    public void mostrarLista(){
        nodoStock recorrido = inicio;
        //System.out.println(" ");
        while (recorrido  != null){
            System.out.print("["+ recorrido.dato+"] -->");
            recorrido = recorrido.siguiente;
        }
    }
}
