public class Board
{
	private final static int LENGTH = 10;
   public int shipcount = 0;
   public char[][] board = new char[10][10];
   public Ship[] ships = new Ship[5];
   public char empty = '_';
   public char hit = 'X';
   public char miss = 'O';


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
      System.out.printf("   0 1 2 3 4 5 6 7 8 9 \n");
      for (int i=0; i<LENGTH; i++){
         System.out.printf("%2c",i+97);
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

      public Ship getShip(int x, int y){
      for(Ship ship : ships){
         for(int i=0;i<ship.length;i++){
            if (ship.position[i][0] == x && ship.position[i][1] == y)
               return ship;
         }
      }
      return null;
   }
}