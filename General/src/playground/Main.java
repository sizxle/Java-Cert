package playground;

public class Main {

    public static int i= 1;
    public  int k= 1;

    int t=4;

    public static void main(String[] args) {

//        new Main().method2();
        method1(new Main());
    }

    private void method2() {
        System.out.println(i);
        System.out.println(k);
    }

    static public void method1(Main m){
        System.out.println(i);
        System.out.println(m.k);
    }
}
