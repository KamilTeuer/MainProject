package cz.MyTest.TestJava;

// Řazení vláken pomocí zděděné třídy Thread:
class Vlakno extends Thread {

    public Vlakno(String jmeno) {
        super(jmeno);
    }

    @Override
    public void run() {
    System.out.println("Vlákno " + getName() + " spuštěno");
        for(int i = 0; i < 4; ++i) {
            System.out.println("Vlákno " + getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Vlákno " + getName() + " přerušeno");
        return;
            }
        }
    System.out.println("Vlákno " + getName() + " ukončeno");
    }

    public static void main(String[] args) {
        System.out.println("Hlavní vlákno spuštěno");
        Vlakno mojeVlakno = new Vlakno("Druhe");
        mojeVlakno.start();
        for(int i = 0; i < 4; ++i) {
            System.out.println("Hlavní vlákno: " + i);
            try {
                Thread.sleep(750);
            } catch (InterruptedException ex) {
                System.out.println("Hlavní vlákno přerušeno");
            return;
            }
        }
        System.out.println("Hlavní vlákno ukončeno");
    }

}
