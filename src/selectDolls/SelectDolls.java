package selectDolls;

import java.util.Stack;

public class SelectDolls {

    public static int solution(int[][] board, int[] moves) {

        Stack<Integer> selectedDolls = new Stack<Integer>();
        int getDollCount = 0;
        for(int i = 0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){

                if(board[j][moves[i]-1] != 0 ){
                    int  selectedDoll = board[j][moves[i]-1];
                    board[j][moves[i]-1] = 0;

                    if(!selectedDolls.empty() && selectedDolls.peek() == selectedDoll){
                        selectedDolls.pop();
                        getDollCount +=2;
                        break;
                    }
                    selectedDolls.push(selectedDoll);

                    break;
                }
            }

        }
        System.out.println("getDollCount = " + getDollCount);
        return getDollCount;
    }

    public static void main(String[] args) {

        int [][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int []moves = {1, 5, 3, 5, 1, 2, 1, 4};

        SelectDolls selectDolls = new SelectDolls();

        SelectDolls.solution(board, moves);
    }

}
