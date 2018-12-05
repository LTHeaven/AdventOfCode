
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("--- Part One");
        partOne("test.txt");
        partOne("input.txt");
        System.out.println("--- Part Two");
        partTwo("test.txt");
        partTwo("input.txt");
    }

    private static void partTwo(String filename) throws ParseException {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(filename));
        List<LogEntry> logBook = new ArrayList<>();
        while (scanner.hasNext()) {
            logBook.add(new LogEntry(scanner.nextLine()));
        }
        Collections.sort(logBook);
        Map<Long, Integer[]> sleepTimes = new HashMap<>();
        long currentGuard = -1;
        fillSleepTimes(logBook, sleepTimes, currentGuard);
        int currentLongestAmount = 0;
        long winningGuard = -1;
        int winningMinute = 0;
        for (long key : sleepTimes.keySet()){
            for (int i = 0; i<60; i++){
                Integer count = sleepTimes.get(key)[i];
                if(count > currentLongestAmount) {
                    currentLongestAmount = count;
                    winningGuard = key;
                    winningMinute = i;
                }
            }
        }
        System.out.println(winningGuard + " * " + winningMinute + " = " + (winningGuard*winningMinute));
    }

    private static void fillSleepTimes(List<LogEntry> logBook, Map<Long, Integer[]> sleepTimes, long currentGuard) {
        for (int i = 0; i < logBook.size(); i++){
            LogEntry entry = logBook.get(i);
            if (entry.getType() == EntryType.SHIFT){
                currentGuard = entry.getGuardId();
            }else if (entry.getType() == EntryType.FALL_ASLEEP){
                Integer[] times = new Integer[60];
                for (int k = 0; k<60;k++){
                    times[k] = 0;
                }
                if (sleepTimes.containsKey(currentGuard)){
                    times = sleepTimes.get(currentGuard);
                }
                for (int j = entry.getTime().getMinutes(); j < logBook.get(i+1).getTime().getMinutes(); j++){
                    if (times[j] == null){
                        times[j] = 0;
                    }
                    times[j] ++;
                }
                sleepTimes.put(currentGuard, times);
                i++;
            }
        }
    }

    private static void partOne(String filename) throws ParseException {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(filename));
        List<LogEntry> logBook = new ArrayList<>();
        while (scanner.hasNext()) {
            logBook.add(new LogEntry(scanner.nextLine()));
        }
        Collections.sort(logBook);
        Map<Long, Integer[]> sleepTimes = new HashMap<>();
        long currentGuard = -1;
        fillSleepTimes(logBook, sleepTimes, currentGuard);
//        for (long key : sleepTimes.keySet()){
//            Integer[] times = sleepTimes.get(key);
//            for(int i : times){
//                if (i == 0){
//                    System.out.print("-");
//                }else{
//                    System.out.print(i);
//                }
//            }
//            System.out.println("");
//        }
        //find guard with most minutes
        long currentChamp = -1;
        int currentLongestMinutes = 0;
        for (long key : sleepTimes.keySet()){
            Integer[] times = sleepTimes.get(key);
            int sum = 0;
            for(Integer i : times){
                sum += i;
            }
            if (sum > currentLongestMinutes){
                currentChamp = key;
                currentLongestMinutes = sum;
            }
        }
        //find minute most asleep
        int currentHighestMinute = -1;
        int currentHighestMinuteAmount = 0;
        for (int i = 0; i<60; i++){
            Integer minute = sleepTimes.get(currentChamp)[i];
            if (minute > currentHighestMinuteAmount){
                currentHighestMinuteAmount = minute;
                currentHighestMinute = i;
            }
        }
        System.out.println(currentChamp + " * " + currentHighestMinute + " = " + (currentChamp*currentHighestMinute));
    }
}
