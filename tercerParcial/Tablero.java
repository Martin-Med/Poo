package tercerparcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tablero {
    private Tarjeta[][] tarjetas;
    private int paresConstruidos;

    public Tablero() {
        tarjetas = new Tarjeta[4][4];
        paresConstruidos = 0;
        inicializarTablero();
    }

    private void inicializarTablero() {
        // Crear las 8 parejas de tarjetas
        List<Tarjeta> listaTarjetas = new ArrayList<>();
        String[] nombres = {"Gato", "Perro", "León", "Águila", "Delfín", "Tigre", "Jirafa", "Elefante"};
        
        // Crear 2 tarjetas por cada nombre
        for (String nombre : nombres) {
            for (int i = 0; i < 2; i++) {
                listaTarjetas.add(new Tarjeta(nombre, "imagen_" + nombre, 0));
            }
        }

        // Mezclar solo los nombres de las tarjetas
        Collections.shuffle(listaTarjetas);

        // Asignar tarjetas al tablero con numeración secuencial
        int contador = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Tarjeta tarjeta = listaTarjetas.get(i * 4 + j);
                tarjeta.setPosicion(contador);
                tarjetas[i][j] = tarjeta;
                contador++;
            }
        }
    }

    public boolean compararTarjetas(int posicion1, int posicion2) {
        Tarjeta tarjeta1 = obtenerTarjeta(posicion1);
        Tarjeta tarjeta2 = obtenerTarjeta(posicion2);

        if (tarjeta1.getNombre().equals(tarjeta2.getNombre())) {
            tarjeta1.setEncontrada(true);
            tarjeta2.setEncontrada(true);
            paresConstruidos++;
            return true;
        }
        return false;
    }

    public Tarjeta obtenerTarjeta(int posicion) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (tarjetas[i][j].getPosicion() == posicion) {
                    return tarjetas[i][j];
                }
            }
        }
        return null;
    }

    public boolean juegoTerminado() {
        return paresConstruidos == 8;
    }

    public void mostrarTablero() {
        System.out.println("Tablero actual:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Tarjeta tarjeta = tarjetas[i][j];
                if (tarjeta.isEncontrada()) {
                    System.out.print("[" + tarjeta.getPosicion() + ":" + tarjeta.getNombre() + "]\t");
                } else if (tarjeta.isVolteada()) {
                    System.out.print("[" + tarjeta.getPosicion() + ":" + tarjeta.getNombre() + "]\t");
                } else {
                    System.out.print("[" + tarjeta.getPosicion() + ":X]\t");
                }
            }
            System.out.println();
        }
    }
}