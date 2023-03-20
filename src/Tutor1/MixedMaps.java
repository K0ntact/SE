package Tutor1;

import java.util.Scanner;

public class MixedMaps {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        StringIntMap map = new StringIntMap();
        while (true){
            System.out.println("[1] Add a new entry");
            System.out.println("[2] Get the value of an entry");
            System.out.println("[3] Remove an entry");
            System.out.println("[4] Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a key: ");
                    String key = input.nextLine();
                    System.out.print("Enter a value: ");
                    int value = input.nextInt();
                    input.nextLine();
                    map.put(key, value);
                }

                case 2 -> {
                    System.out.println("Enter a key: ");
                    String key = input.nextLine();
                    System.out.println("The value is: " + map.lookup(key));
                }

                case 3 -> {
                    System.out.println("Enter a key: ");
                    String key = input.nextLine();
                    System.out.println("Enter a value: ");
                    int value = input.nextInt();
                    input.nextLine();
                    map.remove(key, value);
                }

                case 4 -> System.exit(0);
            }
        }
    }
}
