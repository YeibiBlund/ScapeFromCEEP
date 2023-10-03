/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;

/** 
                   _________ 
                  |_  | ___ \
                    | | |_/ /
      Autor:        | | ___ \
                /\__/ | |_/ /
                \____/\____/ 

 */
public class Habitacion {

    private int numeroHabitacion;
    //private boolean habitacionCentral;
    private int fila;
    private int columna;
    private static int contador = 0;
    private ArrayList<Arma> listaArmasHabitacion;

    public Habitacion(int fila, int columna, boolean habitacionCentral) {
        this.numeroHabitacion = contador++;
        this.fila = fila;
        this.columna = columna;
        this.listaArmasHabitacion = new ArrayList<>();
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int aContador) {
        contador = aContador;
    }

    public ArrayList<Arma> getListaArmasHabitacion() {
        return listaArmasHabitacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Habitacion{");
        sb.append("numeroHabitacion=").append(numeroHabitacion);
        sb.append('}');
        return sb.toString();
    }
}
