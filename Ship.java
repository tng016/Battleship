public class Ship
{
   protected int length;
   public int[][] position; 
   
   // constructor
   public Ship(){
     
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

   public void setLength(int length){
      this.length = length;
   }
}