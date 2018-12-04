package es.heavensgat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        findChecksum("test.txt");
        findChecksum("input.txt");
    }

    private static void findChecksum(String fileName) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(fileName));
        int doubles = 0;
        int triples = 0;
        while (scanner.hasNext()){
            String currentString = scanner.next();
            doubles += checkForOccurrences(2, currentString);
            triples += checkForOccurrences(3, currentString);
        }
        System.out.println("the checksum for " + fileName + " is: " + (doubles * triples));
    }

    private static int checkForOccurrences(int amountToCheck, String currentString) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : currentString.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
            }
        }
        for (char c : map.keySet()) {
            if(map.get(c) == amountToCheck){
                return 1;
            }
        }
        return 0;
    }
}
