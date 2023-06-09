/****************************************************************************
 * Author: Hirwa Ishimwe
 * Date: April 17, 2023
 * Description: Algorithm 3.12, Sequence Alignment Using Divide-and-Conquer
 * Problem: Determine an optimal alignment of two homologous DNA sequences.
 * Inputs: A DNA sequence x of length m and a DNA sequence y of length n.
 * Outputs: The cost of an optimal alignment of the two sequences. 
 ****************************************************************************/

 public class SequenceAlignmentDC {

    public static void main(String[] args) {

        //Define two DNA sequences as strings
        String x = "GAGCCATTTGAGTCT";
        String y = "CAGTTTCTTCGGCCT";

        //Get the length of each sequence
        int m = x.length();
        int n = y.length();

        //Record the start time
        long startTime = System.nanoTime();

        //Calculate the optimal cost of alignment
        int result = opt(x, y, m, n, 0, 0);

        //Calculate the elapsed time in milliseconds
        long elapsedTime = (System.nanoTime() - startTime);

        System.out.println("The optimal cost of alignment is: " + result);
        System.out.println("Time taken to compute the result: " + elapsedTime + " ns");
    }

    public static int opt(String x, String y, int m, int n, int i, int j) {
        //Base case: if we reach the end of the first sequence
        if (i == m) {
            return 2 * (n - j);
        }
        //Base case: if we reach the end of the second sequence
        else if (j == n) {
            return 2 * (m - i);
        } else {
            int penalty;

            //Determine the penalty for a mismatch between the current characters
            if (x.charAt(i) == y.charAt(j)) {
                penalty = 0;
            } else {
                penalty = 1;
            }

            //Recursively compute the optimal cost for the three possible moves
            return Math.min(Math.min(opt(x, y, m, n, i + 1, j + 1) + penalty,
                                     opt(x, y, m, n, i + 1, j) + 2),
                            opt(x, y, m, n, i, j + 1) + 2);
        }
    }
}

