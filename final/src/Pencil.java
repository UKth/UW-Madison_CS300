public class Pencil extends Writer implements Eraserable{
   public void e(){}
   public void f(){}
   
   
   public static void main(String[] args) {
      Writer w1 = new Pencil();
      Eraserable e1 = (Eraserable) w1;
      w1.x();
      w1.e();
   }
}