package tercerparcial;

public class Tarjeta {
    private String nombre;
    private String referenciaImagen;
    private int posicion;
    private boolean encontrada;
    private boolean volteada;

    // Constructor
    public Tarjeta(String nombre, String referenciaImagen, int posicion) {
        this.nombre = nombre;
        this.referenciaImagen = referenciaImagen;
        this.posicion = posicion;
        this.encontrada = false;
        this.volteada = false;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferenciaImagen() {
        return referenciaImagen;
    }

    public void setReferenciaImagen(String referenciaImagen) {
        this.referenciaImagen = referenciaImagen;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public boolean isEncontrada() {
        return encontrada;
    }

    public void setEncontrada(boolean encontrada) {
        this.encontrada = encontrada;
    }

    public boolean isVolteada() {
        return volteada;
    }

    public void setVolteada(boolean volteada) {
        this.volteada = volteada;
    }
}