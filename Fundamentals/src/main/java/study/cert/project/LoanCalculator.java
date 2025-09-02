package study.cert.project;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculator {

    private static final byte MONTHS_IN_YEAR=12;
    private static final byte PERCENT=100;
    private static double principalAmount;
    private static double interestRate;
    private static int term;
    private static double repayment;


    private static void calculateRepayment(){
        double monthlyInterest=interestRate/PERCENT/MONTHS_IN_YEAR;
        int numOfRepayments=term*MONTHS_IN_YEAR;
        double control=Math.pow(1+monthlyInterest,numOfRepayments);
        repayment= (principalAmount*monthlyInterest*control)/(control-1);
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Principal Amount: ");
        principalAmount = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        interestRate = scanner.nextDouble();
        System.out.print("Term (Years):");
        term = scanner.nextInt();
        LoanCalculator.calculateRepayment();
        System.out.print("Repayment: "+ NumberFormat.getCurrencyInstance().format(repayment));
    }
}
