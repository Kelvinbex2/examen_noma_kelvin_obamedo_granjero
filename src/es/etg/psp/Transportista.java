package es.etg.psp;

public class Transportista implements Runnable {
    private static final int TIEMPO = 2000;
    private Granja granja;

    public Transportista(Granja granja) {
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

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(TIEMPO);
                granja.transportar(Thread.currentThread().getName());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        
    }

}
