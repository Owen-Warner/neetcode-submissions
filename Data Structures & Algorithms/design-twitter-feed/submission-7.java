class Twitter {
        PriorityQueue<int[]> tweetQueue;
        HashMap<Integer, ArrayList<Integer>> follows;
        int time = 0;

        public Twitter() {
            this.tweetQueue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
            this.follows = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            tweetQueue.add(new int[]{userId, tweetId, time++});
        }

        public List<Integer> getNewsFeed(int userId) {
            ArrayList<Integer> uFollow = follows.get(userId);
            PriorityQueue<int[]> copy = new PriorityQueue<>(tweetQueue);
            List<Integer> posts = new ArrayList<>();
            
            while (!copy.isEmpty() && posts.size() < 10) {
                int[] x = copy.poll();
                if (x[0] == userId || (uFollow != null && uFollow.contains(x[0]))) {
                    posts.add(x[1]);
                }
            }
            return posts;
        }

        public void follow(int followerId, int followeeId) {
            ArrayList<Integer> temp = follows.get(followerId);
            if (temp == null) {
                temp = new ArrayList<>();
                follows.put(followerId, temp);
            }
            if (!temp.contains(followeeId)) {
                temp.add(followeeId);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            ArrayList<Integer> temp = follows.get(followerId);
            if(temp != null){
                temp.remove(Integer.valueOf(followeeId));
                follows.replace(followerId, temp);
            }
        }
    }