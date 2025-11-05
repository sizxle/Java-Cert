package study.cert.project;

import java.text.NumberFormat;
import java.util.Scanner;

//v 3.1
public class LoanCalculatorV31 {

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
        LoanCalculatorV31 calculator = new LoanCalculatorV31();

        while (true){
            System.out.print("Principal Amount(R1K-R1M): ");
            calculator.principalAmount=scanner.nextInt();
            if(calculator.principalAmount>=1000 && calculator.principalAmount<=1_000_000)
                break;
            System.out.println("Enter a number between 1000 and 1,000,000");
        }

        while (true){
            System.out.print("Annual Interest Rate: ");
            calculator.annualInterest = scanner.nextFloat();
            if(calculator.annualInterest>0 && calculator.annualInterest<=30) {
                break;
            }
            System.out.println("Enter a value grater than 0 but less than or equal 30");
        }

        while (true){
            System.out.print("Term (Years):");
            calculator.term = scanner.nextInt();
            if(calculator.term>=1 && calculator.term<=30) {
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        System.out.print("Repayment: "+ NumberFormat.getCurrencyInstance().format(calculator.calculateRepayment()));
    }
}
