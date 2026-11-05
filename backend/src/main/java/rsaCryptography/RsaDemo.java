package rsaCryptography;

public class RsaDemo {

    public static void main(String[] args) {

        //test gcd-metoden:
        long result= RsaMath.gcd(48, 18);
        System.out.println("gcd(48, 18) = " + result);



        //test modPow:
        long powerResult = RsaMath.modPow(5, 3, 13);
        System.out.println("5^3 mod 13 = " + powerResult);

    }
}
