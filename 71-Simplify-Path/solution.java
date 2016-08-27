public class Solution {
    public String simplifyPath(String path) {
        if(path == null){
            return path;
        }
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String part : parts){
            if(part.equals(".")){
                continue;
            }else if(part.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else if(!part.equals("")){
                stack.push(part);
            }
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop()).insert(0, "/");
        }
        return sb.toString();
    }
}