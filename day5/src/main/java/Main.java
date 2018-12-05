import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        partOne("test.txt");
        partOne("input.txt");
        partTwo("test.txt");
        partTwo("input.txt");
    }

    private static void partTwo(String filename) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(filename));
        String rootString = scanner.nextLine();
        Set<Character> characterSet = new HashSet<>();
        for (char c : rootString.toCharArray()){
            characterSet.add(Character.toLowerCase(c));
        }
        int lowestCount = 999999999;
        for (char c : characterSet) {
            String tempString = rootString.replace(""+c, "");
            tempString = tempString.replace(""+Character.toUpperCase(c), "");
            int count = reduce(tempString).length();
            if(count < lowestCount){
                lowestCount = count;
            }
        }
        System.out.println("lowest count: " + lowestCount);
    }

    private static void partOne(String filename) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(filename));
        String rootString = reduce(scanner.nextLine());
        System.out.println(filename + " solution: " + rootString + "\nUnits: " + rootString.length());
    }

    private static String reduce(String rootString) {
        boolean notToday = true;
        while(notToday){
            notToday = false;
            for (int i = 0; i<rootString.length(); i++) {
                if(!notToday && i+1 < rootString.length()) {
                    char char1 = rootString.charAt(i);
                    char char2 = rootString.charAt(i+1);
                    if (Character.toLowerCase(char1) == Character.toLowerCase(char2) && (Character.isLowerCase(char1)^Character.isLowerCase(char2))) {
                        rootString = rootString.substring(0, i) + (i+2 < rootString.length() ? rootString.substring(i+2) : "");
                        notToday = true;
                    }
                }
            }
        }
        return rootString;
    }

}
