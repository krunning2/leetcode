public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return "";
        String[] splits = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String cur : splits){
            if(cur.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else if(cur.equals(".") || cur.isEmpty()){
                continue;
            }else{
                stack.push(cur);
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(! stack.isEmpty()){
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}