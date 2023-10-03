/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/** 
                   _________ 
                  |_  | ___ \
                    | | |_/ /
      Autor:        | | ___ \
                /\__/ | |_/ /
                \____/\____/ 

 */
public class Jugador {
    
    // Conjunto de Propiedades
    private int idJugador;
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int cansancio;
    private int nivel;
    
    private Habitacion habitacionActual;

    public Jugador() {
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }
    
    public Jugador(Habitacion habitacionActual) {
        this.habitacionActual = habitacionActual;
    }
    
    public Jugador(String nombre, Habitacion habitacionActual) {
        this.nombre = nombre;
        this.habitacionActual = habitacionActual;
    }
    
    public void cambiarHabitacionActual(Habitacion nuevaHabitacion) {
        this.habitacionActual = nuevaHabitacion;
    }

    
    public Jugador(int idJugador, String nombre, int vida, int ataque, int defensa, int cansancio, int nivel) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.cansancio = cansancio;
        this.nivel = nivel;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getCansancio() {
        return cansancio;
    }

    public void setCansancio(int cansancio) {
        this.cansancio = cansancio;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador{");
        sb.append("idJugador=").append(idJugador);
        sb.append(", nombre=").append(nombre);
        sb.append(", vida=").append(vida);
        sb.append(", ataque=").append(ataque);
        sb.append(", defensa=").append(defensa);
        sb.append(", cansancio=").append(cansancio);
        sb.append(", nivel=").append(nivel);
        sb.append('}');
        return sb.toString();
    }

    public Habitacion getHabitacionActual() {
        return habitacionActual;
    }

    public void setHabitacionActual(Habitacion habitacionActual) {
        this.habitacionActual = habitacionActual;
    }
    
    
    
}
