import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static final Scanner scan = new Scanner(System.in);
    boolean boxAvailable;
    private byte winner = 0;
    char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public void startGame() {
        System.out.println("Enter box number to select. Enjoy!");

        boolean boxEmpty = false;
        while (true) {

            printPlayingField(box);

            if (!boxEmpty) {
                Arrays.fill(box, ' ');
                boxEmpty = true;
            }
            if (printRezultGame(winner)) {
                break;
            }
            actionPlayer(box);
            if (verificationWinner(box, 'X')) {
                winner = 1;
                continue;
            }

            boxAvailable = checkBoxAvailable(box);

            if (!boxAvailable) {
                winner = 3;
                continue;
            }

            actionComputer(box);

            if (verificationWinner(box, 'O')) {
                winner = 2;
            }
        }
    }

    private boolean printRezultGame(byte winner) {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    private void actionPlayer(char[] box) {
        byte inputSquareNumber;
        while (true) {
            inputSquareNumber = scan.nextByte();
            if (inputSquareNumber > 0 && inputSquareNumber < 10) {
                if (box[inputSquareNumber - 1] == 'X' || box[inputSquareNumber - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[inputSquareNumber - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    private void printPlayingField(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
    }

    private boolean verificationWinner(char[] box, char symbol) {
        return (box[0] == symbol && box[1] == symbol && box[2] == symbol)
                || (box[3] == symbol && box[4] == symbol && box[5] == symbol)
                || (box[6] == symbol && box[7] == symbol && box[8] == symbol)
                || (box[0] == symbol && box[3] == symbol && box[6] == symbol)
                || (box[1] == symbol && box[4] == symbol && box[7] == symbol)
                || (box[2] == symbol && box[5] == symbol && box[8] == symbol)
                || (box[0] == symbol && box[4] == symbol && box[8] == symbol)
                || (box[2] == symbol && box[4] == symbol && box[6] == symbol);
    }

    private void actionComputer(char[] box) {
        while (true) {
            byte rand;
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

    private boolean checkBoxAvailable(char[] box) {
        boolean boxAvailable = false;
        for (int i = 0; i < box.length; i++) {
            if (box[i] != 'X' && box[i] != 'O') {
                boxAvailable = true;
                break;
            }
        }
        return boxAvailable;
    }
}
