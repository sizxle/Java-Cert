package study.cert.controlflow.ifstatement;

public class Main {

    public static void main(String[] args) {

        int income = 120_000;

//        if(income> 100_00)
//            boolean hasHIghIncome=true; //declaration like this is not allowed

        /**
         * Version 1
         * */
//        boolean hasHIghIncome;
//        if (income > 100_00) {
//            hasHIghIncome = true;
//        } else {
//            hasHIghIncome = false;
//        }

        /**
         * Version 2
         * */
//        boolean hasHIghIncome=false;
//        if (income > 100_00) {
//            hasHIghIncome = true;
//        }
//
        /**
         * Version 3
         * */
        boolean hasHIghIncome=(income > 100_000);

    }
}
