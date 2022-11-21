import java.util.Scanner;
import java.io.File;
public class Board{

public Board(){
}
String phrase = loadPhrase();

private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    tempPhrase = "how are you";
    
    try 
    {
      
      Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/a1-Aparneesh/PhraseSolver/phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File(/*Replace with the path*/"/workspace/a1-Aparneesh/PhraseSolver/phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }

    return tempPhrase;
  }

  // takes the random phrase from loadphrase and makes blanks
public String blankMaker(){
  String phraseHolder = "";
  for(int i = 0; i < phrase.length(); i++){
    // everything that isn't a space is a blank
    if (!phrase.substring(i, i + 1).equals(" ")){
      phraseHolder += "_";
    }
    // space stays a space
    else if(phrase.substring(i, i + 1).equals(" ")){
      phraseHolder += " ";
    }
  }
  return phraseHolder;

}

public void guessChecker(){

  Player p = new Player();
  String playerOne = p.playerOne();
  String playerTwo = p.playerTwo();
  // Frank Norris is a cool guy. 11/18/2022 </3
  String blanks = blankMaker();
  boolean isTherePlayer = true;
  boolean isTherePlayerTwo = false;
  String playerName = p.getPlayerOneName();
  String playerNameTwo = p.getPlayerTwoName();
  
  System.out.println(blanks);
  

  String chars = "";
  String blank = "";
  // if the input isn't equal to the phrase, this loop runs
  while (!(blank.equals(phrase))){
    Scanner sc = new Scanner(System.in);
    boolean invalidInput = true;
    String guessOne = "";
    

    //makes sure that more than two letter isn't allowed
    while (invalidInput) {
      System.out.println("What letter will you guess? ");
      guessOne = sc.nextLine();

      if (guessOne.length() == 1){
        //breaks out of the loop if guess is one letter
        invalidInput = false;
      } else {
        invalidInput = true;
        System.out.println("Guess only one letter!");
      }
    }
    chars += guessOne + ", ";
    blank = "";
   
    // if player one's guess is in the phrase
    if (phrase.contains(guessOne)){
      for(int i = 0; i < blanks.length(); i++){
        // if player one's guess is in the phrase, it adds to blanks
        if (phrase.substring(i, i +1).contains(guessOne)){
          blank += blanks.substring(i, i+1).replace(blanks.substring(i, i+1), guessOne);
         }
         // checks for other letters in chars, which are previous guesses, and adds it blanks 
         else if (chars.contains(phrase.substring(i, i +1))){
          blank += blanks.substring(i, i+1).replace(blanks.substring(i, i+1), phrase.substring(i, i +1));
         }
         else{
          // everything else is blanks
           blank += "_";
         }

        }
      System.out.println(blank + "\n");
      }
    
    else{
      System.out.println("Thats not a letter in the word!\n");
      // player two's trun
     


      // same as loop above
      for(int i = 0; i < blanks.length(); i++){
         if (phrase.substring(i, i +1).contains(guessOne)){
          blank += blanks.substring(i, i+1).replace(blanks.substring(i, i+1), guessOne);
         }
         else if (chars.contains(phrase.substring(i, i +1))){
           blank += blanks.substring(i, i+1).replace(blanks.substring(i, i+1), phrase.substring(i, i +1));
         }
         else{
           blank += "_";
         }

        }
        System.out.println(blank + "\n");

      // checks who's turn it is and switches turn
      if (isTherePlayerTwo == false){
        isTherePlayer = false;
        isTherePlayerTwo = true;
        System.out.println("It's " + playerNameTwo + "'s turn");
      }
      else {
        isTherePlayer = true;
        isTherePlayerTwo = false;
        System.out.println("It's " + playerName + "'s turn");
      }


      }
      

    }
  

  // checks who won based on what is true and what is false
  if (isTherePlayer == true){
    System.out.print(playerName + " won!");
  }
  else{
    System.out.print(playerNameTwo + " won!");
  }
}





}

  
 









