package Demo7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Allen
 * @Description:
 * @Date: Created in 11:35 2018/5/12
 * @Modify By:
 */
public class ex4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String pattern = s.next();
        String match = s.next();
        int[][] ain = new int[pattern.length()][1024];
        int[] indexCount = new int[pattern.length()];
        Arrays.fill(indexCount,0);
        int[] dis = new int[pattern.length()-1];
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            for (int j = 0; j < match.length(); j++) {
                if (c == match.charAt(j)){
                    int in = indexCount[i];
                    ain[i][in] = j;
                    ++indexCount[i];
                }
            }
        }

        int grade = 100;
        int grades[] = new int[1024];
        for (int i = 0; i < ain[0].length; i++) {

        }
    }
}
