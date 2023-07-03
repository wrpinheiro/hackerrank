package others;

import static java.lang.String.format;

import java.util.Scanner;

public class MatchingString {
    
    public int compareStrings(String s1, String s2) {
        int minChanges = 0;
        char lastLetterSeen = '\0';
        
        int i = 0, j = 0;
        
        while (i < s1.length() && j < s2.length() && minChanges != -1) {
            if (s1.charAt(i) == s2.charAt(j)) {
                lastLetterSeen = s1.charAt(i);
                i++;
                j++;
            } else {
                if (s1.charAt(i) == lastLetterSeen) {
                    while (i < s1.length() && s1.charAt(i) == lastLetterSeen) {
                        minChanges++;
                        i++;
                    }                    
                } else if (s2.charAt(j) == lastLetterSeen) {
                    while (j < s2.length() && s2.charAt(j) == lastLetterSeen) {
                        minChanges++;
                        j++;
                    }
                } else {
                    minChanges = -1;
                }
            }
        }
        
        if (minChanges != -1) {
            while (i < s1.length() && minChanges != -1) {
                if (s1.charAt(i) == lastLetterSeen) {
                    minChanges++;
                    i++;
                } else {
                    minChanges = -1;
                }
            }
            
            while (j < s2.length() && minChanges != -1) {
                if (s2.charAt(j) == lastLetterSeen) {
                    minChanges++;
                    j++;
                } else {
                    minChanges = -1;
                }
            }
        }

        return minChanges;
    }
    
    public static final void assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException(format("Expected %d but found %d", expected, actual));
        }
    }

    public static void main(String[] args) {
        MatchingString ms = new MatchingString();

        assertEquals(ms.compareStrings("ABC", "ABC"), 0);
        
        assertEquals(ms.compareStrings("AABCDEE", "AAAABCCDE"), 4);
        assertEquals(ms.compareStrings("AAAABCCDE", "AABCDEE"), 4);
        
        assertEquals(ms.compareStrings("ABC", "ACB"), -1);
        
        assertEquals(ms.compareStrings("AAA", "AB"), -1);
        assertEquals(ms.compareStrings("AB", "AAA"), -1);
        
        System.out.println("YESSSS, I'm so happy!!!");
    }

}
