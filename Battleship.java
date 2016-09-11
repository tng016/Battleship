public class Battleship
{
   private static int LENGTH = 4;
   private int[] position; 
   
   // constructor
   public Battleship(int start,int middle1,int middle2,int end){
      position = new int[4];
      position[0] = start;
      position[1] = middle1;
      position[2] = middle2;
      position[3] = end;
   }

   // print circumference  
   public int[] getposition(){
      return position;
   }
   /*
   // mutator method – set radius
   public void setBattleship(){
   		radius = rad;
   }
   // accessor method – get radius
   public double getRadius(){
   		return radius;
   }
   // calculate area
   public double area(){
   		return (PI * radius * radius);
   }
   // calculate circumference
   public double circumference() {
   		return (2*PI*radius);
   }
   // print area
   public void printArea(){
   		System.out.println("Area is " + (PI * radius * radius));
   }
   */

}