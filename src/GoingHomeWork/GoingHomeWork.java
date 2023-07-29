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

        String[] solution = solution(plans);

        System.out.println("solution = " + Arrays.toString(solution));


    }

    public static String[] solution(String[][] plans) {

        String[] answer = new String[plans.length];
        int index = 0;

        //먼저 일단 시간별로 정렬한다.
        Arrays.sort(plans, Comparator.comparingInt(a -> parseToMinute(a[1])));

        //스택선언하여 과제를 시작하다가 다하지 못한 것들을 넣어준다.
        Stack<Plan> planStack = new Stack<>();
        for (int i = 0; i < plans.length-1; i++) {

            //현재과목시작시간, 다음과목시작시간
            int curentSubjectTime = parseToMinute(plans[i][1]);
            int nextSubjectTime = parseToMinute(plans[i + 1][1]);
            int diffTime = nextSubjectTime - curentSubjectTime;

            if (diffTime < Integer.parseInt(plans[i][2])) {
                //stack.add(new String[] {plans[i][0], String.valueOf(diff)});
                Plan plan = new Plan(plans[i][0], Integer.parseInt(plans[i][2]) - diffTime);
                planStack.push(plan);
            }else {
                answer[index++] = plans[i][0];
                int remainTime = diffTime - Integer.parseInt(plans[0][2]);
                while (!planStack.empty()) {
                    Plan remainPlan = planStack.pop();
                    if (remainPlan.remainTime > remainTime) {
                        remainPlan.remainTime = remainPlan.remainTime - remainTime;
                        planStack.push(remainPlan);
                        break;
                    } else {
                        answer[index++] = remainPlan.subject;
                        remainTime = remainTime - remainPlan.remainTime;
                    }

                    if(remainTime <= 0){
                        break;
                    }
                }
            }
        }

        answer[index++] = plans[plans.length-1][0];

        while (!planStack.empty()){
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


