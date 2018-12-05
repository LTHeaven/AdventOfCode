import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        partOne("test.txt");
        partOne("input.txt");
        partTwo("test.txt");
        partTwo("input.txt");

    }

    private static void partTwo(String filename) {
        int[][] claims = new int[1000][1000];
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(filename));
        List<RectangleInfo> infos = new ArrayList<RectangleInfo>();
        while(scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            RectangleInfo info = new RectangleInfo(currentLine);
            infos.add(info);
            for (int x = 0; x<info.width; x++) {
                for (int y = 0; y<info.height; y++){
                    claims[info.x+x][info.y+y] ++;
                }
            }
        }
        RectangleInfo solutionInfo = null;
        for (RectangleInfo info : infos){
            boolean valid = true;
            for (int x = 0; x<info.width; x++) {
                for (int y = 0; y<info.height; y++){
                    if (claims[info.x+x][info.y+y] != 1) {
                        valid = false;
                    }
                }
            }
            if (valid){
                solutionInfo = info;
            }
        }
        System.out.println("The solution for " + filename + " is: " + solutionInfo.getId());
    }

    private static void partOne(String filename) {
        int[][] claims = new int[1000][1000];
        Scanner scanner = new Scanner(Main.class.getResourceAsStream(filename));
        while(scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            RectangleInfo info = new RectangleInfo(currentLine);
            for (int x = 0; x<info.width; x++) {
                for (int y = 0; y<info.height; y++){
                    claims[info.x+x][info.y+y] ++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i<1000; i++){
            for (int j = 0; j<1000; j++){
                if(claims[i][j] >= 2){
                    count++;
                }
            }
        }
        System.out.println("The solution for " + filename + " is: " + count);
    }
}
