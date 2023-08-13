package Programmers.deletewithcouple;

import java.util.Stack;

/**
 * 프로그래머스 문제 짝지어 제거하기
 * packageName    : Programmers.deletewithcouple
 * fileName       : Programmers.deletewithcouple
 * author         : jaeminlim
 * date           : 2022/07/09
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/07/09        jaeminlim       최초 생성
 */
public class deletewithcouple {

    public int deleteIfCouple(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char word = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == word){
                stack.pop();
            }else {
                stack.push(word);
            }
        }

        if(stack.isEmpty()) return 1;
        return 0;
    }

    public static void main(String[] args) {



    }

}
