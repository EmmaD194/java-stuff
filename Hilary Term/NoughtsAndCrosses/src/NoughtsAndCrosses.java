/* SELF ASSESSMENT  
   1.  clearBoard:
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes, I made a clear board function which clears the board
Did I use loops to set each position to the BLANK character?
Mark out of 5:0
Comment:no
   2.  printBoard
Did I use the correct method definition?
Mark out of 5:5
Comment:I made a print board function which prints the current state of the board
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5:5
Comment:I used an x,y coordinate system to show he board
   3.  canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:I had a boolean function to tell whether he move was a valid or not
Did I check if a specified location was BLANK?
Mark out of 5:0
Comment:no
   4.  makeMove
Did I have the correct function definition?
Mark out of 5:0
Comment:no
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5:2
Comment:    I did this but I did it in the main method
   5.  isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5:0
Comment:        no
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5:0
Comment:no
   6.  winner
Did I have the correct function definition and returned the winning character
Mark out of 5:2
Comment:    I created a function called winner but my winning code must be wrong because when there is only one X the game is won 
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15:8
Comment:I tried to identify each winne by using a counter on each row diagonal and clumn
   7.main

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3:3
Comments:I created a 3x3 board that is initialised before each game
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5:3
Comments:Yes but when the first X is placed the game ends as it thinks someone has won
Did I call all of the methods above?
Mark out of 5:3
Comments:I called all of the methods I created 
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3:1
Comments:I tried to make a loop which asks the user for a valid location until a valid location was entered eg. if 6, 2 was entered as a coordiante it would ask again but it doesn't work
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3:1
Comments:I couldn't test my code properly so I don't really know
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3:2
Comments:It prints the players name has won the game but my winning code is broken 

   8.  Overall
Is my code indented correctly?
Mark out of 3:3
Comments:I indented my functions, for and if statements correctly
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3:3
Comments:my variables are relevant and meaningful
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments:yes, they are formatted correctly in the right style.
      Total Mark out of 100 (Add all the previous marks): 53 
*/import java.util.Scanner;

public class NoughtsAndCrosses {

static int count[][] = new int[4][4];
static char board[][] = new char[4][4];
static String playerOne;
static String playerTwo;

static int x;
static int y;
static int noOfMoves;
static int checkO = 0;
static int checkX = 0;

static boolean canMove;
static boolean gameWin;
static boolean gameDraw;

static char currentSymbol;

static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
    clearBoard();
    System.out.println("What is the name of player one? ");
    playerOne = sc.next();
    System.out.println("What is the name of player two? ");
    playerTwo = sc.next();

    currentSymbol = 'X';

    
    noOfMoves = 0;
    gameDraw = false;
    gameWin = false;

    System.out.println();
    printBoard(board);
    System.out.println("\n" + playerOne + " starts playing " + currentSymbol);
    System.out.println();

    do { 
        do {

            x= getX();
            y = getY();
            System.out.println("");
            canMove = canMakeMove(x, y, board);
            if (!canMove) {
                System.out.println("Coordinates invalid, please try again");
            } 
        } while (!canMove);

        board[x][y] = currentSymbol;
        printBoard(board);
        gameWin = winner(board);
        noOfMoves++;

        if (!gameWin) {
            
            if (noOfMoves == 9) {
                gameDraw = true;
            } else {
                if (currentSymbol == 'X') {
                    currentSymbol = 'O';
                    System.out.println(playerTwo + "'s turn");
                } else {
                    currentSymbol = 'X';
                    System.out.println(playerOne + "'s turn");
                } 
            } 
        } 
    } while (!gameWin && !gameDraw);

    
    if (gameWin) {
        if ('X' == currentSymbol) {
            System.out.println(playerOne + " congratulations you win!");

        } else {
            System.out.println(playerTwo + " congratulations you win!");

        }
    } else {
        System.out.println("A draw this time!");
    }
} 

public static void clearBoard() {

}



public static void printBoard(char[][] board) {
    int row;
    int column;
    System.out.println("  | 1 2 3 ");
    System.out.println("--+-------");

    for (row = 1; row <= 3; row++) {
        System.out.print(row + " | ");
        for (column = 1; column <= 3; column++) {
            System.out.print(board[column][row] + " ");
        } 
        System.out.println();
    } 
} 

public static int getX() {
    System.out.println("Please enter an X coordinate");
    x = sc.nextInt();

    return x;
}

public static int getY() {
    System.out.println("Please enter an Y coordinate");
    y = sc.nextInt();

    return y;
}

public static boolean canMakeMove(int xCoord, int ycoord, char[][] board) {
    

    if (xCoord > board.length || ycoord > board.length || xCoord == 0 || ycoord == 0 || xCoord == 4 || ycoord == 4) {
    	canMove = false;
    } else {
    	canMove = true;
    }

    if (currentSymbol == 'O') {
        count[xCoord][ycoord] = -1;

    } else if (currentSymbol == 'X') {
        count[xCoord][ycoord] = 1;
    }

    return canMove;

} 

public static boolean winner(char[][] board) {
  
    for (int i = 1; i < 4; i++) {
        if (count[i][1] == -1) {
            checkO = checkO + 1;
        }
        if (count[i][1] == 1) {
            checkX = checkX + 1;
        }
    }

    if (checkO == 3) {
        return true;
    }
    if (checkX == 3) {
    	return true;
    }
    
    for (int i = 1; i < 4; i++) {
        if (count[i][2] == -1) {
            checkO = checkO + 1;
        }
        if (count[i][2] == 1) {
            checkX = checkX + 1;
        }
    }

    if (checkO == 3) {
        return true;
    }
    if (checkX == 3) {
    	return true;
    }
    
    for (int i = 1; i < 4; i++) {
        if (count[i][3] == -1) {
            checkO = checkO + 1;
        }
        if (count[i][3] == 1) {
            checkX = checkX + 1;
        }
    }

    if (checkO == 3) {
        return true;
    }
    if (checkX == 3) {
    	return true;
    }

    
    for (int i = 1; i < 4; i++) {
        if (count[1][i] == -1) {
            checkO = checkO + 1;

        }
        if (count[1][i] == 1) {

            checkX = checkX + 1;
        }
    }

    if (checkO == 3) {
        return true;
    }
    if (checkX == 3) {
    	return true;
    }

    
    for (int i = 1; i < 4; i++) {
        if (count[2][i] == -1) {
            checkO = checkO + 1;

        }
        if (count[2][i] == 1) {

            checkX = checkX + 1;
        }
    }

    if (checkO == 3) {
        return true;
    }
    if (checkX == 3) {
    	return true;
    }

    
    for (int i = 1; i < 4; i++) {
        if (count[3][i] == -1) {
            checkO = checkO + 1;

        }
        if (count[3][i] == 1) {

            checkX = checkX + 1;
        }
    }

    if (checkO == 3) {
        return true;
    }
    if (checkX == 3) {
    	return true;
    }

    
    for (int i = 1; i < 4; i++) {
        if (count[i][i] == -1) {
            checkO = checkO + 1;
            break;
        }
        if (count[i][i] == 1) {

            checkX = checkX + 1;
            break;
        }

    }
    if (checkO == 3) {
        return true;
    }
    if (checkX == 3) {
    	return true;
    }

   
    for (int j = 2; j < 5; j++) {
        for (int i = 1; i < 4; i++) {
            if (count[i][j - 1] == -1) {
                checkO = checkO + 1;
                break;
            }
            if (count[i][j - 1] == 1) {

                checkX = checkX + 1;
                break;
            }
        }
    }

    if (checkO == 3) {
        return true;
    }
    if (checkX == 3) {
    	return true;
    }

    if (checkX == 3 || checkO == 3) {
        gameWin = true;
    } else {
        checkO = 0;
        checkX = 0;
        gameWin = false;

    }

    return false;
  }

 }
