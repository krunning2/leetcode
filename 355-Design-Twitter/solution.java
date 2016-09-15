public class Twitter {

    class User{
        int id;
        // head always stores the latest tweet
        Tweet head;
        Set<Integer> followed;
        User(int id){
            this.id = id;
            followed = new HashSet<Integer>();
            follow(id);
            head = null;
        }
        
        public void follow(int u_id){
            followed.add(u_id);
        }
        
        public boolean unfollow(int u_id){
            if(followed.contains(u_id)){
                followed.remove(u_id);
                return true;
            }
            return false;
        }
        
        public void post(Tweet t){
            t.next = head;
            head = t;
        }
        
    }
    class Tweet{
        int id;
        Tweet next;
        int ts;
        Tweet(int id, int ts){
            next = null;
            this.id = id;
            this.ts = ts;
        }
    }
    
    public static int counter = 0;
    private static Map<Integer, User> u_map;
    
    /** Initialize your data structure here. */
    public Twitter() {
        u_map = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        u_map.putIfAbsent(userId, new User(userId));
        u_map.get(userId).post(new Tweet(tweetId, counter++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>((t1, t2) -> t2.ts - t1.ts);
        User u = u_map.get(userId);
        if(u == null) return res;
        u.followed.forEach(followeeId->{
            Tweet head = u_map.get(followeeId).head;
            if(head != null){
                queue.offer(head);
            }
        });
       
        while(res.size() < 10 && !queue.isEmpty()){
            Tweet t = queue.poll();
            res.add(t.id);
            if(t.next != null) queue.offer(t.next);
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
        if(!u_map.containsKey(followerId) || followerId == followeeId){
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