public class Ship
{
   public int length;
   public int[][] position; 
   public String name;
   public char symbol;
   public int damage=0;
   public boolean isSunk = false;
   
   // constructor
   public Ship(int length,String name){
      this.length = length;
      this.name = name;
      this.symbol = name.charAt(0);
   }

   public void setPosition(int startx,int starty,int endx,int endy){
      position = new int[length][2];
      if (startx == endx){
         for (int i=0; i<length; i++){
            position[i][0] = startx;
            position[i][1] = starty + i;
         }  
      }
      else{
         for (int i=0; i<length; i++){
            position[i][0] = startx + i;
            position[i][1] = starty;
         }  
      }
   }

   public boolean checkSunk(){
      if(damage == length){
         this.isSunk = true;
         return true;
      }
      else
         return false;
   }
}