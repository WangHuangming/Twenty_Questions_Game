package com.huangmingwang;

import java.util.Scanner;

public class TwentyQuestionsGame {
    
    private TreeNode root;
    private Scanner mainScanner;

    public TwentyQuestionsGame() {
        // Initialize the game with a default tree
        root = new TreeNode("dog");
    }

    public TwentyQuestionsGame(TreeNode root) {
        this.root = root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setScanner(Scanner mainScanner) {
        this.mainScanner = mainScanner;
    }

    public Scanner getScanner() {
        return mainScanner;
    }

    public void greeting(){
        System.out.println("Welcome to the 20 Questions Game!");
        System.out.println("Think of an person, and I will try to guess it.");
        System.out.println("Please answer with 'yes' or 'no'. Please notice it is case-sensitive.");
    }

    public void play(){
        TreeNode curr = root;
        while(!curr.isLeaf){
            //ask the question from curr and keep going down the tree until a leaf node is reached
            System.out.println(curr.question);
            String answer = mainScanner.nextLine();
            if(answer.equals("yes")){
                curr = curr.yes;
            }else if(answer.equals("no")){
                curr = curr.no;
            }else{
                System.out.println("Please answer with 'yes' or 'no'.");
                continue;
            }
        }
        //if correct then return
        //if not correct then ask the user what is the answer with a question that can distinguish the current guess from the actual object
        //run learn() to build the subtree
        System.out.println("Is it a " + curr.guess + "?");
        String answer = mainScanner.nextLine();
        if(answer.equals("yes")){
            System.out.println("I am awesome! I guessed it right!");
        }else{
            System.out.println("Bummer! I couldn't guess it.");
            learn(curr);
        }
    }

    public void learn(TreeNode curr){
        // convert the current node to a branch
        System.out.println("What is the object you are thinking of?");
        String newGuess = mainScanner.nextLine();
        System.out.println("Please give me a question that differentiate " + curr.guess + " and " + newGuess + ".");
        String question = mainScanner.nextLine();
        System.out.println("Is the answer for your item yes or no?");
        String answer = mainScanner.nextLine();
        if(answer.equals("yes")){
            curr.convertToBranch(question, newGuess, curr.guess);
        }else if(answer.equals("no")){
            curr.convertToBranch(question, curr.guess, newGuess);
        }
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        TreeNode root = new TreeNode("fish");
        TwentyQuestionsGame game = new TwentyQuestionsGame(root);
        game.setScanner(myScanner);
        game.greeting();
        game.play();

        while(true){
            System.out.println("Do you want to play again? (yes/no)");
            String answer2 = myScanner.nextLine();
            if(answer2.equals("yes")){
                game.play();
            }else{
                System.out.println("Thank you for playing!");
                break;
            }
        }
        myScanner.close();
        return;
    }
}
