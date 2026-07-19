class KthLargest {
        int k;
        int[] bigVals;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            bigVals = new int[this.k];
            Arrays.fill(bigVals, Integer.MIN_VALUE);
            for(int i : nums){
                insert(i);
            }
        }

        public void insert(int val){
            int loc = -1;
            for(int i = 0; i < bigVals.length; i++){
                if(bigVals[i] < val){
                    loc = i;
                    break;
                }
            }
            if(loc == -1){
                return;
            }
            for(int i = bigVals.length-1; i > loc; i--){
                bigVals[i] = bigVals[i-1];
            }
            bigVals[loc] = val;
        }

        public int add(int val) {
            insert(val);
            return bigVals[k-1];
        }
    }