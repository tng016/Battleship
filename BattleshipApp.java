import java.util.Scanner;

public class BattleshipApp
{
	public static void main(String[] args)
	{
		Board board = new Board();
		board.printBoard();
		Battleship bblack = new Battleship(1,2,3,4);
		board.printInfo();

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