package Programmers.lottomintomax;

public class LottoMinToMax {
    public int[] solution(int[] lotto, int[] win_nums) {
        //Test Commit
        int match_cnt = 0;
        int zero_cnt = 0;
        for(int i: lotto){
            if(i==0){
                zero_cnt ++;
                continue;
            }
            for(int j : win_nums){
                if ( i == j ) {
                    match_cnt++;
                    break;
                }
            }
        }
        System.out.println("zero_cnt = " + zero_cnt);
        System.out.println("match_cnt = " + match_cnt);

        int[] answer = {0,0};
        answer[0] = Math.min(7-(zero_cnt+match_cnt), 6);
        answer[1] = Math.min(7-(match_cnt), 6);

        return  answer;
    }

    public static void main(String[] args) { 
        LottoMinToMax lotto_max_min = new LottoMinToMax();


        int[] lotto1 ={44, 1, 0, 0, 31, 25};  
        int[] win_nums ={31, 10, 45, 1, 6, 19};

        int[] answer = lotto_max_min.solution(lotto1, win_nums);

        System.out.println(answer[0]+","+answer[1]);
    }

}
