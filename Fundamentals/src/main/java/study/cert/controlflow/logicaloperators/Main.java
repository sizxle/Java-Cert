package study.cert.controlflow.logicaloperators;

public class Main {
    public static void main(String[] args) {
        boolean hasHighIncome=false;
        boolean hasGoodCredit= true;
        boolean hasCriminalRecord= false;

        boolean isEligable= (hasHighIncome || hasGoodCredit) && !hasCriminalRecord;

        System.out.println(isEligable);

    }

}
