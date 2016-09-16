import java.util.Scanner;

public class BattleshipApp
{
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("===================");
		System.out.println("=== BattleShips ===");
		System.out.println("===================");

		Board whiteBoard = new Board(); 
		Board blackBoard = new Board(); 

		fakeboards(whiteBoard);
		fakeboards(blackBoard);

		/*System.out.println("\n======= White Player Setting Up Board =======");
		createShip("Aircraft Carrier",5,whiteBoard);
		createShip("Battleship",4,whiteBoard);
		createShip("Cruiser",3,whiteBoard);
		createShip("Submarine",3,whiteBoard);
		createShip("Patrol Ship",2,whiteBoard);
		whiteBoard.printBoard();
		userPlaceShip(whiteBoard);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n======= Black Player Setting Up Board =======");
		createShip("Aircraft Carrier",5,blackBoard);
		createShip("Battleship",4,blackBoard);
		createShip("Cruiser",3,blackBoard);
		createShip("Submarine",3,blackBoard);
		createShip("Patrol Ship",2,blackBoard);
		blackBoard.printBoard();
		userPlaceShip(blackBoard);*/

		int turn_number = 0;
		Board whiteAttackBlack = new Board(); 
		Board blackAttackWhite = new Board();
		System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); 
		do{
			
			if (turn_number%2 ==0){
				System.out.printf("=== It's White's turn ===\n");
				printBothBoards(blackAttackWhite,whiteAttackBlack);
				userFire(blackBoard,whiteAttackBlack);

			}
			else{
				System.out.printf("=== It's Black's turn ===\n");
				printBothBoards(blackAttackWhite,whiteAttackBlack);
				userFire(whiteBoard,blackAttackWhite);
			}
			turn_number++;
		}	while(gameover(whiteBoard,blackBoard) == 0);
		printBothBoards(blackAttackWhite,whiteAttackBlack);
	}

	public static int checkInput(int xStart,int yStart,int xEnd,int yEnd,Ship ship,Board board)
	{
		if(xStart>=0 && yStart>=0 && xEnd<10 && yEnd<10){
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
		else
			System.out.println("Out of Range!");
			return -1;
	}

	public static int chartoint(char c)
	{
		return Character.toUpperCase(c) - 65;	
	}

	public static void createShip(String name, int size, Board board)
	{
		Ship ship = new Ship(size,name);
		board.addShip(ship);
	}

	public static void userPlaceShip(Board board)
	{
		int xStart=0,xEnd=0,yStart=0,yEnd=0;
		String inputStr;
		for (Ship ship : board.ships)
		{
			System.out.println("Where would you like to place your "+ ship.name);
			do{
				System.out.println("start");
				inputStr = sc.next();
				xStart = chartoint(inputStr.charAt(0));
				yStart = Character.getNumericValue(inputStr.charAt(1));
				System.out.println("end");
				inputStr = sc.next();
				xEnd = chartoint(inputStr.charAt(0));
				yEnd = Character.getNumericValue(inputStr.charAt(1));
				ship.setPosition(xStart,yStart,xEnd,yEnd);
			} while(checkInput(xStart,yStart,xEnd,yEnd,ship,board) == -1);
			board.setShip(ship);
			board.printBoard();
		}
	}

	public static void printBothBoards(Board white,Board black){
		System.out.printf(" ===== White's Ships ===== %10c ===== Black's Ships =====\n",' ');
    	System.out.printf("   0 1 2 3 4 5 6 7 8 9  %15c 0 1 2 3 4 5 6 7 8 9\n",' ');
    	for (int i=0; i<10; i++){
    	    System.out.printf("%2c",i+97);//prints A-J
    	    for (int j=0; j<10; j++)
    	        System.out.printf("|"+white.board[i][j]);
    	    System.out.printf("|%14c",' ');
    	    System.out.printf("%2c",i+97);
    	    for (int k=0; k<10; k++)
    	        System.out.printf("|"+black.board[i][k]);
    	    System.out.println("|");
      	}
   	}

   	public static int gameover(Board white,Board black)
	{
		if (white.shipcount == 0){
			System.out.println(" ========Gameover!========\n Black is the Winner!");
			return 1;
		}
		else if (black.shipcount == 0){
			System.out.println(" ========Gameover!========\n White is the Winner!");
			return 2;
		}
		else
			return 0;
	}

	public static void userFire(Board attacking,Board display)
	{
		int xInput=0,yInput=0;
		String inputStr;
		Ship shiptemp;

		do{
			System.out.println("Where would you like to fire onto?");
			inputStr = sc.next();
			xInput = chartoint(inputStr.charAt(0));
			yInput = Character.getNumericValue(inputStr.charAt(1));
		} while(checkFireInput(xInput,yInput,display) == -1);
		if (attacking.board[xInput][yInput] == attacking.empty)
			display.board[xInput][yInput] = display.miss;
		else{
			display.board[xInput][yInput] = display.hit;
			shiptemp = attacking.getShip(xInput,yInput);
			shiptemp.damage++;

			if(shiptemp.checkSunk()	== true){
				System.out.println("You have sunk the enemy's "+shiptemp.name);
				attacking.shipcount--;
			}
		}
		

	}

	public static int checkFireInput(int x,int y,Board board)
	{
		if(x>=0 && y>=0 && x<10 && y<10){
			if (board.board[x][y] == board.miss || board.board[x][y] == board.hit){
				System.out.println("You've fired there before!");
				return -1;
			}
			else
				return 0;
		}
		else
			System.out.println("Out of Range!");
			return -1;
	}

	public static void fakeboards(Board board)
	{
		createShip("Aircraft Carrier",5,board);
		createShip("Battleship",4,board);
		createShip("Cruiser",3,board);
		createShip("Submarine",3,board);
		createShip("Patrol Ship",2,board);
		int i = 1;
		for (Ship ship : board.ships)
		{
			
			ship.setPosition(i,i,i,ship.length);
			board.setShip(ship);
			board.printBoard();
			i++;
		}
	}
}
