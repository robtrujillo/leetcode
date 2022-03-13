class Solution {
    public boolean isValid(String s) {
        // LIFO data structure (last in, first out)
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        // loop the string
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // check if ending bracket
            if(c == ')') {
                // if stack is empty, there was not an opening bracket and invalid string
                if(stack.isEmpty()) {
                    return false;
                }
                // get last opening bracket found on stack
                char open = stack.pop();
                // if not a matching bracket, invalid string
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
                // must be an opening bracket, add to stack
                stack.push(c);
            }
        }
        // at end, all opening brackets should have been popped by their ending brackets and stack should be empty
        return stack.isEmpty();
    }
}