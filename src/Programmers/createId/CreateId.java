package Programmers.createId;

public class CreateId {

        public String solution(String new_id) {
            new_id = upperCase(new_id);
            new_id = exclude_char(new_id);
            new_id = change_dot(new_id);
            new_id = delete_dot(new_id);
            new_id = isEmpty(new_id);
            new_id = isHighLength(new_id);
            new_id = isLowLength(new_id);
            return new_id;
        }

        //1단계
        public String upperCase(String new_id){
            return new_id  = new_id.toLowerCase();
        }

        //2단계
        public String exclude_char(String new_id){
            String canSpecialChar = "[^-_.a-z0-9]";

            return new_id  = new_id.replaceAll(canSpecialChar,""); 
        }

        //3단계
        public String change_dot(String new_id){
            while(new_id.contains("..")){
                new_id = new_id.replace("..",".");
            }
            return new_id;
        }

        //4단계
        public String delete_dot(String new_id){
            while(new_id.startsWith(".")){
                new_id = new_id.substring(1,new_id.length());
            }

            while(new_id.endsWith(".")){
                new_id = new_id.substring(0,new_id.length()-1);
            }
            return new_id;
        }

        //5단계
        public String isEmpty(String new_id){
            if(new_id.length()==0){
                return "a";
            }
            return new_id;

        }

        //6단계
        public String isHighLength(String new_id){
            if(new_id.length()>15){
                new_id =  new_id.substring(0,15);
            }

            return delete_dot(new_id);
        }

        //7단계
        public String isLowLength(String new_id){

            while(new_id.length() < 3){
                new_id += new_id.substring(new_id.length()-1, new_id.length());
            }

            return new_id;
        }

        public static void main(String[] args) {
            CreateId createId = new CreateId();

            String id = "=.=";

            String answer = createId.solution(id);

            System.out.println(answer);
        }

}
