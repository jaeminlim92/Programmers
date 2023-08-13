package Programmers.MarathonGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MarathonGame {

    public static void main(String[] args) {
        String[] solution = solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},
            new String[]{"kai", "kai", "mine", "mine"});
        System.out.println("solution = " + Arrays.toString(solution));

    }

    public static String[] solution(String[] players, String[] callings) {

        Map<String, Integer> playerMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for (String caller : callings) {
            //불린 선수의 현재 순위를 불러낸다.
            int idx = playerMap.get(caller);

            if (idx > 0) {//현재 이 선수가 1등이 아니라면

                //swap 방식으로 앞에 선수와 위치와 바꾼다.
                String frontPlayer = players[idx - 1];
                players[idx - 1] = players[idx];
                players[idx] = frontPlayer;

                //playerMap에도 해당 순위를 최신화한다.
                playerMap.put(players[idx - 1], idx - 1);
                playerMap.put(frontPlayer, idx);
            }
        }

        return players;
    }



}
