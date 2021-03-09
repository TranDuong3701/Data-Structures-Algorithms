import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final String input;
    private final List<String> leftBrackets = Arrays.asList("(","{","<","[");
    private final List<String> rightBrackets = Arrays.asList(")","}",">","]");

    public Expression(String input){
        this.input = input;
    }

    public boolean IsBalance(){
        Stack<Character> stack = new Stack<>();

        for(char ch: input.toCharArray()){
            if(isLeftBracket(ch))
                stack.push(ch);

            if(isRightBracket(ch)){
                if(stack.empty()) return false;

                var top = stack.pop();
                if(!bracketsMatch(top,ch))
                    return false;
            }
        }

        return stack.empty();
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }
}
