/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import scapefromceep.Interfaz;

/** 
                   _________ 
                  |_  | ___ \
                    | | |_/ /
      Autor:        | | ___ \
                /\__/ | |_/ /
                \____/\____/ 

 */
public class Metodos implements Interfaz {

    public static final int MAX_FILA = 4;
    public static final int MAX_COLUMNA = 2;

    //=======================================================================================================================================
    // CREAR / RELLENAR OBJETOS
    //=======================================================================================================================================
    //CREAR JUGADOR
    public void crearJugador(ArrayList<Jugador> Jugador) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("INTRODUCE TU NOMBRE: ");
        String nombre = scanner.nextLine();

        Jugador Jugador1 = new Jugador(nombre);
        
        Jugador.add(Jugador1);
    }
    public void crearArmas(ArrayList<Arma> armas) {
    // Bucle para crear los objetos y asignarles valores
        //                 ID- NOMBRE -NIVEL -ATAQUE -DURACION
        armas.add(new Arma(1, "PALO ", 1, 10, 100));
        armas.add(new Arma(2, "PALO ", 1, 10, 100));
        armas.add(new Arma(3, "PALO ", 1, 10, 100));
        armas.add(new Arma(4, "PALO ", 1, 10, 100));
        armas.add(new Arma(5, "CUCHILLO ", 1, 10, 100));
        armas.add(new Arma(6, "CUCHILLO ", 1, 10, 100));
        armas.add(new Arma(7, "CUCHILLO ", 1, 10, 100));
        armas.add(new Arma(8, "CUCHILLO ", 1, 10, 100));
        armas.add(new Arma(9, "LANZA ", 1, 10, 100));
        armas.add(new Arma(10, "LANZA ", 1, 10, 100));
        armas.add(new Arma(11, "LANZA ", 1, 10, 100));
        armas.add(new Arma(12, "LANZA ", 1, 10, 100));
        armas.add(new Arma(13, "ARMA ", 1, 10, 100));
        armas.add(new Arma(14, "ARMA ", 1, 10, 100));
        armas.add(new Arma(15, "ARMA ", 1, 10, 100));
        armas.add(new Arma(16, "ARMA ", 1, 10, 100));
        armas.add(new Arma(17, "ARMA ", 1, 10, 100));
        armas.add(new Arma(18, "ARMA ", 1, 10, 100));
        armas.add(new Arma(19, "ARMA ", 1, 10, 100));
        armas.add(new Arma(20, "ARMA ", 1, 10, 100));
        armas.add(new Arma(21, "ARMA ", 1, 10, 100));
        armas.add(new Arma(22, "ARMA ", 1, 10, 100));
    
    // Imprimir los objetos creados
    for (Arma a : armas) {
        System.out.println(a);
    }
}

    
    

    //RELLENAR HABITACIONES 
//    public void rellenarHabitaciones(Habitacion[][] habitaciones) {
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 3; j++) {
//                boolean esCentral = (j == 1 && i != 0);
//                Habitacion habitacion = new Habitacion(i, j, esCentral);
//                habitaciones[i][j] = habitacion;
//            }
//        }
//    }
    public void rellenarHabitaciones(Habitacion[][] habitaciones, ArrayList<Arma> armas) {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 3; j++) {
            boolean esCentral = (j == 1 && i != 0);
            Habitacion habitacion = new Habitacion(i, j, esCentral);
            habitaciones[i][j] = habitacion;
            if (j == 0 || j == 2) {
                Arma armaAleatoria = armas.get(new Random().nextInt(armas.size()));
                habitacion.getListaArmasHabitacion().add(armaAleatoria);
            }
        }
    }
}
    

    //=======================================================================================================================================
    // LOGICA DEL JUEGO
    //=======================================================================================================================================
    //BUCLE PARA EL MOVIMIENTO 
    public void movimiento(Jugador jugador1, Habitacion[][] habitaciones) {
        // Movemos al jugador
        Scanner scanner = new Scanner(System.in);
        String direccion;
        int turnos = 10;
        while (jugador1.getVida()>=0) {
            do {
                dibujoMovimientos();
                direccion = scanner.nextLine().toUpperCase();
            } while (!moverJugador(jugador1, habitaciones, direccion));

            //NUEVA HABITACION
            imprimirEspacios();
            System.out.println(jugador1.getNombre() + " ESTA EN LA HABITACION " + jugador1.getHabitacionActual().getNumeroHabitacion());
            turnos--;

            // Si el jugador está en la posición [0][0], se llama al método "men()"
            if (jugador1.getHabitacionActual().getFila() == 0 && jugador1.getHabitacionActual().getColumna() == 0) {
                menu(jugador1,habitaciones);
                break;
            }
            mostrarEdificio(habitaciones);
        }
    }

    //METODO QUE ME COMPRUEBA Y MUEVE AL JUGADOR.
    public boolean moverJugador(Jugador jugador, Habitacion[][] habitaciones, String direccion) {
        Habitacion habitacionActual = jugador.getHabitacionActual();
        int filaActual = habitacionActual.getFila();
        int columnaActual = habitacionActual.getColumna();

        if (direccion.equals("A") && columnaActual > 0) {
            jugador.cambiarHabitacionActual(habitaciones[filaActual][columnaActual - 1]);
            return true;
        } else if (direccion.equals("D") && columnaActual < MAX_COLUMNA) {
            jugador.cambiarHabitacionActual(habitaciones[filaActual][columnaActual + 1]);
            return true;
        } else if (direccion.equals("W") && filaActual > 0 && columnaActual == 1) {
            jugador.cambiarHabitacionActual(habitaciones[filaActual - 1][columnaActual]);
            return true;
        } else if (direccion.equals("S") && filaActual < MAX_FILA && columnaActual == 1) {
            jugador.cambiarHabitacionActual(habitaciones[filaActual + 1][columnaActual]);
            return true;
        } else {
            System.out.println("MOVIMIENTO INVALIDO");
            return false;
        }
    }

    //=======================================================================================================================================
    // INTERFAZ GRAFICA / DIBUJOS
    //=======================================================================================================================================
    public static void obtenerColumna(Jugador jugador) {
        int columnaActual = jugador.getHabitacionActual().getColumna();
        if (columnaActual == 0) {
            System.out.println("COLUMNA IZQUIERDA");
        } else if (columnaActual == 1) {
            System.out.println("\t\t\tCOLUMNA CENTRAL");
            System.out.println(" _____________________________________________\n"
                    + "|.'',                                     ,''.|                     \n"
                    + "|.'.'',                                 ,''.'.|                    \n"
                    + "|.'.'.'',                             ,''.'.'.|                    \n"
                    + "|.'.'.'.'',                         ,''.'.'.'.|                    \n"
                    + "|.'.'.'.'.|                         |.'.'.'.'.|               CEEP         \n"
                    + "|.'.'.'.'.|===;                 ;===|.'.'.'.'.|          _____ _____ _____          \n"
                    + "|.'.'.'.'.|:::|',             ,'|:::|.'.'.'.'.|      P4 |  0  |  1  |  2  |               ______________________________________________                    \n"
                    + "|.'.'.'.'.|---|'.|, _______ ,|.'|---|.'.'.'.'.|         |_____|_____|_____|              |                                              |                    \n"
                    + "|.'.'.'.'.|:::|'.|'|???????|'|.'|:::|.'.'.'.'.|      P3 |  3  |  4  |  5  |              |                  -----------                 |                    \n"
                    + "|,',',',',|---|',|'|???????|'|,'|---|,',',',',|         |_____|_____|_____|              |                 |     W     |                |                    \n"
                    + "|.'.'.'.'.|:::|'.|'|???????|'|.'|:::|.'.'.'.'.|      P2 |  6  |  7  |  8  |              |                 |  ARRIBA   |                |                    \n"
                    + "|.'.'.'.'.|---|','   /%%%\\   ','|---|.'.'.'.'.|         |_____|_____|_____|              |                 |           |                |                   \n"
                    + "|.'.'.'.'.|===:'    /%%%%%\\    ':===|.'.'.'.'.|      P1 |  9  | 10  | 11  |              |      ----------- ----------- -----------     |\n"
                    + "|.'.'.'.'.|%%%%%%%%%%%%%%%%%%%%%%%%%|.'.'.'.'.|         |_____|_____|_____|              |     |     A     |     S     |     D     |    |\n"
                    + "|.'.'.'.','       /%%%%%%%%%\\       ','.'.'.'.|      P0 | 12  | 13  | 14  |              |     | IZQUIERDA |   ABAJO   |  DERECHA  |    |\n"
                    + "|.'.'.','        /%%%%%%%%%%%\\        ','.'.'.|         |_____|_____|_____| SALIDA       |     |           |           |           |    |\n"
                    + "|.'.','         /%%%%%%%%%%%%%\\         ','.'.|                                          |      ----------- ----------- -----------     |\n"
                    + "|.','          /%%%%%%%%%%%%%%%\\          ','.|                                          |______________________________________________|\n"
                    + "|;____________/%%%  RELLANO  %%%%\\____________|");
        } else {
            System.out.println("COLUMNA DERECHA");
        }
    }

    //ESTE METODO ME MUESTRA EL EDIFICIO CON LOS NUMEROS DE LAS HABITACIONES. 
    public static void mostrarEdificioSimple(Habitacion[][] habitaciones) {

        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {
                System.out.print(habitaciones[i][j].getNumeroHabitacion() + " ");
            }
            System.out.println();

        }
    }

    public static void mostrarEdificio(Habitacion[][] habitaciones) {

        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {
                System.out.print("    " + habitaciones[i][j].getNumeroHabitacion() + " ");
            }
            System.out.println();
            for (int j = 0; j < habitaciones[i].length; j++) {
                System.out.print("[ ");
                for (int k = 0; k < habitaciones[i][j].getListaArmasHabitacion().size(); k++) {
                    System.out.print(habitaciones[i][j].getListaArmasHabitacion().get(k).getNombre() + " ");
                }
                System.out.print("] ");
            }
            System.out.println();
        }
    }

    //DIBUJO PARA LA OPCION DE ELEGIR MOVIMIENTO
    private static void dibujoMovimientos() {
        System.out.println("              ¿HACIA DONDE QUIERE MOVERTE?");
        System.out.println(" _____________________________________________________________");
        System.out.println("|                                                             |");
        System.out.println("|                        -----------                          |");
        System.out.println("|                       |     W     |                         |");
        System.out.println("|                       |  ARRIBA   |                         |");
        System.out.println("|                       |           |                         |");
        System.out.println("|            ----------- ----------- -----------              |");
        System.out.println("|           |     A     |     S     |     D     |             |");
        System.out.println("|           | IZQUIERDA |   ABAJO   |  DERECHA  |             |");
        System.out.println("|           |           |           |           |             |");
        System.out.println("|            ----------- ----------- -----------              |");
        System.out.println("|_____________________________________________________________|");
    }

    //=======================================================================================================================================
    // METODOS DE ESPACIOS / TIEMPO / ETC....
    //=======================================================================================================================================
    private static void imprimirEspacios() {

        for (int i = 0; i < 20; i++) {
            System.out.println("");
        }
    }

    public void menu(Jugador jugador1, Habitacion[][] habitaciones) {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("\n-------- MENU --------");
        System.out.println("1. VOLVER A MOVERSE");
        System.out.println("2. VER DATOS DEL JUGADOR");
        System.out.println("3. VER NUMERO DE HABITACION ACTUAL");
        System.out.println("4. VER COORDENADAS HABITACION ACTUAL");
        System.out.println("5. SALIR.");

        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                movimiento(jugador1, habitaciones);
                break;
            case 2:
                System.out.println("FICHA JUGADOR: " + jugador1);
                break;
            case 3:
                System.out.println("HABITACION ACTUAL: " + jugador1.getHabitacionActual().getNumeroHabitacion());
                break;
            case 4:
                System.out.println("COORDENADAS DE LA HABITACION ACTUAL: (" + jugador1.getHabitacionActual().getFila() + "," + jugador1.getHabitacionActual().getColumna() + ")");
                break;
            case 5:
                System.out.println("FIN DEL JUEGO");
                break;
            default:
                System.out.println("OPCION INVALIDA");
                break;
        }
    } while (opcion != 5);
}

    @Override
    public void rellenarHabitaciones(Habitacion[][] habitaciones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
