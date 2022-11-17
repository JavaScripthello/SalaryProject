package com.kw.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: SalaryProject
 * @description:
 * @author: kangwei
 * @create: 2022-10-13 16:38
 **/
public class Test {
        public static void main(String[] args) {
            List<Map<String,String>> list = new ArrayList<>();
            Map<String,String> map1 = new HashMap<>();
            map1.put("name","冯宝宝");
            map1.put("money","123");
            list.add(map1);
            Map<String,String> map2 = new HashMap<>();
            map2.put("name","张楚岚");
            map2.put("money","456");
            list.add(map2);
            Map<String,String> map3 = new HashMap<>();
            map3.put("name","王也");
            map3.put("money","789");
            list.add(map3);
            Map<String,String> map4 = new HashMap<>();
            map4.put("name","张楚岚");
            map4.put("money","100");
            list.add(map4);
            Map<String,String> map5 = new HashMap<>();
            map5.put("name","冯宝宝");
            map5.put("money","200");
            list.add(map5);
//            list = list.stream().collect(Collectors.groupingBy(d ->
//                    d.get("name"))).values().stream().map(e -> {
//                Map<String, String> map = e.get(0);
//                map.put("money", e.stream().map(f ->
//                        new BigDecimal(f.get("money")))
//                        .reduce(BigDecimal.ZERO, BigDecimal::add).toString());
//                return map;
//            }).collect(Collectors.toList());
//            System.out.println("分组求和后的list:" + list);

            Map<String, List<Map>> map = list.stream().collect(Collectors.groupingBy(
                    (Map m) -> (String)m.get("name"))
            );
            System.out.println(map);


            //统计集合重复元素出现次数，并且去重返回hashmap
            Map<String, Long> map1111 = new HashMap<>();
            for (Map<String, String> d : list) {
                map1111.merge(d.get("name"), 1L, Long::sum);
            }
            System.out.println(map1111);
        }


}
