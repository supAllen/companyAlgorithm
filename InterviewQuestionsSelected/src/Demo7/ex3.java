package Demo7;

import java.util.Scanner;

/**
 * @Author: Allen
 * @Description:
 * @Date: Created in 11:04 2018/5/12
 * @Modify By:
 */
public class ex3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nz = s.nextInt();
        int n = s.nextInt();
        int m = s.nextInt();
        int[] Am = new int[m];
        for (int i = 0; i < m; i++) {
            Am[i] = s.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(i);
        }
        String temp = sb.toString();
        int dept = 0;
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (temp.length() == 1){
                    flag = true;
                    break;
                }
                int index = Am[i];
                index = (index+dept)%sb.length();
                sb.deleteCharAt(index);
                temp = sb.toString();
                dept += index;
            }
            if (flag)
                break;
            if (i == m-1)
                i = 0;
        }
        System.out.println(temp);
    }
}
