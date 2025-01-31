package Tiktok2025;

import java.util.Stack;

// https://leetcode.com/problems/score-of-parentheses/description/?envType=company&envId=tiktok&favoriteSlug=tiktok-six-months
public class ScoreofParentheses856M {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for (Character c:s.toCharArray()) {
            if(c=='('){
                stack.push(score);
                score = 0;
            }else if(c==')'){
                score = stack.pop()+Math.max(2*score, 1);
            }
        }   
        return score;
    }
}
