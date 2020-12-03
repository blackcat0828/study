package Prac;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null; // 최고 점수 받은 아이디 저장
        int maxScore = 0; //최고 점수
        int totalScore = 0; //점수 합계
        double avg = 0;

        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        for(Map.Entry<String,Integer> en : entry){
            if(maxScore<en.getValue()){
                maxScore = en.getValue();
                name = en.getKey();
            }
            totalScore += en.getValue();
        }

        avg = totalScore/entry.size();

        System.out.println("평균점수 : " + avg);
        System.out.println("최고점수 : " + maxScore);
        System.out.println("최고점수 받은 아이디 : " + name);

    }
}
