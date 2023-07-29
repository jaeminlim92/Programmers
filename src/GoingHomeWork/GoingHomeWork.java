package GoingHomeWork;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class GoingHomeWork {

    public static void main(String[] args) {

        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"},
            {"math", "12:30", "40"}};

        String[][] plans1 = {{"science", "12:40", "50"}, {"music", "12:20", "40"},
            {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        String[][] plans2 = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"},
            {"ccc", "12:40", "10"}};

        String[] solution = solution(plans2);

        System.out.println("solution = " + Arrays.toString(solution));


    }

    public static String[] solution(String[][] plans) {

        String[] answer = new String[plans.length];
        int index = 0;

        //먼저 일단 시간별로 정렬한다.
        Arrays.sort(plans, Comparator.comparingInt(a -> parseToMinute(a[1])));

        //스택선언하여 과제를 시작하다가 다하지 못한 것들을 넣어준다.
        Stack<Plan> planStack = new Stack<Plan>();
        for (int i = 0; i < plans.length - 1; i++) {
            int curentSubjectTime = parseToMinute(plans[i][1]);
            int nextSubjectTime = parseToMinute(plans[i + 1][1]);

            //만약 다음과목시작시간과 현재과목시간을 뺀 값이 과제하는제 필요한 시간보다 작다면
            if (nextSubjectTime - curentSubjectTime < Integer.parseInt(plans[i][2])) {
                //다하지 못한 과목과, 남은시간을 Stack에 넣어준다.
                Plan remainSubject = new Plan(plans[i][0],
                    Integer.parseInt(plans[i][2]) - (nextSubjectTime - curentSubjectTime));

                planStack.push(remainSubject);
                //시간 내에 현재과제를 완료했다면.
            } else {
                //완료한 과목을 완료 배열에 넣어준다.
                answer[index++] = plans[i][0];
                //남은시간을 계산한다.
                int remainTime =
                    nextSubjectTime - curentSubjectTime - (Integer.parseInt(plans[i][2]));

                //그리고 남은 과목이 있다면 남은 과제를 풀어준다.
                while (true) {
                    if (!planStack.isEmpty()) {
                        Plan remainSubject = planStack.pop();

                        //남은 과목의 시간이 남은시간보다 적다면
                        if (remainSubject.remainTime <= remainTime) {
                            remainTime -= remainSubject.remainTime;
                            answer[index++] = remainSubject.subject;
                        } else {
                            remainSubject.remainTime -= remainTime;
                            planStack.push(remainSubject);
                            break;
                        }

                    } else {
                        break;
                    }

                    if (remainTime <= 0) {
                        break;
                    }
                }
            }
        }

        while (!planStack.isEmpty()) {
            answer[index++] = planStack.pop().subject;
        }

        return answer;
    }

    private static int parseToMinute(String time) {
        String[] parseTime = time.split(":");
        int hour = Integer.parseInt(parseTime[0]) * 60;
        int minute = Integer.parseInt(parseTime[1]);

        return hour + minute;
    }

    private static class Plan {

        String subject;
        int remainTime;

        public Plan(String subject, int remainTime) {
            this.subject = subject;
            this.remainTime = remainTime;
        }

        @Override
        public String toString() {
            return "subject='" + subject + ", remainTime=" + remainTime;
        }
    }
}


