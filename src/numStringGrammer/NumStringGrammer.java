package numStringGrammer;

import lottomintomax.LottoMinToMax;

public class NumStringGrammer {

    public enum ConvNumber{
        ZERO("zero","0")
        ,ONE("one","1")
        ,TWO("two","2")
        ,THREE("three","3")
        ,FOUR("four","4")
        ,FIVE("five","5")
        ,SIX("six","6")
        ,SEVEN("seven","7")
        ,EIGHT("eight","8")
        ,NINE("nine", "9");

        private String number;
        private String engNumber;

        private ConvNumber(String engNumber, String number){
            this.engNumber  = engNumber;
            this.number  = number;
        }
    }


    public static void main(String[] args) {
        NumStringGrammer numStringGrammer  = new NumStringGrammer();

        String test = "one4seveneight";

        ConvNumber[] values = ConvNumber.values();
        for( ConvNumber convNumber: values){
            String isEng = convNumber.engNumber;
            if (test.contains(isEng)){
                test = test.replaceAll(convNumber.engNumber,convNumber.number);
            }
        }

        System.out.println("test = " + test);

    }

}
