package com.zhongfeng.api.modules.white;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author blueCat
 * @date 2023/2/3 9:40
 * @motto life is a gift
 */
public class addWhite {
    public static void main(String[] args) throws IOException {
        //文件地址
        String location = "C:\\Users\\84361\\Desktop\\白名单";
        File file = new File("C:\\Users\\84361\\Desktop\\白名单");
        String[] list = file.list();
        //去除后几位(默认为6)
        int num = 7;
        //存储结果集
        List<String> result = new ArrayList<>();
        System.out.println(Arrays.toString(list));
        String filename = "";
        for (String s : list) {
            filename = location+"\\"+s;
            Scanner sc = new Scanner(new FileReader(filename));
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                line = line.substring(0,11-num);
                if (!result.contains(line)){
                    result.add(line);
                }
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
        FileWriter fw = new FileWriter(location + "\\合并号码集合.txt");
        for (String s : result) {
            fw.write(","+s);
        }
        fw.flush();
        fw.close();
    }
}
