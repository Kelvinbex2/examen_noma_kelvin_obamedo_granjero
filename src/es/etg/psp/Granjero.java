package es.etg.psp;

public class Granjero implements Runnable {

    private static final int TIEMPO = 100;
    private Granja granja;

    public Granjero(Granja granja) {
        this.granja = granja;
    }

    public Granja getGranja() {
        return granja;
    }

    public void setGranja(Granja granja) {
        this.granja = granja;
    }

    @Override
    public void run() {

       while (true) {
        try {
            Thread.sleep(TIEMPO);
            granja.almacenar(Thread.currentThread().getName());
        } catch (InterruptedException e) {
           throw new RuntimeException(e);
        }
       }
        
    }

}