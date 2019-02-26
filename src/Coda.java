public class Coda extends Thread {
	 /*
	 * ogni thread acquisisce la risorsa entrando esplicitamente in coda e uscendo
	 * dalla coda dopo aver terminato di usare la risorsa. Disciplina di
	 * programmazione
	 */

	

	
	
	public void run() {
		
		int pos = AvvioCoda.queue.acquire(); // Accodamento della richiesta
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		// Simulazione delle operazioni
		AvvioCoda.queue.release(pos); // Rilascio della coda
	}
}