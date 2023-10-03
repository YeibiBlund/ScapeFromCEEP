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
public class Arma {

      
    // Conjunto de Propiedades
    private int idArma;
    private String nombre;
    private int nivel;
    private int ataque;
    private int duracion;
    
    private static int contador = 0;

    public Arma(int idArma) {
        this.idArma = contador++;
    }
        
    public Arma(int idArma, String nombre, int nivel, int ataque, int duracion) {
        this.idArma = idArma;
        this.nombre = nombre;
        this.nivel = nivel;
        this.ataque = ataque;
        this.duracion = duracion;
    }

    public int getIdArma() {
        return idArma;
    }

    public void setIdArma(int idArma) {
        this.idArma = idArma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Arma{");
        sb.append("idArma=").append(idArma);
        sb.append(", nombre=").append(nombre);
        sb.append(", nivel=").append(nivel);
        sb.append(", ataque=").append(ataque);
        sb.append(", duracion=").append(duracion);
        sb.append('}');
        return sb.toString();
    }

    
    
    
}
