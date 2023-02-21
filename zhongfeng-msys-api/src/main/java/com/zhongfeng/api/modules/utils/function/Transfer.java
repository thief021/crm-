package com.zhongfeng.api.modules.utils.function;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blueCat
 * @date 2023/2/3 9:21
 * @motto life is a gift
 */
public class Transfer {

    /**
     * 将“[1],[2]”转化为[1,2]的集合
     *
     * @param listStr
     * @return
     */
    public static List<Integer> transferString(String listStr) {
        List<Integer> result = new ArrayList<>();
        String[] split = listStr.split(",");
        for (String s : split) {
            s = s.substring(1, s.length());
            s = s.substring(0, s.length() - 1);
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    /**
     * 合并集合为一个String，中间
     *
     * @return
     */
    public static <T> String combineList(List<T> strList) {
        if (strList != null && strList.size() > 0){
            String result = "";
            for (T s : strList) {
                result = result + "[" + s + "],";
            }
            return result.substring(0, result.length() - 1);
        }
        return "";
    }
}
