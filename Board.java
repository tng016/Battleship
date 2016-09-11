public class Board
{
	private static int LENGTH = 10;
	private static int WIDTH = 10;

   public Battleship battleshipblack;

	public void printBoard(){
      System.out.println("   A B C D E F G H I J");
      int x = 1;
      while (x <= 10){
         System.out.printf("%2d",x);
      	System.out.println("|X|_|_|_|_|_|_|_|_|_|");
      	x++;
      }
   }

   public void printInfo(){
      int[] x = new int[4];
      x = battleshipblack.getposition();
      System.out.println(Arrays.toString(x));
   }

}