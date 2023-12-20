/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restauranteamli;

import javax.swing.JOptionPane;

/**
 *
 * @author PC 11
 */
public class metodosRestaurante {
    int newPla, newBe, newPo;
        //Platillos
        metodosStock stockFilete = new metodosStock();
        metodosStock stockRisoto = new metodosStock();
        metodosStock stockSalmon = new metodosStock();
        metodosStock stockCordero = new metodosStock();
        metodosStock stockTartar = new metodosStock();
        
        //Bebidas
        metodosStock stockMartini = new metodosStock();
        metodosStock stockCoctel = new metodosStock();
        metodosStock stockGinTonic = new metodosStock();
        metodosStock stockVinoBlanco = new metodosStock();
        metodosStock stockCafe = new metodosStock();
        
        //Postres
        metodosStock stockSuffle = new metodosStock();
        metodosStock stocktiramisu = new metodosStock();
        metodosStock stockMousse = new metodosStock();
        metodosStock stockCrumble = new metodosStock();
        metodosStock stockPanaCotta = new metodosStock();
        
    protected pilaClientes inicio, fin;
    protected double costoTotalRestaurante;
    protected int totalClientes;
    private int numeroTurnoActual;
    
    public metodosRestaurante() {
        inicio = null;
        fin = null;
        costoTotalRestaurante = 0.0;
        totalClientes = 0;
        numeroTurnoActual = 1;
    }

    public int tomarNuevoTurno() {
        return numeroTurnoActual++;
    }


    public boolean listaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertaInicio(int turno, int pl, int po, int be, double co) {
        pilaClientes nuevoCliente = new pilaClientes(turno, pl, po, be, co);
        
        if (inicio == null || turno == 1) {
            inicio = nuevoCliente;
            fin = nuevoCliente;
        }else{
            nuevoCliente.siguiente = inicio;
            inicio = nuevoCliente;
            //System.out.println("\n el inicio es: " + inicio.dato);
        }
        costoTotalRestaurante += co;
        totalClientes++;
    }

    public void tomarPedido(int turno, int pl, int po, int be) {
        pilaClientes recorrido = inicio;
        boolean encontrado = false;
      
        
        while (recorrido != null) {
            if (recorrido.dato == turno) {
                System.out.println("\n ATENDIENDO AL TURNO: " + recorrido.dato);
                encontrado = true;
                newPla = Integer.parseInt(JOptionPane.showInputDialog(null, "\n 0.- Omitir"
                        + "\n 1.-Filete Mignon con Salsa de Trufa Negra($577.45)"
                        + "\n 2.-Risotto de Langosta con Espárragos Trigueros($789.56)"
                        + "\n 3.-Salmón Gravlax con Eneldo y Mostaza de Dijon($675.78)"
                        + "\n 4.-Cordero en Costra de Hierbas con Puré de Papas Trufado($700.45)"
                        + "\n 5.-Tartar de Atún con Aguacate y Sésamo($468.66)"
                        + "\n INGRESA EL NUMERO DEL PLATILLO: "));
                newBe = Integer.parseInt(JOptionPane.showInputDialog(null, "\n 0.- Omitir"
                        + "\n 1.-Martini de Lavanda y Albahaca($125.88)"
                        + "\n2.-Cóctel de Maracuyá y Jengibre($230.25)"
                        + "\n3.-Gin Tónico con Bayas de Enebro y Pimienta Rosa($145.44)"
                        + "\n4.-Vino Blanco Sauvignon Blanc de la Región de Marlborough($150.34)"
                        + "\n5.-Café de Especialidad con Infusión de Vainilla y Canela($115.67)"
                        + "\n -INTRODUCE EL NUMERO DE LA BEBIDA: "));
                newPo = Integer.parseInt(JOptionPane.showInputDialog(null, "\n 0.- Omitir"
                        + "\n1.-Soufflé de Chocolate Negro con Salsa de Frutos Rojos($250.45)"
                        + "\n2.-Tiramisú de Café Espresso y Amaretto($190.45)"
                        + "\n3.-Mousse de Mango con Coulis de Maracuyá($223.23)"
                        + "\n4.-Crumble de Manzana con Helado de Vainilla Tahitiana(240.56)"
                        + "\n5.-Panna Cotta de Lavanda con Miel de Trufa Blanca($218.34)"
                        + "\n -INTRODUCE EL NUMERO DEL POSTRE: "));

                pl = newPla;
                be = newBe;
                po = newPo;
                //System.out.println("costo" + costosPlatillos(pl));

                double costoPlatillo = costosPlatillos(pl);
                double costoBebida = costosBebidas(be);
                double costoPostre = costosPostres(po);

                //System.out.println(costoBebida);
                //System.out.println(costoPostre);

                recorrido.platillo = newPla;
                recorrido.bebida = newBe;
                recorrido.postre = newPo;

                recorrido.costo = costoPlatillo + costoBebida + costoPostre;
                System.out.println("\n----LISTA DE TURNOS Y PEDIDOS----");
            }
            recorrido = recorrido.siguiente;

        }
        if (!encontrado) {
             StringBuilder mensaje = new StringBuilder();
                mensaje.append("--- Cliente no encontrado ---\n");
                 JOptionPane.showMessageDialog(null, mensaje.toString(), ""
                         + "Información", JOptionPane.INFORMATION_MESSAGE);
        }

    }

// Método para mostrar la información al final 
public int mostrarInformacionFinal(int turno) {
    StringBuilder mensaje = new StringBuilder();
    mensaje.append("--- Información Final ---\n");
    mensaje.append("Número total de clientes: ").append(totalClientes).append("\n");

    if (totalClientes > 0) { // Verifica si hay clientes antes de intentar mostrar sus costos
        pilaClientes recorrido = inicio;
        double costoTotalClientes = 0.0;

        while (recorrido != null) {
            mensaje.append("Cliente ").append(recorrido.dato).append(": $").append(recorrido.costo).append("\n");
            costoTotalClientes += recorrido.costo;
            recorrido = recorrido.siguiente;
        }

        mensaje.append("Total venta del día: ").append(costoTotalClientes);

        // Reinicia las variables
        costoTotalRestaurante = 0.0;
        totalClientes = 0;
        System.err.println("\nReiniciando Los Turnos");
        System.err.println(" \n\nInventario al realizar el corte de caja:");
             System.out.println("\n\n PLATILLOS:");
            System.out.println("\n\n Stock Filete Mignon:");
            stockFilete.mostrarLista();
            System.out.println("\n\n Stock Rissoto de Langosta:");
            stockRisoto.mostrarLista();
            System.out.println("\n\n Stock Salmón Gravlax:");
            stockSalmon.mostrarLista();
            System.out.println("\n\n Stock Cordero en costra:");
            stockCordero.mostrarLista();
            System.out.println("\n\n Stock Tartar de atún:");
            stockTartar.mostrarLista();
            
              System.out.println("\n\n BEBIDAS:");
            System.out.println("\n\n Stock Martini de Lavanda:");
            stockMartini.mostrarLista();
            System.out.println("\n\n Stock  Coctél de Maracuyá:");
            stockCoctel.mostrarLista();
            System.out.println("\n\n Stock Gin Tonico con Bayas:");
            stockGinTonic.mostrarLista();
            System.out.println("\n\n Stock Vino Blanco:");
            stockVinoBlanco.mostrarLista();
            System.out.println("\n\n Stock Café de especialidad :");
            stockCafe.mostrarLista();
            
            System.out.println("\n\n POSTRES:");
            System.out.println("\n\n Stock Soufflé de Chocolate:");
            stockSuffle.mostrarLista();
            System.out.println("\n\n Stock Tiramisú de Café:");
            stocktiramisu.mostrarLista();
            System.out.println("\n\n Stock Mousse de Mango:");
            stockMousse.mostrarLista();
            System.out.println("\n\n Stock Crumble de Manzana:");
            stockCrumble.mostrarLista();
            System.out.println("\n\n Stock Panna Cotta de Lavanda:");
            stockPanaCotta.mostrarLista();
    } else {
        mensaje.append("No hay clientes para mostrar.");
    }

    JOptionPane.showMessageDialog(null, mensaje.toString(), "Información Final", JOptionPane.INFORMATION_MESSAGE);
    numeroTurnoActual = 1;
    return turno = 1;
     
}


    public double costosPlatillos(int pl) {
        String elemento = "";
        System.out.print(pl);
        if (pl > 5) {
            System.out.println("No sucede nada");
            return 0.0;
        } else if (pl <= 5) {
            switch (pl) {
                case 1:
                        elemento = "Filete Mignon";
                        int consulta1 = stockFilete.eliminarPrincipio(elemento);
                        //stockFilete.mostrarLista();
                        if(consulta1 == 0){
                            newPla = 0;
                            return 0;
                        }
                    return 577.45;
                case 2:
                    elemento = "Rissoto de Langosta";
                        int consulta2 = stockRisoto.eliminarPrincipio(elemento);
                        //stockRisoto.mostrarLista();
                        if(consulta2 == 0){
                            newPla = 0;
                            return 0;
                        }
                    return 789.56;
                case 3:
                    elemento = "Salmón Gravlax";
                        int consulta3 = stockSalmon.eliminarPrincipio(elemento);
                        //stockSalmon.mostrarLista();
                        if(consulta3 == 0){
                            newPla = 0;
                            return 0;
                        }
                    return 675.78;
                case 4:
                    elemento = "Cordero en Costra";
                        int consulta4 = stockCordero.eliminarPrincipio(elemento);
                        //stockCordero.mostrarLista();
                        if(consulta4 == 0){
                            newPla = 0;
                            return 0;
                        }
                    return 700.45;
                case 5:
                     elemento = "Tartar de Atún";
                        int consulta5 = stockTartar.eliminarPrincipio(elemento);
                        //stockTartar.mostrarLista();
                        if(consulta5 == 0){
                            newPla = 0;
                            return 0;
                        }
                    return 468.66;
                default:
                    return 0.0;
            }

        }
        return 0.0;
    }

    public double costosBebidas(int be) {
         String elementoBe = "";
        if (be > 5) {
            System.out.println("No sucede nada");
            return 0.0;
        } else if (be <= 5) {
            switch (be) {
                case 1:
                    elementoBe = "Martini de Lavanda";
                        int consulta6 = stockMartini.eliminarPrincipio(elementoBe);
                        //stockMartini.mostrarLista();
                        if(consulta6 == 0){
                            newBe = 0;
                            return 0;
                        }
                    return 125.88;
                case 2:
                    elementoBe = "Coctél de Maracuyá";
                        int consulta7 = stockCoctel.eliminarPrincipio(elementoBe);
                        //stockCoctel.mostrarLista();
                        if(consulta7 == 0){
                            newBe = 0;
                            return 0;
                        }
                    return 230.25;
                case 3:
                    elementoBe = "Gin Tonico con Bayas";
                        int consulta8 = stockGinTonic.eliminarPrincipio(elementoBe);
                        //stockGinTonic.mostrarLista();
                        if(consulta8 == 0){
                            newBe = 0;
                            return 0;
                        }
                    return 145.44;
                case 4:
                    elementoBe = "Vino Blanco";
                        int consulta9 = stockVinoBlanco.eliminarPrincipio(elementoBe);
                        //stockVinoBlanco.mostrarLista();
                        if(consulta9 == 0){
                            newBe = 0;
                            return 0;
                        }
                    return 150.34;
                case 5:
                    elementoBe = "Café de especialidad ";
                        int consulta10 = stockCafe.eliminarPrincipio(elementoBe);
                        //stockCafe.mostrarLista();
                        if(consulta10 == 0){
                            newBe = 0;
                            return 0;
                        }
                    return 115.67;
                default:
                    return 0.0;
            }
        }
        return 0.0;
    }

    public double costosPostres(int po) {
         String elementoPo = "";
        if (po > 5) {
            System.out.println("No sucede nada");
            return 0.0;
        } else if (po <= 5) {
            switch (po) {
                case 1:
                    elementoPo = "Soufflé de Chocolate ";
                    int consulta10 = stockSuffle.eliminarPrincipio(elementoPo);
                        //stockSuffle.mostrarLista();
                        if(consulta10 == 0){
                            newPo = 0;
                            return 0;
                        }
                    return 250.45;
                case 2:
                    elementoPo = "Tiramisú de Café ";
                    int consulta11 = stocktiramisu.eliminarPrincipio(elementoPo);
                        //stocktiramisu.mostrarLista();
                        if(consulta11 == 0){
                            newPo = 0;
                            return 0;
                        }
                    return 190.45;
                case 3:
                    elementoPo = "Mousse de Mango ";
                    int consulta12 = stockMousse.eliminarPrincipio(elementoPo);
                        //stockMousse.mostrarLista();
                        if(consulta12 == 0){
                            newPo = 0;
                            return 0;
                        }
                    return 223.23;
                case 4:
                     elementoPo = " Crumble de Manzana";
                    int consulta13 = stockCrumble.eliminarPrincipio(elementoPo);
                        //stockCrumble.mostrarLista();
                        if(consulta13 == 0){
                            newPo = 0;
                            return 0;
                        }
                    return 240.56;
                case 5:
                    elementoPo = "Panna Cotta de Lavanda";
                    int consulta14 = stockPanaCotta.eliminarPrincipio(elementoPo);
                        //stockPanaCotta.mostrarLista();
                        if(consulta14 == 0){
                            newPo = 0;
                            return 0;
                        }
                    return 218.34;
                default:
                    return 0.0;
            }
        }
        return 0.0;
    }

 public void mostrarLista() {
    VentanaRestaurante ventana = new VentanaRestaurante();

    if (!listaVacia()) {
        pilaClientes recorrido = inicio;
        while (recorrido != null) {
            ventana.mostrarLista(recorrido);
            recorrido = recorrido.siguiente;
        }
    } else {
        ventana.mostrarLista(null);
    }
}

    public void crearStock(){
        int filetes, rissoto, salmon, cordero, tartar, martini, coctel, ginTonic,
                vinoBlanco, cafe, souffle, tiramisu, mousse, crumble, panaCotta;
        
            filetes = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Filete Mignon: "));
            for(int i = 1; i < filetes+1; i++){
              stockFilete.agregarAlFin(i);
            }
            
            //------------------
            //------------------
            rissoto = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Rissoto de Langosta: "));
            for(int i = 1; i < rissoto+1; i++){
              stockRisoto.agregarAlFin(i);
            }
           
            //------------------
            //------------------
            salmon = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Salmón Gravlax: "));
            for(int i = 1; i < salmon+1; i++){
              stockSalmon.agregarAlFin(i);
            }

            //------------------
            //------------------
            cordero = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Cordero en costra: "));
            for(int i = 1; i < cordero+1; i++){
              stockCordero.agregarAlFin(i);
            }
            
            //------------------
            //------------------
            tartar = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Tartar de atún: "));
            for(int i = 1; i < tartar+1; i++){
              stockTartar.agregarAlFin(i);
            }
            
            //------------------
            //------------------
            martini = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Martini de Lavanda: "));
            for(int i = 1; i < martini+1; i++){
              stockMartini.agregarAlFin(i);
            }
            //------------------
            //------------------
             coctel = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Coctél de Maracuyá: "));
            for(int i = 1; i < coctel+1; i++){
              stockCoctel.agregarAlFin(i);
            }
            //------------------
            //------------------
            ginTonic = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Gin Toinico con Bayas: "));
            for(int i = 1; i < ginTonic+1; i++){
              stockGinTonic.agregarAlFin(i);
            }
            //------------------
            //------------------
            vinoBlanco = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Vino Blanco : "));
            for(int i = 1; i < vinoBlanco+1; i++){
              stockVinoBlanco.agregarAlFin(i);
            }
            //------------------
            //------------------
            cafe = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Café de especialidad: "));
            for(int i = 1; i < cafe+1; i++){
              stockCafe.agregarAlFin(i);
            }
            //------------------
            //------------------
            souffle = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Soufflé de Chocolate: "));
            for(int i = 1; i < souffle+1; i++){
              stockSuffle.agregarAlFin(i);
            }
            //------------------
            //------------------
            tiramisu = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Tiramisú de Café: "));
            for(int i = 1; i < tiramisu+1; i++){
              stocktiramisu.agregarAlFin(i);
            }
            //------------------
            //------------------
             mousse = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Mousse de Mango: "));
            for(int i = 1; i < mousse+1; i++){
              stockMousse.agregarAlFin(i);
            }
            //------------------
            //------------------
             crumble = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de  Crumble de Manzana: "));
            for(int i = 1; i < crumble+1; i++){
              stockCrumble.agregarAlFin(i);
            }
            //------------------
            //------------------
            panaCotta = Integer.parseInt(JOptionPane.showInputDialog(null, "Stock de Panna Cotta de Lavanda: "));
            for(int i = 1; i < panaCotta+1; i++){
              stockPanaCotta.agregarAlFin(i);
            }
            //------------------
            //------------------
            System.out.println("\n\n PLATILLOS:");
            System.out.println("\n\n Stock Filete Mignon:");
            stockFilete.mostrarLista();
            System.out.println("\n\n Stock Rissoto de Langosta:");
            stockRisoto.mostrarLista();
            System.out.println("\n\n Stock Salmón Gravlax:");
            stockSalmon.mostrarLista();
            System.out.println("\n\n Stock Cordero en costra:");
            stockCordero.mostrarLista();
            System.out.println("\n\n Stock Tartar de atún:");
            stockTartar.mostrarLista();
            
              System.out.println("\n\n BEBIDAS:");
            System.out.println("\n\n Stock Martini de Lavanda:");
            stockMartini.mostrarLista();
            System.out.println("\n\n Stock  Coctél de Maracuyá:");
            stockCoctel.mostrarLista();
            System.out.println("\n\n Stock Gin Tonico con Bayas:");
            stockGinTonic.mostrarLista();
            System.out.println("\n\n Stock Vino Blanco:");
            stockVinoBlanco.mostrarLista();
            System.out.println("\n\n Stock Café de especialidad :");
            stockCafe.mostrarLista();
            
            System.out.println("\n\n POSTRES:");
            System.out.println("\n\n Stock Soufflé de Chocolate:");
            stockSuffle.mostrarLista();
            System.out.println("\n\n Stock Tiramisú de Café:");
            stocktiramisu.mostrarLista(); 
            System.out.println("\n\n Stock Mousse de Mango:");
            stockMousse.mostrarLista();
            System.out.println("\n\n Stock Crumble de Manzana:");
            stockCrumble.mostrarLista();
            System.out.println("\n\n Stock Panna Cotta de Lavanda:");
            stockPanaCotta.mostrarLista();
    }

}
