/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scapefromceep;

import Dominio.Arma;
import Dominio.Edificio;
import Dominio.Habitacion;
import Dominio.Metodos;
import static Dominio.Metodos.*;
import Dominio.Jugador;
import java.util.ArrayList;
import java.util.Scanner;

/** 
                   _________ 
                  |_  | ___ \
                    | | |_/ /
      Autor:        | | ___ \
                /\__/ | |_/ /
                \____/\____/ 

 */
public class ScapeFromCeep {


    public static void main(String[] args) {

        //METODOS DE LA INTERFAZ
        Metodos metodos = new Metodos();

        // ARRAY DE JUGADORES. ¿SOLO 1, ES NECESARIO UN ARRAY?
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        // ARRAY BIDIMENSIONAL DE HABITACIONES
        Habitacion[][] habitaciones = new Habitacion[5][3];

        //ARRAY DE ARMAS
        ArrayList<Arma> armasHabitacion = new ArrayList<Arma>();

        //METODO PARA CREAR AL JUGADOR - INTERFAZ
        metodos.crearJugador(jugadores);

        //METODO PARA CREAR LAS ARMAS Y AÑADIRLOS AL ARRAY DE ARMAS - INTERFAZ
        metodos.crearArmas(armasHabitacion);
        
        //METODO PARA RELLENAR EL EDIFICIO DE HABITACIONES - INTERFAZ
        metodos.rellenarHabitaciones(habitaciones,armasHabitacion);

        //METODO PARA MOSTRAR EL EDIFICIO - INTERFAZ
        mostrarEdificio(habitaciones);

        
        Habitacion habitacionInicial = habitaciones[0][0];
        Jugador jugador1 = jugadores.get(0);

        jugador1.cambiarHabitacionActual(habitacionInicial);

        System.out.println(jugador1.getNombre() + " ESTA EN LA HABITACION " + jugador1.getHabitacionActual().getNumeroHabitacion());

        //METODO PARA MOVER AL JUGADOR POR EL EDIFICIO - INTERFAZ
        metodos.movimiento(jugadores.get(0), habitaciones);
        
        

    }

}
