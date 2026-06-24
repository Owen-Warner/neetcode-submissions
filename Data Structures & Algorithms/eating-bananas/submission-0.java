class Solution {
    int minEatingSpeed(int[] piles, int h) {
      int low = 1;
      int high = piles[0];
      for(int x : piles){
        if(x > high){
            high = x;
        }
      }
      while (low < high) {
        int mid = (low + high) / 2;
        int hours = 0;
        for (int p : piles) {
            hours += (p + mid - 1) / mid;
        }
        if (hours <= h) {
            high = mid;
        }
        else {
            low = mid + 1;
        }
      }
      return low;
  }
}
