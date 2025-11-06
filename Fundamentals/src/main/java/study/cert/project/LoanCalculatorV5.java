package study.cert.project;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculatorV5 {

    public static void main(String[] args) {

        int principal = (int)readNumber("Principal Amount(R1K-R1M): ",1000,1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ",1,30);
        byte years = (byte) readNumber("Term (Years):",1,30);

        double repayments = calculateRepayments(principal, annualInterest, years);
        String repaymentFormatted= NumberFormat.getCurrencyInstance().format(repayments);
        System.out.println("Repayments: "+ repaymentFormatted);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double input;
        while (true){
            System.out.print(prompt);
            input= scanner.nextDouble();
            if(input >=min && input<=max)
                break;
            System.out.println("Enter a number between "+min+" and " +max);
        }
        return input;
    }

    public static double calculateRepayments(int principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR=12;
        final byte PERCENT=100;

        int numberOfPayments=years*MONTHS_IN_YEAR;
        float monthlyInterest=annualInterest/PERCENT/MONTHS_IN_YEAR;

        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

}
