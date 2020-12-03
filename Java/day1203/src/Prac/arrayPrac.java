package Prac;

import java.util.*;

import static java.util.Objects.hash;

public class arrayPrac {


    public static void main(String[] args) {


        Set<String> setT = new HashSet<>();


       Map<String, Integer> map = new HashMap<>();

       map.put("홍길동",10);
       map.put("김동민",1031);
       map.put("정약용",104);
       map.put("전강진",23);

       Set<Map.Entry<String,Integer>> entry = map.entrySet();

       for(Map.Entry<String,Integer> a : entry){
           System.out.println(a.getKey());
           System.out.println(a.getValue());
       }



    }
}
