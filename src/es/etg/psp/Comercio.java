package es.etg.psp;

public class Comercio {

    public static void main(String[] args) {
        Granja granja = new Granja();
        Thread granjero = new Thread(new Granjero(granja));
        Thread transportista = new Thread(new Transportista(granja));

        granjero.start();
        transportista.start();
    }
}
