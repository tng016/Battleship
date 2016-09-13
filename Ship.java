public class Ship
{
   protected int length;
   public int[][] position; 
   public String name;
   public char symbol;
   
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
            position[i][0] = startx-1;
            position[i][1] = starty + i-1;
         }  
      }
      else{
         for (int i=0; i<length; i++){
            position[i][0] = startx + i-1;
            position[i][1] = starty-1;
         }  
      }
   }

   public void printPosition(){
      for (int i=0; i<length; i++){
         for (int j=0; j<2; j++){
            System.out.printf("%d",position[i][j]);
         }
         System.out.println(" ");
      }
   }

   public int getPosition(int x,int y){
      return position[x][y];
   }

   public int getLength(){
      return length;
   }

   public void setName(String name){
      this.name = name;
   }
}