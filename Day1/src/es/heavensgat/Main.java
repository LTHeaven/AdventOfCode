package es.heavensgat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        partOne();
        partTwo();
    }

    private static void partTwo() {
        int result = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        boolean notSolved = true;
        while(notSolved){
            Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
            while (scanner.hasNext()){
                String inputNumber = scanner.next();
                int number = Integer.parseInt(inputNumber.substring(1));
                if (inputNumber.charAt(0) == '+'){
                    result += number;
                } else {
                    result -= number;
                }
                if (map.get(result) != null) {
                    System.out.println("first double freq: " + result);
                    notSolved = false;
                    break;
                }
                map.put(result, true);
            }
        }
    }

    private static void partOne() {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("input.txt"));
        int result = 0;
        while (scanner.hasNext()){
            String inputNumber = scanner.next();
            int number = Integer.parseInt(inputNumber.substring(1));
            if (inputNumber.charAt(0) == '+'){
                result += number;
            } else {
                result -= number;
            }
        }
        System.out.println("the result is: " + result);
    }
}
