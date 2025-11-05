package study.cert.project;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculatorV4 {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR=12;
        final byte PERCENT=100;

        int principal=0;
        float monthlyInterest=0;
        int numberOfPayments=0;

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Principal Amount(R1K-R1M): ");
            principal=scanner.nextInt();
            if(principal>=1000 && principal<=1_000_000)
                break;
            System.out.println("Enter a number between 1000 and 1,000,000");
        }


        while (true){
            System.out.print("Annual Interest Rate: ");
            float annualInterest= scanner.nextFloat();
            if(annualInterest>0 && annualInterest<=30) {
                monthlyInterest=annualInterest/PERCENT/MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value grater than 0 but less than or equal 30");
        }

        while (true){
            System.out.print("Term (Years):");
            byte years= scanner.nextByte();
            if(years>=1 && years<=30){
                numberOfPayments=years*MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double repayments = principal*(monthlyInterest* Math.pow(1+monthlyInterest,numberOfPayments))/(Math.pow(1+monthlyInterest,numberOfPayments)-1);
        String repaymentFormatted= NumberFormat.getCurrencyInstance().format(repayments);
        System.out.println("Repayments: "+ repaymentFormatted);
    }
}
