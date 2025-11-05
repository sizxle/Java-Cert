package study.cert.project;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculatorV2 {
    private static final byte MONTHS_IN_YEAR=12;
    private static final byte PERCENT=100;
    private  double principalAmount;
    private  float annualInterest;
    private  int term;


    private double calculateRepayment(){
        double monthlyInterest= annualInterest /PERCENT/MONTHS_IN_YEAR;
        int numOfRepayments=term*MONTHS_IN_YEAR;
        double control=Math.pow(1+monthlyInterest,numOfRepayments);
        return (principalAmount*monthlyInterest*control)/(control-1);
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        LoanCalculatorV2 calculator = new LoanCalculatorV2();
        System.out.print("Principal Amount: ");
        calculator.principalAmount = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        calculator.annualInterest = scanner.nextFloat();
        System.out.print("Term (Years):");
        calculator.term = scanner.nextInt();
        System.out.print("Repayment: "+ NumberFormat.getCurrencyInstance().format(calculator.calculateRepayment()));
    }
}
