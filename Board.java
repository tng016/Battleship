public class Board
{
	private final static int LENGTH = 10;
   private static int shipcount = 0;
   public char[][] board = new char[10][10];
   public Ship[] ships = new Ship[5];
   public char empty = '_';

   //Constructor
   public Board(){
      for (int i=0;i<LENGTH;i++){
         for (int j=0;j<LENGTH;j++){
            board[i][j] = empty;
         }
      }
   }

   //Prints what is on the board now
	public void printBoard(){
      System.out.println("   A B C D E F G H I J");
      for (int i=0; i<LENGTH; i++){
         System.out.printf("%2d",i+1);
         for (int j=0; j<LENGTH; j++){
            System.out.printf("|"+board[i][j]);
         }
         System.out.println("|");
      }
   }

   public void addShip(Ship ship){
      this.ships[shipcount] = ship;
      shipcount ++;
   }

   public void setShip(Ship ship){
      int x,y;
      for (int i=0; i<ship.length; i++){
         x = ship.getPosition(i,0);
         y = ship.getPosition(i,1);
         board[x][y] = ship.symbol;
      }
      System.out.println("ship set!");
   }

   public int isOccupied(int x, int y){
      if(board[x][y] == empty)
         return 0;
      else
         return -1;
   }
}