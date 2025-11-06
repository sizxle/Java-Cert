package study.cert.project;

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanCalculatorV6 {

    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static void main(String[] args) {

        int principal = (int) readNumber("Principal Amount(R1K-R1M): ", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) readNumber("Term (Years):", 1, 30);

        printMothlyPayment(principal, annualInterest, years);
        printPaymentSchedule(years, principal, annualInterest);

    }

    private static void printMothlyPayment(int principal, float annualInterest, byte years) {
        double repayments = calculateRepayments(principal, annualInterest, years);
        String repaymentFormatted = NumberFormat.getCurrencyInstance().format(repayments);
        System.out.println();
        System.out.println("LOAN");
        System.out.println("____");
        System.out.println("Monthly Payments: " + repaymentFormatted);
    }

    private static void printPaymentSchedule(byte years, int principal, float annualInterest) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("________________");
        for (int month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(years, principal, annualInterest, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));

        }
    }

    public static double calculateBalance(byte years, int principal, float annualInterest, int numberOfPaymentsMade) {

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
1
        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade)) /
                (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;

    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextDouble();
            if (input >= min && input <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return input;
    }

    public static double calculateRepayments(int principal, float annualInterest, byte years) {

        int numberOfPayments = years * MONTHS_IN_YEAR;
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        return principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }

}
