package interview;


public class Main {

    public static void main(String[] args) {

        System.out.println(anagrams("calm", "clam"));
        System.out.println(anagrams("hell", "help"));
    }

    //
    public static boolean anagrams(String a , String b ){

        if(a.length()!= b.length()){
            return false;
        }

        String[] split = b.split("");

        for (String string : split) {
            if(!a.contains(string) && b.contains(string)){
                return false;
            }
        }
        return true;
    }

}
