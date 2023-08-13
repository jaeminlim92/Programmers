package Programmers.WalkingPark;

import java.util.Arrays;

public class WalkingPark {

    public static void main(String[] args) {

        String[] park = {"SOO","OXX","OOO"};
        String[] routes = {"E 2","S 2","W 1"};

        int[] solution = solution(park, routes);
        System.out.println("solution = " + Arrays.toString(solution));

    }


    public static int[] solution(String[] park, String[] routes) {
        int robot_x = 0;
        int robot_y = 0;

        // 1.공원의 범위를 파악한다.
        char[][] parkArray = new char[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            parkArray[i] = park[i].toCharArray();

            if (park[i].contains("S")) {
                // 2.로봇의 시작지점을 파악한다.
                robot_x = i;
                robot_y = park[i].indexOf("S");
            }
        }



        System.out.println("parkArray = " + Arrays.deepToString(parkArray));
        System.out.println("robot_x = " + robot_x);
        System.out.println("robot_y = " + robot_y);

        // 3.routes를 split하여 각 변수에 담는다.
        // 4.유효성 검증을 체크한다.(장애물 체크, 공원 범위 체크)
        // 5.이상이 없을 경우 해당 이동수 만큼 이동한다.

        return new int[]{robot_x, robot_y};
    }

}
