package Tutor1;
import java.util.Scanner;

public class EvenIntegers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        EvenIntSet evenSet = new EvenIntSet();
        while (true){
            System.out.println("Enter an even integer: ");
            int i = input.nextInt();
            try {
                evenSet.add(i);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
