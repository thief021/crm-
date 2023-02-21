package com.zhongfeng.api.modules.utils.pojo;

/**
 * @author blueCat
 * @since 2022/3/4
 */
public class TransferUtils {

    /**
     * 转换重要性
     */
    public static Integer transferNecessity(String necessityStr) {
        switch (necessityStr) {
            case "必要":
                return 1;
            case "可以不花":
                return 2;
            case "完全没必要":
                return 0;
        }
        return null;
    }

    /**
     * 转化时间
     */
    public static String transferMinute(int minutes) {
        int day = 0;
        int hour = 0;
        int minute = 0;
        day = minutes / (60 * 24);
        hour = minutes / 60 - day * 24;
        minute = minutes % 60;
        return (day>0?day + "天":"") + (hour>0?hour + "小时":"") + (minute>0?minute + "分钟":"");
    }
}
