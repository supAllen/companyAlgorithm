package Demo7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  java 统计文件注释个数
 */
public class ex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> ve = new ArrayList<>();
        while (in.hasNext()){
            String line = in.nextLine();
            ve.add(line);
            if (line.equals("}"))
                break;
        }
        System.out.println(ve);
        int[] operateNote = operateNote(ve);
        System.out.println(operateNote[0]+"  "+operateNote[1]);
    }

    /* sdfasdf */   /*sdfasd */
    public static int[] operateNote(ArrayList<String> list) {

        String s = null;
        int countNote=0;
        int charInNote=0;
        for(int j=0;j<list.size();j++) {
            s=list.get(j).trim();
            if (s.equals(""))
                continue;
            int note1=s.indexOf("/*");
            int note2=s.indexOf("//");
            int note3=s.indexOf("*/");
            //int note4=s.indexOf("\"");

            String dm="\"(.*)\"";//双引号
            String sm="\'(.*)\'";//单引号

            if(note1!=-1&&note3==-1) {//多行注释
                if (note1 != 0){
                    char c = s.charAt(note1-1);
                    if (!String.valueOf(c).equals("\"")){
                        ++countNote;
                        System.out.println("第 ："+countNote+"在第 "+(j+1));
                    }
                    continue;
                }
                ++countNote;
                System.out.println("第 ："+countNote+"在第 "+(j+1));
                list.remove(j);
                charInNote+=s.length();

            }else if(note2!=-1) {// "//"类的单行注释
                // 是否在双引号判断
                if (note2 != 0){
                    char c = s.charAt(note2-1);
                   if (String.valueOf(c).equals("\"")){
                       String temp = s.substring(note2+1);
                       int gi = temp.indexOf("\"");
                       if (gi == s.length()-2)
                           continue;
                       int indexOf = temp.substring(gi).indexOf("//");
                       s = s.substring(gi);
                       if (indexOf == -1)
                           continue;
                   }
                }
                countNote++;
                System.out.println("第 ："+countNote+"在第 "+(j+1));
                list.set(j, s.substring(0,note2));
                charInNote+=s.substring(note2).length()+1;
            }else if(note1!=-1&&note3!=-1) {//单行注释
                // 是否在双引号判断
                if (note1 != 0){
                    char c = s.charAt(note1-1);
                    if (String.valueOf(c).equals("\"")){
                        int gin = s.substring(note1+3).indexOf("\"");
                        if (gin == s.length()-2)
                            continue;
                        String temp = new String(s.toCharArray(),
                                gin+note1+4,s.length()-(gin+note1+4));
                        int indexOf = temp.indexOf("/*");
                        int indexof = temp.indexOf("*/");
                        if (indexOf == -1 || indexof == -1)
                            continue;
                    }
                }
                countNote++;
                System.out.println("第 ："+countNote+"在第 "+(j+1));
                String m1=s.substring(0, note1);
                String m2=s.substring(note3+2);
                int n = zs(m2, 0);
                countNote+=n;       // 一行有 多个
                String m3=m1+m2;
                charInNote+=s.substring(note1, note3+2).length();
                list.set(j, m3);
                char[] s2131="// sdfas".toCharArray();
            }else {//删除输出语句
                String rp=list.get(j);
                rp=rp.replaceAll(dm, "");
                list.set(j, rp);
            }

        }
        return new int[]{countNote,charInNote};
    }

    public static int zs(String str, int n){
        int pindex = str.indexOf("/*");
        int tindex = str.indexOf("*/");
        if (pindex != -1 && tindex != -1)
            return zs(str.substring(tindex),++n);
        else
            return n;
    }
}
