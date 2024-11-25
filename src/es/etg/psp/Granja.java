package es.etg.psp;

public class Granja {
    public static final int MAX_TRANSPORTISTA = 120;
    public static final int MAX = 120;
    public static final int MAX_GRANJERO = 150;
    private static final String MSG_GRAN = "Se ha almacenado %d huevos";
    private static final String MSG_TRAN = "Se ha restado %d huevos";
    public static final int HUEVO = 12;
    

    private int huevo;

    public synchronized void almacenar(String id) throws InterruptedException {
     
        if (huevo > MAX_GRANJERO) {
            wait();
        }
        notify();
        huevo = HUEVO;

        System.out.println(String.format(MSG_GRAN, huevo) + System.lineSeparator());

    }

    public synchronized void transportar(String id) throws InterruptedException {
        if (huevo > MAX_TRANSPORTISTA) {
            this.wait();
        }
        huevo--;
        this.notify();
        System.out.println(String.format(MSG_TRAN, huevo));

    }

    public int getHuevo() {
        return huevo;
    }
}
