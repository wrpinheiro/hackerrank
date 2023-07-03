package algorithms.implementation;
import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        BigInteger bN = new BigInteger(N + "");
        
        BigInteger f = BigInteger.ONE;
        
        while (bN.compareTo(BigInteger.ONE) > 0) {
            f = f.multiply(bN);
            bN = bN.subtract(BigInteger.ONE);
        }
        
        System.out.println(f.toString());
        
        sc.close();
    }

}
