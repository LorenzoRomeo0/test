import java.util.ArrayList;

public class Esercizio_2 extends Thread {
	String nome,spazio,tab;
	public Esercizio_2(String nome, String spazio,String tab) {
		this.nome=nome;
		this.spazio=spazio;
		this.tab=tab;
	}
	static ArrayList A=new ArrayList();
	static ArrayList B=new ArrayList();
	public static void main(String[] args) {
		Esercizio_2 obj1=new Esercizio_2("Ferrari","\n","Ferrari");
		Esercizio_2 obj2=new Esercizio_2("\tMercedes","\n\t","Mercedes");
		Esercizio_2 obj3=new Esercizio_2("\t\tMcLaren","\n\t\t","McLaren");
		obj1.start();
		obj2.start();
		obj3.start();
	}
	public void run() {
		int ran=0;
		int secondi=0;
		int mille=0;
		int temp=0;
		try {
			for(int i=0;i<20;i++) {
				System.out.println(nome);
				ran=(int) ((Math.random()*1000)+500);
				temp=ran+temp;	
				secondi=temp/1000;
				mille=temp-(secondi*1000);
				Thread.sleep(ran);
			}
			System.out.println(nome+spazio+secondi+"."+mille);
		}catch(Exception e) {
			
		}
		A.add(tab);
		B.add(secondi+"."+mille);
				
		if(A.size()==3) {
			
		System.out.println("\nClassifica:");
			
			for(int i=0;i<3;i++) {
				
				System.out.println((i+1)+" " + A.get(i) + " "+ B.get(i));
				
			}
		}
	}

}