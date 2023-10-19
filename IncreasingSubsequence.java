// Java code for above approach
import java.util.*;

class GFG {

  // Function to find the second
  // longest increasing subsequence
  public static int secondLis(int arr[], int n)
  {
    // Initialize dpL array with
    // 1 which Store the length of
    // the longest increasing subsequences
    int dpL[] = new int[n];
    Arrays.fill(dpL, 1);

    // Initialize dpC array with
    // 1 which store the count of
    // the longest increasing
    // subsequence at each index
    int dpC[] = new int[n];
    Arrays.fill(dpC, 1);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        // If current element is
        // smaller
        if (arr[i] <= arr[j])
          continue;

        if (dpL[j] + 1 > dpL[i]) {

          // If new longer lis found,
          // update current length
          // max upto this index as
          // dpL[j]+1, and also
          // update count of current
          // size as that of dpC[j]th
          dpL[i] = dpL[j] + 1;
          dpC[i] = dpC[j];
        }
        else if (dpL[j] + 1 == dpL[i]) {
          // Else if similar length,
          // add up ith index count
          // with jth.
          dpC[i] += dpC[j];
        }
      }
    }

    // Finding length of LIS
    int maxLength = 0;
    for (int i : dpL) {
      maxLength = Math.max(i, maxLength);
    }

    // Stores the count of LIS
    int count = 0;

    // Finding count
    for (int i = 0; i < n; i++) {
      // Update the count
      if (dpL[i] == maxLength)
        count += dpC[i];
    }

    // If count is more than 1 LIS
    // then second longest will be
    // same as length of LIS(maxLength)
    // else it will be maxLength-1
    if (count > 1) {
      return maxLength;
    }
    else {
      return maxLength - 1;
    }
  }

  public static void main(String[] args)
  {
    int arr[] = { 1, -4, 3, 5, 9 };
    int n = arr.length;
    System.out.printf(
      "Length of second longest increasing subsequence is %d\n",
      secondLis(arr, n));
  }
}
