
public class Coda2 {
	 int current_queue = 0; /*
									 * Num richieste servite + richieste in coda
									 */
	 int current_served = 0; /*
									 * ID richiesta correntemente in servizio. Nel caso si abbiano pi� classi di
									 * richieste, per esempio a diversa priorit�, si pu� considerare l'uso di
									 * strutture dati come array o liste
									 */

	public synchronized int acquire() {
		int my_pos = current_queue; /*
									 * Posizione del thread corrente nella coda: variabile my_pos su stack locale
									 * del thread
									 */
		System.out.println("Thread " + my_pos + " entrato in attesa rilascio posizione in coda");
		current_queue++;
		try {
			while (my_pos != current_served) { /*
												 * Attesa del proprio turno; qui si pu� valutare una qualsiasi
												 * condizione di accodamento senza attese attive
												 */
				wait();
			}
		} catch (InterruptedException e) {
		}

		System.out.println("Thread " + my_pos + " in servizio");
		return my_pos;
	}

	public synchronized void release(int my_pos) {
		// Fine del servizio
		current_served++; // Incremento # della richiesta attualmente servita
		System.out.println("Thread " + my_pos + " servito");
		notifyAll(); /*
						 * Notifica tutti i thread in coda di attesa che la loro condizione di servizio
						 * diventi vera � evitata attesa attiva
						 */
	}
}