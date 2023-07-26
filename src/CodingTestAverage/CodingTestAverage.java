package CodingTestAverage;

import java.util.*;

public class CodingTestAverage {
    public static void main(String[] args) {

        String[] languages = {"C", "SWIFT", "JAVA", "SWIFT", "JAVA", "JAVA", "R"};
        int[][] scores = {
                {65, 80, 90},
                {46, 100, 70},
                {91, 96, 59},
                {89, 90, 61},
                {0, 94, 75},
                {38, 95, 47},
                {50, 60, 90}};
//        String[] languages = {"A", "AAA", "AA"};
//        int[][] scores = {{100, 50, 0, 30}, {100, 50, 0, 25}, {100, 50, 0, 30}};

        String[] solution = solution(languages, scores);
        System.out.println(Arrays.toString(solution));

    }


    public static String[] solution(String[] languages, int[][] scores) { 

        List<String> answerList = new ArrayList<>();

        for (int i = 0; i < scores[0].length; i++) {
            HashMap<String, List<Integer>> scoreMap = new HashMap<>();

            for (int j = 0; j < languages.length; j++) {
                int score = scores[j][i];
                List<Integer> integerList = new ArrayList<>();

                if (scoreMap.containsKey(languages[j])) {
                    integerList = scoreMap.get(languages[j]);
                }
                integerList.add(score);
                scoreMap.put(languages[j], integerList);
            }

            double average = 0;
            String maxAvarageKey = "";
            boolean isFirst = true;
            for (String key : scoreMap.keySet()) {

                List<Integer> scoreList = scoreMap.get(key);

                double keyAverage = scoreList.stream()
                        .mapToInt(Integer::intValue)
                        .average().getAsDouble();

                if (isFirst) {
                    maxAvarageKey = key;
                    average = keyAverage;
                    isFirst = false;
                    continue;
                }

                if (average < keyAverage) {
                    maxAvarageKey = key;
                    average = keyAverage;
                } else if (average == keyAverage) {
                    List<Integer> compareList = scoreMap.get(maxAvarageKey);
                    if (compareList == null) {
                        continue;
                    }

                    if (scoreList.size() == scoreMap.get(maxAvarageKey).size()
                            && maxAvarageKey.compareTo(key) < 0) {
                        maxAvarageKey = key;
                        average = keyAverage;
                    }
                }
            }

            answerList.add(maxAvarageKey);

        }
        return answerList.toArray(String[]::new);
    }

}
