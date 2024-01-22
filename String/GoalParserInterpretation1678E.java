package String;

//https://leetcode.com/problems/goal-parser-interpretation/
public class GoalParserInterpretation1678E {
    public static void main(String[] args) {
        String command = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(interpret(command));
    }

    public static String interpret(String command) {
        String ans = "";
        command = command.replace("()", "o");
        for (Character c : command.toCharArray()) {
            if (c == '(' || c == ')') {
                continue;
            }
            ans += c;
        }
        return ans;
    }
}
