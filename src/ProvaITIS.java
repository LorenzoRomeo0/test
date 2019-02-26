
import java.io.*;
import java.lang.*;

class Avvio extends Thread {

    int tempo = 0, tempTOT;
    String pos;

    public static void main(String args[]) {
        Avvio t1 = new Avvio("");
        Avvio t2 = new Avvio("\t");
        Avvio t3 = new Avvio("\t\t");

        t1.start();
        t2.start();
        t3.start();
    }

    Avvio(String num) {
        this.pos = num;
    }

    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {

                tempo = (int) ((Math.random() * 1000) + 500);
                tempTOT = tempTOT + tempo;
                Thread.sleep(tempo);
                System.out.println(pos + i);

            }
            System.out.println(tempTOT);
        } catch (Exception e) {
        }
    }

}
