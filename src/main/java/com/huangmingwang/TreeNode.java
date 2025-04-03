package com.huangmingwang;

public class TreeNode {
    
    String question;
    String guess;
    boolean isLeaf;
    TreeNode yes;
    TreeNode no;

    public TreeNode(String guess) {
        this.question = null;
        this.guess = guess;
        this.isLeaf = true;
        this.yes = null;
        this.no = null;
    }

    public void convertToBranch(String question,String yesGuess,String noGuess) {
        this.question = question;
        this.isLeaf = false;
        this.yes = new TreeNode(yesGuess);
        this.no = new TreeNode(noGuess);
        this.guess = null;
    }
}