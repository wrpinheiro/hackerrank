import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LexicographicPaths {
    public static class Cache {
        @SuppressWarnings("unchecked")
        List<char[]>[][] cache = new LinkedList[10][10];
        
        public char[] get(int h, int v, int k) {
            if (cache[h][v] != null)
                if (cache[h][v].size() > k)
                    return cache[h][v].get(k);

            return null;
        }
        
        public void add(int h, int v, int k, char[] path) {
            if (cache[h][v] == null) {
                cache[h][v] = new LinkedList<char[]>();
            }
            cache[h][v].add(path.clone());
        }

        public Object[] last(int h, int v) {
            if (cache[h][v] != null) {
                return new Object[] { cache[h][v].get(cache[h][v].size() - 1).clone(), cache[h][v].size() - 1 };
            }

            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Cache cache = new Cache();

        int testCases = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        
        for (int testCase = 0; testCase < testCases; testCase++) {
            int h = sc.nextInt();
            int v = sc.nextInt();
            int k = sc.nextInt();
            
            if (cache.get(h, v, k) != null) {
                sb.append(cache.get(h, v, k));
                if (testCase + 1 < testCases) {
                    sb.append('\n');
                }
            } else {
                int lastIdx = h + v;

                char[] path = new char[h + v];

                int tmpIdx = 0;
                
                while (tmpIdx < h)
                    path[tmpIdx++] = 'H';
                while (tmpIdx < lastIdx)
                    path[tmpIdx++] = 'V';

                Object[] last = cache.last(h, v);
                int i;
                if (last != null) {
                    i = (int) last[1];
                    path = (char[]) last[0];
                } else {
                    cache.add(h, v, 0, path);
                    i = 0;
                }
                
                while (i < k) {
                    next(path);
                    i++;
                    cache.add(h, v, i, path);
                }

                sb.append(path);
                if (testCase + 1 < testCases) {
                    sb.append('\n');
                }
            }
        }

        System.out.print(sb.toString());

        sc.close();
    }
    
    private static void next(char[] path) {
        int startSegToDecrement = path.length - 1;

        // HHVV
        //   |
        //   + startSegToDecrement
        // HHHVVH
        //    |
        //    + startSegToDecrement
        while (startSegToDecrement > 0 && 
                path[startSegToDecrement] <= path[startSegToDecrement - 1]) {
            startSegToDecrement--;
        }

        // str contains only H's
        if (startSegToDecrement == 0) return;
        
        int lastGreaterThanPrev = path.length - 1;
        while (path[lastGreaterThanPrev] == 'H') {
            lastGreaterThanPrev--;
        }
        
        // after swap HHVVHH
        swap(path, startSegToDecrement - 1, lastGreaterThanPrev);

        int endSegmentToInvert = path.length - 1;
        while (startSegToDecrement < endSegmentToInvert) {
            swap(path, startSegToDecrement, endSegmentToInvert);
            startSegToDecrement++;
            endSegmentToInvert--;
            
        }
    }

    private static void swap(char[] s, int i, int j) {
        char tmp = s[j];
        s[j] = s[i];
        s[i] = tmp;
    }
}
