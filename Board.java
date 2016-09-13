public class Board
{
	private static int LENGTH = 10;
   private char[][] board = new char[10][10];
   public Battleship battleship;
   public Aircraftcarrier aircraftcarrier;
   public Submarineandcruiser submarine;
   public Submarineandcruiser cruiser;
   public Patrolship patrolship;
   public char empty = '_';
   public char bship = 'B';
   public char air = 'A';
   public char sub = 'S';
   public char cru = 'C';
   public char patrol = 'P';


   public Board(){
      for (int i=0;i<LENGTH;i++){
         for (int j=0;j<LENGTH;j++){
            board[i][j] = empty;
         }
      }
   }


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

   public void setShip(){
      int x,y;
      for (int i=0; i<4; i++){
         x = battleship.getPosition(i,0);
         y = battleship.getPosition(i,1);
         board[x][y] = air;
      }
      System.out.println("ship set!");
   }

   public void addShip(Battleship battleship){
      this.battleship = battleship;
   }

   public void addAC(Aircraftcarrier aircraftcarrier){
      this.aircraftcarrier = aircraftcarrier;
   }

}