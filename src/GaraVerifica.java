import java.util.*;
public class GaraVerifica extends Thread{
    char base[]={'a','b','c','d','e','o'};
    static int c0=0, c1=0;
    public static void risultati() {
    	System.out.println(" 0 =" + c0 + " 1 =" + c1);
    }
    
    public void run() {
        char a[] = new char[3];
        int c=0;
        
        int pos = VerificaThread.queue.acquire(); // Accodamento della richiesta
        while(c<100){
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
		}
		 for (int i = 0; i<3; i++){
                    a[i]=base[(int)(Math.random()*3)];
                    
                 }
                fai(a, pos);
                VerificaThread.queue.release(pos); // Rilascio della coda
                c++;
        }
       
    }
        
    
    public static void fai(char[] a, int pos){
       
        for (int i = 0; i<3; i++)
        System.out.print(" - " + a[i]);
        
         System.out.println();
        
        if (a[0]=='a' && a[1]=='c' && a[2]=='a'){ 
            System.out.println(pos + "   ha indovinato!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if(pos==0)
            	c0++;
            else
            	c1++;
           
        }else {
            System.out.println(pos +  " ha  sbagliato" );
         
        }
        risultati();
		
	}
               
    }
    


