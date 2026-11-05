package rsaCryptography;

public final class RsaMath {

    //klassen indeholder kun matematiske hjælpefunktioner

    private RsaMath() {

    }

    public static long gcd(long a, long b) {
        //ToDo

        return 404; //skal rettes når metoden er færdig
    }


    public static long modPow(long base, long exponent, long modulus) {
        //test if exponent <0: throws an exception



        //test if modulus <= 0: throw an Exception(


        long result = 1;
        base = Math.floorMod(base, modulus);

        while (exponent > 0) {

            //ToDo
        }

        return 404; //skal rettes når metoden er færdig
    }


}


