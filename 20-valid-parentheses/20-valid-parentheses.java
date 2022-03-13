class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if(open != '(') {
                    return false;
                }
            } else if(c == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if(open != '{') {
                    return false;
                }
            } else if(c == ']') {
                if(stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if(open != '[') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }
}