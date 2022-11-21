import java.util.Scanner;
public class Player {
    String playerOneName = "";
    String playerTwoName = "";

    public Player(){
    }

    // user name
    public String playerOne(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter player one's name ");
        playerOneName = sc.next();
        return playerOneName;
    }

    // user two name
    public String playerTwo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter player two's name ");
        playerTwoName = sc.next();
        return playerTwoName;
    }
    
    // acessor 1
    public String getPlayerOneName(){
        return playerOneName;
    }

    // acessor 2
    public String getPlayerTwoName(){
        return playerTwoName;
    }
}
