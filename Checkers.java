//Almitra Dabholkar
//December 22, 2017
import java.util.*;

public class Checkers {
	
	public static String player1Name, player2Name;	
	public static int p1Counter, p2Counter;  
	public static int p1JumpCounter = 1;
	public static int p2JumpCounter = 1;
	public static int p1CurrentX = 0;
	public static int p1CurrentY = 0;
	public static int p1NewX = 0;
	public static int p1NewY = 0;
	public static int p2CurrentX = 0;
	public static int p2CurrentY = 0;
	public static int p2NewX = 0;
	public static int p2NewY = 0;
	public static int p2JumpCurrentX = 0;
	public static int p2JumpCurrentY = 0;
	public static int p1JumpCurrentX = 0;
	public static int p1JumpCurrentY = 0;
	
	public static Scanner input = new Scanner (System.in);
	
	
	public static void main(String[] args) {
		
		//RULES
		System.out.println("Rules:");
		System.out.println("Player 1 will be x and Player 2 will be tile o.");
		System.out.println("Player 1 enter your name: ");
		player1Name = input.nextLine();
		System.out.println("Player 2 enter your name: ");
		player2Name = input.nextLine();
		System.out.println(player1Name + " is x and " + player2Name + " is o. ");
		System.out.println( );	
		System.out.println("Here is the initial board: ");
		System.out.println();
		
		
		
		//CREATING ARRAY OBJECTS
		Pieces [][] checkerBoard = new Pieces [8][8];
		
		for (int i = 0; i < checkerBoard.length; i++) {
			for (int j = 0; j < checkerBoard.length; j++ ) {
				checkerBoard[i][j] = new Pieces ();
			}//end inner for loop
		}//end outer for loop
			
		
		
		//CREATING ARRAY ELEMENTS
		for (int i = 0; i < checkerBoard.length; i++) {
			for (int j = 0; j < checkerBoard.length; j++ ) {
				
				if (i >= 0 && i<= 2 ){
					if (i % 2 == 0 && j % 2 == 0) {
						checkerBoard[i][j].setPieceName("[x]");
					}
					else if ((i-1) % 2 == 0 && (j-1) % 2 == 0) {
						checkerBoard[i][j].setPieceName("[x]");
					}
					else {
						checkerBoard[i][j].setPieceName("[ ]");	
					}
				}//end 0-2 if statement
				
				if (i >= 3 && i<= 4 ) {
					checkerBoard[i][j].setPieceName("[ ]");
				}//end 3-4 if statement
				
				if (i >= 5 && i <= 7) {
					if (i % 2 == 0 && j % 2 == 0) {
						checkerBoard[i][j].setPieceName("[o]");
					}
					else if ((i-1) % 2 == 0 && (j-1) % 2 == 0) {
						checkerBoard[i][j].setPieceName("[o]");
					}
					else {
						checkerBoard[i][j].setPieceName("[ ]");	
					}
				}//end 5-7 if statement	
				
			}//end inner for loop
		}//end outer for loop
		
		int i = 0, j = 0;
		printBoard(checkerBoard, i, j);
		
		
		//USERS ENTER THEIR MOVE
		int x = 1;
		while (x == 1) {
			
			p1CurrentCoordinate(checkerBoard, i, j);
			if (p1IfKing(checkerBoard, i, j)) {	
				p1NewCoordinateKing(checkerBoard, i, j);
	
			}
			else if (!p1IfKing(checkerBoard, i, j)) {
				p1NewCoordinate(checkerBoard, i, j);
			}
			if (p1Counter == 12) {
				System.out.println(player1Name + " wins!");
				break;
			}//end p1 wins if
		
			
			p2CurrentCoordinate(checkerBoard, i, j);
			if (p2IfKing(checkerBoard, i, j)) {
				p2NewCoordinateKing(checkerBoard, i, j);
			}
			else if (!p2IfKing(checkerBoard, i, j)) {
				p2NewCoordinate(checkerBoard, i, j);
			}
			if (p2Counter == 12) {
				System.out.println(player2Name + " wins!");
				break;
			}//end p2 wins if

		}//end while loop
		
		input.close();

	}//end Main 
	
	public static void printBoard(Pieces[][]checkerBoard,int i, int j) {
		
		System.out.println("                " + player1Name + " " +p1Counter); 
		System.out.println();
		System.out.println("column 0   1   2   3   4   5   6   7");
		
		for (i = 0; i < checkerBoard.length; i++) {
			System.out.print( "row " + i + " ");
			for (j = 0; j < checkerBoard.length; j++ ) {
				System.out.print(checkerBoard[i][j].getPieceName() + " ");
			}//end inner for loop
		System.out.println();		
		} //end outer for loop
		
		System.out.println();
		System.out.println("                " + player2Name + " " + p2Counter); 
		System.out.println();
		
		
	}//end printBoard method
	
	public static void p1CurrentCoordinate(Pieces[][]checkerBoard,int i, int j) {
		
		int c1 = 1;
		
		while (c1 == 1) {
			
			System.out.println(player1Name + "'s turn.");
			System.out.println("Enter the row, then column of the piece you want to move.");
			System.out.println("Current row: ");
			p1CurrentX = input.nextInt();
			System.out.println("Current column:");
			p1CurrentY = input.nextInt();						
			
			if (checkerBoard[p1CurrentX][p1CurrentY].getPieceName() == "[x]" || checkerBoard[p1CurrentX][p1CurrentY].getPieceName() == "[X]") {
				break;
			}
			else {
				System.out.println("Invalid input. Please enter another input.");
			}
		
		}//end p1 current coordinate while loop
	
		
	}//end p2NewCoordinate method
	
	public static void p1NewCoordinate(Pieces[][]checkerBoard,int i, int j) {
		
		int n1 = 1; 	
		while (n1 == 1) {
			
			System.out.println("Enter the row, then column of the location you want to move the piece to.");
			System.out.println("New row: ");
			p1NewX = input.nextInt();
			System.out.println("New column: ");
			p1NewY = input.nextInt();
			
			if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]") {
				
				if (p1NewX == p1CurrentX + 1 && p1NewY == p1CurrentY + 1) {
					if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]") {
						checkerBoard[p1NewX][p1NewY].setPieceName("[x]");
						checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
						p1SetKing(checkerBoard, i, j);
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end positive move checker no kill
				
				if (p1NewX == p1CurrentX + 1 && p1NewY == p1CurrentY - 1) {
					if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]") {
						checkerBoard[p1NewX][p1NewY].setPieceName("[x]");
						checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
						p1SetKing(checkerBoard, i, j);
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end negative move checker no kill
				
				
				if (p1NewX == p1CurrentX + 2 && p1NewY == p1CurrentY + 2) {
					if (checkerBoard[p1NewX - 1][p1NewY - 1].getPieceName() == "[o]" || checkerBoard[p1NewX - 1][p1NewY - 1].getPieceName() == "[O]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p1capture = input.nextInt();
						if (p1capture == 1) {
							if (p1CurrentX == 7 && (p1CurrentY == 0 || p1CurrentY == 2  || p1CurrentY == 3 || p1CurrentY == 4 || p1CurrentY == 5 || p1CurrentY == 6 || p1CurrentY == 7)) {
								checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
								checkerBoard[p1NewX - 1][p1NewY - 1].setPieceName("[ ]");
							}
							else {
								checkerBoard[p1NewX][p1NewY].setPieceName("[x]");
								checkerBoard[p1NewX - 1][p1NewY - 1].setPieceName("[ ]");
							}
							p1Counter += 1;
							p1JumpCounter += 1;
							checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
							p1SetKing(checkerBoard, i, j);
							printBoard(checkerBoard, i, j);
							if (p1Counter == 12) {
								break;
							}//end p1 wins if
							p1MultipleJump(checkerBoard, i, j);
							break;
						}//end p1 capture				
					}//end inner if	
				}//end positive move checker kill
			
				if (p1NewX == p1CurrentX + 2 && p1NewY == p1CurrentY - 2) {
					if (checkerBoard[p1NewX - 1][p1NewY + 1].getPieceName() == "[o]" || checkerBoard[p1NewX - 1][p1NewY + 1].getPieceName() == "[O]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p1capture = input.nextInt();
						if (p1capture == 1) {
							if (p1CurrentX == 7 && (p1CurrentY == 0 || p1CurrentY == 2  || p1CurrentY == 3 || p1CurrentY == 4 || p1CurrentY == 5 || p1CurrentY == 6 || p1CurrentY == 7)) {
								checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
								checkerBoard[p1NewX - 1][p1NewY + 1].setPieceName("[ ]");
							}	
							else {
								checkerBoard[p1NewX][p1NewY].setPieceName("[x]");
								checkerBoard[p1NewX - 1][p1NewY + 1].setPieceName("[ ]");	
							}
							p1Counter += 1;
							p1JumpCounter +=1;
							checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
							p1SetKing(checkerBoard, i, j);
							printBoard(checkerBoard, i, j);
							if (p1Counter == 12) {
								break;
							}//end p1 wins if
							p1MultipleJump(checkerBoard, i, j);
							break;	
						}//end p1 capture
					}//end inner if
				}//end negative move checker kill
	
			}//end if statement	
			
			else {
				System.out.println("Invalid Input");
			}		
			
		}//end p1 new coordinate while loop
		
		
	}//end p1NewCoordinate method

	public static void p2CurrentCoordinate(Pieces[][]checkerBoard,int i, int j) {
		
		int c2 = 1;
		while (c2 == 1) {
			
			System.out.println(player2Name + "'s turn.");
			System.out.println("Enter the row, then column of the piece you want to move.");
			System.out.println("Current row: ");
			p2CurrentX = input.nextInt();
			System.out.println("Current column:");
			p2CurrentY = input.nextInt();						
			
			if (checkerBoard[p2CurrentX][p2CurrentY].getPieceName() == "[o]"|| checkerBoard[p2CurrentX][p2CurrentY].getPieceName() == "[O]") {
				break;
			}
			else {
				System.out.println("Invalid input. Please enter another input.");
			}
		
		}//end p2 current coordinate while loop
		
		
	}//end p2CurrentCoordinate method
	
	public static void p2NewCoordinate(Pieces[][]checkerBoard,int i, int j) {
		
		int n2 = 1;
		while (n2 == 1) {
			
			System.out.println("Enter the row, then column of the location you want to move the piece to.");
			System.out.println("New row: ");					
			p2NewX = input.nextInt();
			System.out.println("New column: ");
			p2NewY = input.nextInt();	
			
			if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]") {
				
				if (p2NewX == p2CurrentX - 1 && p2NewY == p2CurrentY - 1) {
					if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]") {
						checkerBoard[p2NewX][p2NewY].setPieceName("[o]");
						checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
						p2SetKing(checkerBoard, i, j);
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end positive move checker no kill
				
				if (p2NewX == p2CurrentX - 1 && p2NewY == p2CurrentY + 1) {
					if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]") {
						checkerBoard[p2NewX][p2NewY].setPieceName("[o]");
						checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
						p2SetKing(checkerBoard, i, j);
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end negative move checker no kill		

				
				if (p2NewX == p2CurrentX - 2 && p2NewY == p2CurrentY + 2) {
					if (checkerBoard[p2NewX + 1][p2NewY - 1].getPieceName() == "[x]" || checkerBoard[p2NewX + 1][p2NewY - 1].getPieceName() == "[X]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p2capture = input.nextInt();
						if (p2capture == 1) {
							if (p2CurrentX == 0 && (p2CurrentY == 0 || p2CurrentY == 2  || p2CurrentY == 3 || p2CurrentY == 4 || p2CurrentY == 5 || p2CurrentY == 6 || p2CurrentY == 7)) {
								checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
								checkerBoard[p2NewX + 1][p2NewY - 1].setPieceName("[ ]");
							}
							else {
								checkerBoard[p2NewX][p2NewY].setPieceName("[o]");
								checkerBoard[p2NewX + 1][p2NewY - 1].setPieceName("[ ]");
							}
							p2Counter += 1;
							p2JumpCounter += 1;
							checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
							p2SetKing(checkerBoard, i, j);
							printBoard(checkerBoard, i, j);
							if (p2Counter == 12) {
								break;
							}//end p2 wins if
							p2MultipleJump(checkerBoard, i, j);
							break;	
						}//end p2 capture
					}//end inner else if	
				}//end positive move checker kill
				
				if (p2NewX == p2CurrentX - 2 && p2NewY == p2CurrentY - 2) {
					if (checkerBoard[p2NewX + 1][p2NewY + 1].getPieceName() == "[x]" || checkerBoard[p2NewX + 1][p2NewY + 1].getPieceName() == "[X]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p2capture = input.nextInt();
						if (p2capture == 1) {
							if (p2CurrentX == 0 && (p2CurrentY == 0 || p2CurrentY == 2  || p2CurrentY == 3 || p2CurrentY == 4 || p2CurrentY == 5 || p2CurrentY == 6 || p2CurrentY == 7)) {
								checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
								checkerBoard[p2NewX + 1][p2NewY + 1].setPieceName("[ ]");
							}
							else {
							checkerBoard[p2NewX][p2NewY].setPieceName("[o]");
							checkerBoard[p2NewX + 1][p2NewY + 1].setPieceName("[ ]");
							}
							p2Counter += 1;
							p2JumpCounter += 1;
							checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
							p2SetKing(checkerBoard, i, j);
							printBoard(checkerBoard, i, j);
							if (p2Counter == 12) {
								break;
							}//end p2 wins if
							p2MultipleJump(checkerBoard, i, j);
							break;	
						}//end p2 capture
					}//end inner else if
				}//end negative move checker kill
				
			}//end if statement	
			
			else {
				System.out.println("Invalid Input");
			}		

		}//end p2 new coordinate while loop
		
		
	}//end p2NewCoordinate method

	public static void p1MultipleJump(Pieces[][]checkerBoard,int i, int j) {
		
		if (p1JumpCounter > p1Counter) {
			
			int x = 1;
			while (x == 1) {
				
				System.out.println("Would you like to jump again? Press 1 for yes and 2 for no: ");
				int p1JumpDecision = input.nextInt();
				
				if (p1JumpDecision == 1) {
				
					p1CurrentX = p1NewX;
					p1CurrentY = p1NewY;
					
					if (p1IfKing(checkerBoard, i, j)) {	
						p1NewCoordinateKing(checkerBoard, i, j);
					}
					else if (!p1IfKing(checkerBoard, i, j)) {
						p1NewCoordinate(checkerBoard, i, j);
					}
					break;
	
				}//end inner if
				
				else if (p1JumpDecision == 2) {
					break;
				}//end inner else if
			
				else {
					System.out.println("Invalid input. Please enter another input: ");
				}//end inner else
			
			}//end while loop	
		
		}//end if 
	
		
	}//end p1MultipleJump method

	public static void p2MultipleJump(Pieces[][]checkerBoard,int i, int j) {
		
		if (p2JumpCounter > p2Counter) {
			
			int y = 1;
			while (y == 1) {
				
				System.out.println("Would you like to jump again? Press 1 for yes and 2 for no: ");
				int p2JumpDecision = input.nextInt();
				
				if (p2JumpDecision == 1) {
					
					p2CurrentX = p2NewX;
					p2CurrentY = p2NewY;
					
					if (p2IfKing(checkerBoard, i, j)) {	
						p2NewCoordinateKing(checkerBoard, i, j);
					}
					else if (!p2IfKing(checkerBoard, i, j)) {
						p2NewCoordinate(checkerBoard, i, j);
					}
					break;
					
				}//end inner if
				
				else if (p2JumpDecision == 2) {
					break;
				}//end inner else if
				
				else {
					System.out.println("Invalid input. Please enter another input: ");
				}//end inner else
			
			}//end while loop	
		
		}//end if 
		
		
	}//end p2MultipleJump method

	public static void p1SetKing(Pieces[][]checkerBoard,int i, int j) {
	
		if (p1NewX == 7 && (p1NewY == 0 || p1NewY == 1 || p1NewY == 2  || p1NewY == 3 || p1NewY == 4 || p1NewY == 5 || p1NewY == 6 || p1NewY == 7)) {
			if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[x]"){
				checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
			}//end inner if
			if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]"){
				checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
			}//end inner else if
		}//end outer if
		
		
	}//end p1SetKing method
		
	public static void p2SetKing(Pieces[][]checkerBoard,int i, int j) {
		
		if (p2NewX == 7 && (p2NewY == 0 || p2NewY == 1 || p2NewY == 2  || p2NewY == 3 || p2NewY == 4 || p2NewY == 5 || p2NewY == 6 || p2NewY == 7)) {
			if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[o]"){
				checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
			}//end inner if
			else if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]"){
				checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
			}//end inner else if
		}//end outer if
		
		
	}//end p2SetKing method

	public static boolean p1IfKing(Pieces[][]checkerBoard,int i, int j) {
	
			if (checkerBoard[p1CurrentX][p1CurrentY].getPieceName() == "[X]") {
				return true;
			}//end inner if
			
		
		return false;
		
		
	}//end p1IfKing method
	
	public static boolean p2IfKing(Pieces[][]checkerBoard,int i, int j) {
	
			if (checkerBoard[p2CurrentX][p2CurrentY].getPieceName() == "[O]") {
				return true;
			}//end inner if
			
		
		return false;
		
		
	}//end p2IfKing method

	public static void p1NewCoordinateKing(Pieces[][]checkerBoard,int i, int j) {
		
		int k1 = 1; 	
		while (k1 == 1) {
			
			System.out.println("Enter the row, then column of the location you want to move the piece to.");
			System.out.println("New row: ");
			p1NewX = input.nextInt();
			System.out.println("New column: ");
			p1NewY = input.nextInt();
	
			if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]") {
				
				if (p1NewX == p1CurrentX + 1 && p1NewY == p1CurrentY + 1) {
					if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]");
						checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
						checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end positive x positive y move checker no kill
				
				if (p1NewX == p1CurrentX + 1 && p1NewY == p1CurrentY - 1) {
					if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]") {
						checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
						checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end positive x negative y move checker no kill

				if (p1NewX == p1CurrentX - 1 && p1NewY == p1CurrentY + 1) {
					System.out.println("test8");
					if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]") {
						System.out.println("test9");
						checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
						checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end negative x and positive y move checker no kill
		
				if (p1NewX == p1CurrentX - 1 && p1NewY == p1CurrentY - 1) {
					if (checkerBoard[p1NewX][p1NewY].getPieceName() == "[ ]") {
						checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
						checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end negative x and negative y move checker no kill
				

				if (p1NewX == p1CurrentX + 2 && p1NewY == p1CurrentY + 2) {
					if (checkerBoard[p1NewX - 1][p1NewY - 1].getPieceName() == "[o]" || checkerBoard[p1NewX - 1][p1NewY - 1].getPieceName() == "[O]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p1capture = input.nextInt();
						if (p1capture == 1) {
							checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
							checkerBoard[p1NewX - 1][p1NewY - 1].setPieceName("[ ]");
							p1Counter += 1;
							p1JumpCounter += 1;
							checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
							printBoard(checkerBoard, i, j);
							if (p1Counter == 12) {
								break;
							}//end p1 wins if
							p1MultipleJump(checkerBoard, i, j);
							break;
						}//end p1 capture
					}//end inner if	
				}//end positive x positive y move checker kill
			
				if (p1NewX == p1CurrentX + 2 && p1NewY == p1CurrentY - 2 || checkerBoard[p1NewX - 1][p1NewY + 1].getPieceName() == "[O]") {
					if (checkerBoard[p1NewX - 1][p1NewY + 1].getPieceName() == "[o]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p1capture = input.nextInt();
						if (p1capture == 1) {
							checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
							checkerBoard[p1NewX - 1][p1NewY + 1].setPieceName("[ ]");
							p1Counter += 1;
							p1JumpCounter +=1;
							checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
							printBoard(checkerBoard, i, j);
							if (p1Counter == 12) {
								break;
							}//end p1 wins if
							p1MultipleJump(checkerBoard, i, j);
							break;	
						}//end p1 capture
					}//end inner if
				}//end positive x negative y move checker kill
				
				if (p1NewX == p1CurrentX - 2 && p1NewY == p1CurrentY + 2) {
					if (checkerBoard[p1NewX + 1][p1NewY - 1].getPieceName() == "[o]" || checkerBoard[p1NewX + 1][p1NewY - 1].getPieceName() == "[O]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p1capture = input.nextInt();
						if (p1capture == 1) {
							System.out.println("test4");
							checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
							checkerBoard[p1NewX + 1][p1NewY - 1].setPieceName("[ ]");
							p1Counter += 1;
							p1JumpCounter += 1;
							checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
							printBoard(checkerBoard, i, j);
							if (p1Counter == 12) {
								break;
							}//end p1 wins if
							p1MultipleJump(checkerBoard, i, j);
							break;
						}//end p1 capture
					}//end inner if		
				}//end positive x positive y move checker kill
			
				if (p1NewX == p1CurrentX - 2 && p1NewY == p1CurrentY - 2) {
					if (checkerBoard[p1NewX + 1][p1NewY + 1].getPieceName() == "[o]" || checkerBoard[p1NewX + 1][p1NewY + 1].getPieceName() == "[O]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p1capture = input.nextInt();
						if (p1capture == 1) {
							checkerBoard[p1NewX][p1NewY].setPieceName("[X]");
							checkerBoard[p1NewX + 1][p1NewY + 1].setPieceName("[ ]");
							p1Counter += 1;
							p1JumpCounter +=1;
							checkerBoard[p1CurrentX][p1CurrentY].setPieceName("[ ]");
							printBoard(checkerBoard, i, j);
							if (p1Counter == 12) {
								break;
							}//end p1 wins if
							p1MultipleJump(checkerBoard, i, j);
							break;	
						}//end p1 capture
					}//end inner if
				}//end positive x negative y move checker kill
			
			else {
				System.out.println("Invalid Input");
			}		
			
		}//end p1 new coordinate king while loop 	
		
	
	}//end p1NewCoordinateKing method

	public static void p2NewCoordinateKing (Pieces[][]checkerBoard,int i, int j){
		
		int k2 = 1; 	
		while (k2 == 1) {
			
			System.out.println("Enter the row, then column of the location you want to move the piece to.");
			System.out.println("New row: ");
			p1NewX = input.nextInt();
			System.out.println("New column: ");
			p1NewY = input.nextInt();
			
			if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]") {
				
				if (p2NewX == p2CurrentX + 1 && p2NewY == p2CurrentY + 1) {
					if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]") {
						checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
						checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end positive x positive y move checker no kill
				
				if (p2NewX == p2CurrentX + 1 && p2NewY == p2CurrentY - 1) {
					if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]") {
						checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
						checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end positive x negative y move checker no kill
				
				if (p2NewX == p2CurrentX - 1 && p2NewY == p2CurrentY + 1) {
					if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]") {
						checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
						checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end negative x and positive y move checker no kill
				
				if (p2NewX == p2CurrentX - 1 && p2NewY == p2CurrentY - 1) {
					if (checkerBoard[p2NewX][p2NewY].getPieceName() == "[ ]") {
						checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
						checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
						printBoard(checkerBoard, i, j);
						break;
					}//end inner if
				}//end negative x and negative y move checker no kill
				
				
				if (p2NewX == p2CurrentX + 2 && p2NewY == p2CurrentY + 2) {
					if (checkerBoard[p2NewX - 1][p2NewY - 1].getPieceName() == "[x]" || checkerBoard[p2NewX - 1][p2NewY - 1].getPieceName() == "[X]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p2capture = input.nextInt();
						if (p2capture == 1) {
							checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
							checkerBoard[p2NewX - 1][p2NewY - 1].setPieceName("[ ]");
							p2Counter += 1;
							p2JumpCounter += 1;
							checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
							printBoard(checkerBoard, i, j);
							if (p2Counter == 12) {
								break;
							}//end p2 wins if
							p2MultipleJump(checkerBoard, i, j);
							break;
						}//end p2 capture
					}//end inner if	
				}//end positive x positive y move checker kill
			
				if (p2NewX == p2CurrentX + 2 && p2NewY == p2CurrentY - 2) {
					if (checkerBoard[p2NewX - 1][p2NewY + 1].getPieceName() == "[x]" || checkerBoard[p2NewX - 1][p2NewY + 1].getPieceName() == "[X]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p2capture = input.nextInt();
						if (p2capture == 1) {
							checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
							checkerBoard[p2NewX - 1][p2NewY + 1].setPieceName("[ ]");
							p2Counter += 1;
							p2JumpCounter +=1;
							checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
							printBoard(checkerBoard, i, j);
							p2MultipleJump(checkerBoard, i, j);
							break;	
						}//end p2 capture
					}//end inner if
				}//end positive x negative y move checker kill
				
				if (p2NewX == p2CurrentX - 2 && p2NewY == p2CurrentY + 2) {
					if (checkerBoard[p2NewX + 1][p2NewY - 1].getPieceName() == "[x]" || checkerBoard[p2NewX + 1][p2NewY - 1].getPieceName() == "[X]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p2capture = input.nextInt();
						if (p2capture == 1) {
							checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
							checkerBoard[p2NewX + 1][p2NewY - 1].setPieceName("[ ]");
							p2Counter += 1;
							p2JumpCounter += 1;
							checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
							printBoard(checkerBoard, i, j);
							if (p2Counter == 12) {
								break;
							}//end p2 wins if
							p2MultipleJump(checkerBoard, i, j);
							break;
						}//end p2 capture
					}//end inner if	
				}//end positive x positive y move checker kill
			
				if (p2NewX == p2CurrentX - 2 && p2NewY == p2CurrentY - 2) {
					if (checkerBoard[p2NewX + 1][p2NewY + 1].getPieceName() == "[x]" || checkerBoard[p2NewX + 1][p2NewY + 1].getPieceName() == "[X]") {
						System.out.println("Are you sure you want to proceed with capturing your opponenet's piece. Press 1 for yes and 2 for no.");
						int p2capture = input.nextInt();
						if (p2capture == 1) {
							checkerBoard[p2NewX][p2NewY].setPieceName("[O]");
							checkerBoard[p2NewX + 1][p2NewY + 1].setPieceName("[ ]");
							p2Counter += 1;
							p2JumpCounter +=1;
							checkerBoard[p2CurrentX][p2CurrentY].setPieceName("[ ]");
							printBoard(checkerBoard, i, j);
							if (p2Counter == 12) {
								break;
							}//end p2 wins if
							p2MultipleJump(checkerBoard, i, j);
							break;	
						}//end p2 capture
					}//end inner if
				}//end positive x negative y move checker kill
				
			}//end if statement
			
			else {
				System.out.println("Invalid Input");
			}		
			
		}//end p2 new coordinate king while loop 	
		
		
	}//end p2NewCoordinateKing method

}//end class