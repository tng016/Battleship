import java.util.Scanner;

public class BattleshipApp
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int xStart=0,xEnd=0,yStart=0,yEnd=0;

		System.out.println("===================");
		System.out.println("=== BattleShips ===");
		System.out.println("===================");

		Board board = new Board();
		Ship aircraftcarrier = new Ship(5,"Aircraft Carrier");
		board.addShip(aircraftcarrier);
		Ship battleship = new Ship(4,"Battleship");
		board.addShip(battleship);
		Ship submarine = new Ship(3,"Submarine");
		board.addShip(submarine);
		Ship cruiser = new Ship(3,"Cruiser");
		board.addShip(cruiser);
		Ship patrolship = new Ship(2,"Patrol Ship");
		board.addShip(patrolship);

		board.printBoard();

		for (Ship ship : board.ships)
		{
			System.out.println("Where would you like to place your "+ ship.name);
			do{
				System.out.println("row start");
				xStart = sc.nextInt();
				System.out.println("col start");
				yStart = sc.nextInt();
				System.out.println("row end");
				xEnd = sc.nextInt();
				System.out.println("col end");
				yEnd = sc.nextInt();
				ship.setPosition(xStart,yStart,xEnd,yEnd);
			} while(checkInput(xStart,yStart,xEnd,yEnd,ship,board) == -1);
			
			ship.setPosition(xStart,yStart,xEnd,yEnd);
			board.setShip(ship);
			board.printBoard();
		}

	}

	public static int checkInput(int xStart,int yStart,int xEnd,int yEnd,Ship ship,Board board)
	{
		if (((xEnd-xStart+1)==ship.length && yEnd == yStart)||((yEnd-yStart+1)==ship.length && xEnd == xStart))
			for (int i=0;i<ship.length;i++)
			{
				if(board.isOccupied(ship.getPosition(i,0),ship.getPosition(i,1))==0)
					return 0;
				else
					System.out.println("This spot is occupied!");
					return -1;
			}
			
		else{
			System.out.println("Error Input");
		}
		return -1;
	}
}