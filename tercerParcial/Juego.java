package tercerparcial;

import java.util.Scanner;

public class Juego {
    private Tablero tablero;
    private Scanner scanner;

    public Juego() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("--- MEMORAMA ---");
            System.out.println("1.- Jugar");
            System.out.println("2.- Salir");
            System.out.print("Elija una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    System.out.println("¡Gracias por jugar!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private int seleccionarTarjeta(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            int tarjeta = scanner.nextInt();

            // Validar rango de tarjetas
            if (tarjeta < 1 || tarjeta > 16) {
                System.out.println("Opción no válida. Ingrese un número del 1 al 16");
                continue;
            }

            // Validar si la tarjeta ya fue encontrada
            Tarjeta tarjetaSeleccionada = tablero.obtenerTarjeta(tarjeta);
            if (tarjetaSeleccionada.isEncontrada()) {
                System.out.println("Esta tarjeta ya fue encontrada. Elija otra.");
                continue;
            }

            tarjetaSeleccionada.setVolteada(true);
            return tarjeta;
        }
    }

    private void jugar() {
        tablero = new Tablero();
        int intentos = 0;

        while (!tablero.juegoTerminado()) {
            tablero.mostrarTablero();
            
            // Seleccionar primera tarjeta
            int tarjeta1 = seleccionarTarjeta("Seleccione la primera tarjeta (1-16): ");

            // Seleccionar segunda tarjeta
            int tarjeta2 = seleccionarTarjeta("Seleccione la segunda tarjeta (1-16): ");

            // Comparar tarjetas
            if (tarjeta1 == tarjeta2) {
                System.out.println("No puede seleccionar la misma tarjeta dos veces.");
                tablero.obtenerTarjeta(tarjeta1).setVolteada(false);
                continue;
            }

            if (tablero.compararTarjetas(tarjeta1, tarjeta2)) {
                System.out.println("¡Par encontrado!");
            } else {
                System.out.println("Las tarjetas no coinciden.");
                tablero.obtenerTarjeta(tarjeta1).setVolteada(false);
                tablero.obtenerTarjeta(tarjeta2).setVolteada(false);
            }

            intentos++;
        }

        System.out.println("¡Felicidades! Ha encontrado todos los pares en " + intentos + " intentos.");
    }

    public static void main(String[] args) {
        Juego memorama = new Juego();
        memorama.mostrarMenuPrincipal();
    }
}