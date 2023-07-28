package MemoryScore;

import java.util.Arrays;
import java.util.HashMap;

public class MemoryScore {

    public static void main(String[] args) {
        int[] solution = solution(new String[]{"may", "kein", "kain", "radi"},
            new int[]{5,10,1,3}, new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}});
        System.out.println("solution = " + Arrays.toString(solution));

    }


    public static int[] solution(String[] names, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> yearningMap = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            yearningMap.put(names[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            String[] photoArray = photo[i];
            int sum = 0;
            for (int j = 0; j < photoArray.length; j++) {
                sum += yearningMap.getOrDefault(photoArray[j],0);
            }
            answer[i] = sum;
        }
        return answer;
    }

}
