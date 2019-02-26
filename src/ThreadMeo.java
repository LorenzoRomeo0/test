import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

class ThreadMeo extends Thread {

	String tab;
	final static int MASSIMO= (Integer.MAX_VALUE / 3) - 1;
	final static int target_Chan= new Random().nextInt(MASSIMO);
	final DecimalFormat df = new DecimalFormat("#,###,##0.0000");
	final static ArrayList<String>	classifica = new ArrayList<String>();

	private ThreadMeo(String a, String tab) {
		super(a);
		this.tab = tab;
	}

	public static void main(String[] args) {
		System.out.println("Il numero da indovinare �: " + target_Chan);
		Thread t1 = new ThreadMeo("Pippo", "");
		Thread t2 = new ThreadMeo("Sebastian", "\t\t");
		Thread t3 = new ThreadMeo("Mushu", "\t\t\t\t");
		Thread t4 = new ThreadMeo("Jake", "\t\t\t\t\t\t");
		try {
			sleep(1000);
		} catch (Exception e) {
		}
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (Exception e) {
			// non faccio un cavolo di nulla HAHAHAHAHA
		}
		System.out.println(new String(new char[69]).replace("\0", "#"));
		for (int i = 0; i < classifica.size(); i++) {
			System.out.println((i + 1) + ") " + classifica.get(i));
		}
	}

	public void run() {
		int max = MASSIMO;
		int min = 0;
		int guess = -1;
		double t = System.nanoTime();
		do {
			try {
				sleep(200);
			} catch (Exception e) {
			}
			guess = new Random().nextInt((max - min) + 1) + min;
			if (guess > target_Chan)
				max = guess - 1;
			if (guess < target_Chan)
				min = guess + 1;
			System.out.println(guess + " - " + this.tab + getName());

		} while (guess != target_Chan);
		t = System.nanoTime() - t;

		classifica.add(getName() + " in " + df.format(t / 1000000000));
	}
}