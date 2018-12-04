package es.heavensgat;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        findChecksum("test.txt");
        findChecksum("input.txt");
        partTwo("test.txt");
        partTwo("input.txt");
    }

    private static void partTwo(String fileName) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(fileName));
        List<String> strings = new ArrayList<>();
        while (scanner.hasNext()){
            strings.add(scanner.next());
        }
        String solution = "";
        for (int i = 0; i<strings.size(); i++){
            for (int j = i+1; j < strings.size(); j++){
                char[] string1 = strings.get(i).toCharArray();
                char[] string2 = strings.get(j).toCharArray();
                int count = 0;
                for(int k = 0; k < string1.length; k++){
                    if (string1[k] != string2[k]){
                        count++;
                    }
                    if (count == 1){
                        solution= strings.get(i);
                        solution = solution.substring(0, k) + solution.substring(k+1);
                    }
                }
            }
        }
        System.out.println("Solution for " + fileName + ": " + solution);
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
