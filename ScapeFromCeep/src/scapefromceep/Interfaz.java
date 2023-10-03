/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package scapefromceep;

import Dominio.Arma;
import Dominio.Habitacion;
import Dominio.Jugador;
import java.util.ArrayList;

/** 
                   _________ 
                  |_  | ___ \
                    | | |_/ /
      Autor:        | | ___ \
                /\__/ | |_/ /
                \____/\____/ 

 */

public interface Interfaz {
    public void crearJugador(ArrayList<Jugador> Jugador);
    public void crearArmas(ArrayList<Arma> ArmasHabitacion);
    public void rellenarHabitaciones(Habitacion[][] habitaciones);
    public void movimiento(Jugador jugador1, Habitacion[][] habitaciones);
    public boolean moverJugador(Jugador jugador, Habitacion[][] habitaciones, String direccion);
}
