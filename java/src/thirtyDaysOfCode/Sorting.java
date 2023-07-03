package thirtyDaysOfCode;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int arr[] = {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470 };

        int sortedArray[] = Arrays.stream(arr).sorted().toArray();

        StringBuilder sb = new StringBuilder();

        long min = Integer.MAX_VALUE;
        long temp;
        
        for (int i = 1; i < sortedArray.length - 1; i++) {
//            for (int j = i + 1; j < sortedArray.length; j++) {
                temp = Math.abs(sortedArray[i] - sortedArray[i-1]);
                if (temp < min) {
                    min = temp;
                    sb.setLength(0); 
                    sb.append(sortedArray[i]).append(" ").append(sortedArray[i-1]).append(" ");
                } else if (temp == min) {
                    sb.append(sortedArray[i]).append(" ").append(sortedArray[i-1]).append(" ");
                }
//            }
        }

        System.out.println(sb);
    }
}
