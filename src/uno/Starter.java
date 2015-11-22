package uno;
import java.util.Scanner;


public class Starter {

        public static void main(String[] args) {
                @SuppressWarnings("unused")
				Starter starter = new Starter();

        }
        Starter(){

                Scanner keyboard;
                keyboard = new Scanner(System.in);
                
//              System.out.println("How many players?");
//              int players = keyboard.nextInt();
//              
//              System.out.println("How many starting cards?");
//              int cards = keyboard.nextInt();
                
                System.out.println("How many games?");
                int rounds = keyboard.nextInt();
                
                int totalRounds = 0;
                double averageRound[][] = new double[20][20];
                int highNumPlay = 10;
                int highNumCards = 10;
                
                for(int players = 2; players < highNumPlay; players++){
                        totalRounds = 0;
                        for(int cards = 2; cards < highNumCards; cards++){
                                totalRounds = 0;
                                for(int count = 0; count < rounds; count++){
                                        Game game = new Game(players, cards);
                                        totalRounds = totalRounds + game.start();
                                }
                                averageRound[players][cards] = totalRounds/rounds; 
                        }
                }
                for(int players = 2; players < highNumPlay; players++){
                        for(int cards = 2; cards < highNumCards; cards++){
                                System.out.print((int)averageRound[players][cards]+" ");
                        }
                        System.out.println();
                }
                DataDisplay display = new DataDisplay(averageRound, highNumCards, highNumPlay);
                display.setVisible(true);
                keyboard.close();
        }
}