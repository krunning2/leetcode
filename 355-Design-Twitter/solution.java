public class Twitter {
    
    public static int counter = 0;
    private static Map<Integer, User> u_map;
    class User {
        int uId;
        Set<Integer> followed;
        Tweet head;
        
        public User(int uId){
            this.uId = uId;
            followed = new HashSet<Integer>();
            head = null;
        }
        
        public void follow(int id){
            followed.add(id);
        }
        
        public void unfollow(int id){
            followed.remove(id);
        }
        
        public void post(int id){
            Tweet t = new Tweet(id, counter++);
            t.next = head;
            head = t;
        }
        
    }
    
    class Tweet {
        Tweet next;
        int id;
        int time;
        public Tweet(int id, int time){
            this.id = id;
            this.time = time;
            next = null;
        }
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        u_map = new HashMap();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        u_map.putIfAbsent(userId, new User(userId));
        u_map.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User u = u_map.get(userId);
        Set<Integer> users = u.followed;
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(users.size(), (t1, t2) -> (t2.time - t1.time));
        users.foreach(uId ->{
            if(u_map.get(uId).head != null){
                queue.offer(head);
            }
        });
        List<Integer> res = new ArrayList();
        int n = 0;
        while(!queue.isEmpty() && n < 10){
            Tweet cur = queue.poll();
            res.add(cur.id);
            if(cur.next != null){
                queue.offer(cur.next);
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        u_map.putIfAbsent(followerId, new User(followerId));
        u_map.putIfAbsent(followeeId, new User(followeeId));
        u_map.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!u_map.containsKey(followerId) || !u_map.containsKey(followeeId) || followeeId == followerId){
            return;
        }
        u_map.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */