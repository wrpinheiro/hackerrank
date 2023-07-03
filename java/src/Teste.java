public class Teste {
    public static void main(String[] args) {
        System.out.println(findPermutations(20));
    }

    public static int findPermutations(int sequenceLength) {
        return partialFactorial(sequenceLength, sequenceLength / 2) / partialFactorial(sequenceLength / 2, 1);
    }

    public static int partialFactorial(int from, int to) {
        int f = 1;
        for (int i = from; i > to; i--) {
            f *= i;
        }

        return f;
    }
}

//0
//1
//2
//
//3
//floor(3/2) = 1
//
//se total for impar meio = floor(3/2)
//
//0 - 0
//1 - 1
//2 - 0'
//
//0 - 0
//1 - 1
//2 - 1'
//3 - 0'
//
//0 - 0
//1 - 1
//2 - 2 (5 - idx - 1))
//3 - 1 (5 - idx - 1))
//4 - 0 (5 - idx - 1))
//
//
//0 - 0
//1 - 1
//2 - 2
//3 - 2 (6 - 3 - 1)
//4 - 1 (6 - 4 - 1)
//5 - 0 (6 - 5 - 1)
//
//se total for par então idxInvert = floor(total/2) + 1
//senao, idxInvert = floor(total/2) + 2
//
//se k < idxInvert
//  return calcula
//senão return inverte(total - k - 1)
