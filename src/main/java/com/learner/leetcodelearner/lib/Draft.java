package com.learner.leetcodelearner.lib;




import java.util.*;
import java.util.stream.Collectors;


/**
 * @Description
 * @Author andy lin
 * @Date: 2022/09/01 15:31
 **/
public class Draft {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private static LinkedList<String> threadList = new LinkedList<>();

    Map<Character, Integer> current = new HashMap<>();
    Map<Character, Integer> standard = new HashMap<>();
    public static void main(String[] args) {
//          String str = "{\"pkjc\":[\"view\"],\"jdys\":[\"view\"],\"cpx\":[\"view\"],\"gzrz\":[\"view\",\"publish\"],\"cljc\":[\"view\"],\"lcgl\":[\"view\"],\"bzhts\":[\"view\"],\"xmcy\":[\"view\"],\"cpsc\":[\"viewAll\"],\"dftl\":[\"view\"],\"yp\":[\"view\"],\"xmxc\":[\"view\"],\"czzy\":[\"view\"],\"wbps\":[\"view\"],\"jgsc\":[\"view\"],\"vr\":[\"view\"],\"bzhxj\":[\"view\"],\"zxks\":[\"view\"]}";
//          System.out.println(str.contains("\"cpsc\":[\"viewAll\"]"));

          List<String> list = new ArrayList<>(Arrays.asList("test","test","test"));
        List<String> collect = list.stream().distinct().collect(Collectors.toList());

        list.add("add");
          System.out.println(collect.size());
//        carbonCyclePlan(81, 2.5, 1.5, 0.8);

//        carbonCyclePlan(67.5, 3.5, 1.5, 1.0);
    }


    public static void carbonCyclePlan(double weight, double carbon, double protein, double fat) {
        System.out.println("当前体重" + weight + "kg" + ", 计划每日每公斤体重摄入: 碳水" + String.format("%.2f",carbon) + "g, 蛋白质: " + String.format("%.2f", protein) + "g, 脂肪: " + String.format("%.2f", fat) + "g");

        double dayCarbon = carbon * weight;
        double weekCarbon =  dayCarbon * 7;

        double dayProtein = protein * weight;

        double dayFat = fat * weight;
        double weekFat =  dayFat * 7;

        double highCarbon = weekCarbon / 4;
        double midCarbon = weekCarbon * 0.35 / 3;
        double lowCarbon = weekCarbon * 0.15 / 2;


        double lowFat = weekFat / 4;
        double midFat = weekFat * 0.35 / 3;
        double highFat = weekFat * 0.15 / 2;

        System.out.println(">>>>>>>>>>> 高碳日饮食 两天(一周) <<<<<<<<<<<");
        departDayPlan(highCarbon, highFat, dayProtein);

        System.out.println(">>>>>>>>>>> 中碳日饮食 三天(一周) <<<<<<<<<<<");
        departDayPlan(midCarbon, midFat, dayProtein);

        System.out.println(">>>>>>>>>>> 低碳日饮食 两天(一周) <<<<<<<<<<<");
        departDayPlan(lowCarbon, lowFat, dayProtein);

    }



    public static void departDayPlan(double carbon, double fat, double protein){
        double breakfastCarbon = carbon * 0.3;
        double lunchCarbon = carbon * 0.2;
        double beforeCarbon = carbon * 0.1;
        double dinnerCarbon = carbon * 0.4;
        System.out.println("今日碳水总摄入:" + String.format("%.2f", carbon) + "g");
        System.out.println("早餐摄入碳水: " + String.format("%.2f", breakfastCarbon) + " g |||  午餐摄入碳水: " + String.format("%.2f", lunchCarbon) + "g |||  练前摄入碳水: " + String.format("%.2f", beforeCarbon) + "g |||  晚餐摄入碳水: " + String.format("%.2f", dinnerCarbon) + "g");
        System.out.println("全天脂肪摄入控制在: " + String.format("%.2f", fat) + "g");
        System.out.println("全天蛋白质摄入控制在: " + String.format("%.2f", protein) + "g");
    }
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) return "";
        for (int i = 0; i < tLen; i++) {
            standard.put(t.charAt(i), standard.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = -1;
        // 用于存最小长度  最小长度起始坐标 最小长度终止坐标
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        while (r < sLen) {
            r++;
            if (r < sLen && standard.containsKey(s.charAt(r))) {
                // 向右扩展滑动窗口时遇到需要记录的值时记录
                current.put(s.charAt(r), current.getOrDefault(s.charAt(r), 0) + 1);
            }
            // 每向右扩展滑动窗口之后 判断一下当前滑动窗口是否已经包含了标准的所有值 如果是 尝试从左端缩小窗口
            while (check() && l <= r) {
                // 判断当前长度是小于暂存 是的话记录当前窗口状态
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = r + 1;
                }
                // 看移动左边界时是否触及统计值 若触及则减去统计值
                if (standard.containsKey(s.charAt(l))) {
                    current.put(s.charAt(l), current.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check(){
        Set<Map.Entry<Character, Integer>> entries = standard.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (current.getOrDefault(key,0) < value) {
                return false;
            }
        }
        return true;
    }

}


