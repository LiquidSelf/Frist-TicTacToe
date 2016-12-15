import java.io.IOException;
import java.util.Scanner;

public class Figures {

    public static char getX(){

        for (; ; ) {

            Scanner scan = new Scanner(System.in);
            String temp = scan.next();

            if (temp.length() == 1) {

                char q = temp.charAt(0);

                if (q == 'X') {

                    break;

                } else System.out.println("Ходит крестикX");

            } else System.out.println("X или O");


        }
    }
}