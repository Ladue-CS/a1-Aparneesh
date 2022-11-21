public class Main {
    
    public static void main(String[] args){
        System.out.println("WELCOME TO HANGMAN! You are given one phrase (which is hidden) and whoever guesses the phrase wins! You play this game by alernating turns between two players guessing one letter at a time. If the guessed letter is right, then the turn isn't changed. Without anymore distractions, let's begin!\n");
        Board board = new Board();
        board.guessChecker();
    }


}
