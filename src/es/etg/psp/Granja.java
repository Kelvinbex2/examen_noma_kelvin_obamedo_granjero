package es.etg.psp;

public class Granja {
    public static final int MAX_TRANSPORTISTA = 120;
    public static final int MAX_GRANJERO = 120;
    private static final String MSG_GRAN = "Se han almacenado %d huevos";
    private static final String MSG_TRAN = "---------------------------------\nSe han transportado %d huevos\n---------------------------------  \n";
    public static final int HUEVO = 12;

    private int huevo;

    public synchronized void almacenar(String id) throws InterruptedException {
       

        while (huevo >= MAX_GRANJERO) {
            wait();
        }
        
        if (huevo <= 120) {
            huevo += HUEVO;
            System.out.println();
            System.out.println(String.format(MSG_GRAN, huevo) + System.lineSeparator());
            notifyAll();
        }
       
    }

    public synchronized void transportar(String id) throws InterruptedException {
        
        while (huevo < MAX_TRANSPORTISTA) {
            wait();
        }
        
        huevo -= MAX_TRANSPORTISTA;
        System.out.println(String.format(MSG_TRAN, MAX_TRANSPORTISTA) );
        notifyAll(); 
    }


}
