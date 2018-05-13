package Demo7;

import java.util.Scanner;

/**
 * @Author: Allen
 * @Description:
 * @Date: Created in 10:27 2018/5/12
 * @Modify By:
 */
public class ex2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int match = s.nextInt();
        String[] matchs = new String[match];
        int pattern = s.nextInt();
        String[] patterns = new String[pattern];
        for (int i = 0; i < match; i++) {
            matchs[i] = s.next();
        }
        String kh = s.nextLine();
        for (int i = 0; i < pattern; i++) {
            patterns[i] = s.next();
        }
        boolean flag = true;
        for (int i = 0; i < pattern; i++) {
            flag = true;
            for (int j = 0; j < match; j++) {
                boolean result = ismatch(patterns[i],matchs[j]);
                if (result){
                    flag = false;
                    System.out.println(1);
                    break;
                }
            }
            if (flag)
                System.out.println(-1);
        }
        return;
    }

    public static boolean ismatch(String text,String pattern){
        if (text.length() < pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) != text.charAt(i))
                return false;
        }
        return true;
    }
}
