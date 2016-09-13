import java.util.Scanner;

public class BattleshipApp
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int xStart=0,xEnd=0,yStart=0,yEnd=0;

		System.out.println("=== BattleShips ===");

		Board board = new Board();
		System.out.println("Board Created");

		Battleship battleship = new Battleship();
		System.out.println("Battleship Created of length "+battleship.getLength());

		Aircraftcarrier aircraftcarrier = new Aircraftcarrier();
		System.out.println("Aircraft Carrier Created of length "+aircraftcarrier.getLength());

		Submarineandcruiser submarine = new Submarineandcruiser();
		System.out.println("Submarine Created of length "+submarine.getLength());

		Submarineandcruiser cruiser = new Submarineandcruiser();
		System.out.println("Cruiser Created of length "+cruiser.getLength());

		Patrolship patrolship = new Patrolship();
		System.out.println("Patrolship Created of length "+patrolship.getLength());

		board.printBoard();

		System.out.println("Where would you like to place your Aircraftcarrier?");
		System.out.println("X start");
		xStart = sc.nextInt();
		System.out.println("Y start");
		yStart = sc.nextInt();
		System.out.println("X start");
		xStart = sc.nextInt();
		System.out.println("Y start");
		yStart = sc.nextInt();

		aircraftcarrier.setPosition(xStart,yStart,xEnd,yEnd);
		board.addAC(aircraftcarrier);




		battleship.setPosition(1,1,4,1);
		System.out.println("Position set");
		System.out.println(battleship.position[0][0]);
		System.out.println(battleship.position[0][1]);
		System.out.println(battleship.position[3][0]);
		System.out.println(battleship.position[3][1]);

		

		board.printBoard();

		board.addShip(battleship);
		System.out.println("Ship added");


		board.setShip();
		System.out.println("Ship Set");

		board.printBoard();

		

		/*Scanner sc = new Scanner(System.in);
		int startx,starty,endx,endy;
		System.out.printf("Start x:");
		startx = sc.nextInt();
		System.out.printf("Start y:");
		starty = sc.nextInt();
		System.out.printf("End x:");
		endx = sc.nextInt();
		System.out.printf("End y:");
		endy = sc.nextInt();

		Battleship b = new Battleship(startx,starty,endx,endy);
		b.printBattleship();*/
		
	}
}