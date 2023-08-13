package Programmers.WalkingPark;

import java.util.Arrays;

public class WalkingPark {

    public static void main(String[] args) {

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

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

        // 3.routes를 split하여 각 변수에 담는다.
        for (int i = 0; i < routes.length; i++) {
            String direction = routes[i].split(" ")[0];
            int move = Integer.parseInt(routes[i].split(" ")[1]);
            int dx = robot_x;
            int dy = robot_y;


            //move에 따라 한칸씩 옮길 때마다 해당 유효성 체크를 시작한다.
            for (int j = 0; j < move; j++) {

                if(direction.equals("E")){
                    dy++;
                }
                if(direction.equals("W")){
                    dy--;
                }
                if(direction.equals("N")){
                    dx--;
                }
                if(direction.equals("S")){
                    dx++;
                }


                if (0 <= dx && dx < parkArray.length && 0 <= dy && dy < parkArray[0].length) {
                    if (parkArray[dx][dy] == 'X') {
                        break;
                    }

                    if (j == move - 1) {
                        robot_x = dx;
                        robot_y = dy;
                    }

                }
            }
        }

        // 4.유효성 검증을 체크한다.(장애물 체크, 공원 범위 체크)
        // 5.이상이 없을 경우 해당 이동수 만큼 이동한다.

        return new int[]{robot_x, robot_y};
    }

}
