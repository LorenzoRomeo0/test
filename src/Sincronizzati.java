public class Sincronizzati {
    int index=0;
    char data[]= new char[2];
  public void push(char c)
 {
     
     
  synchronized (this)
  {
   data [index] = c;
   index++;
  }
 }

 public char pop()
 {
  synchronized (this)
  {
   index--;
   return data[index];
  }
 }   
}
