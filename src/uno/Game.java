package uno;

import java.util.ArrayList;
//Colors: 0 Red; 1 Green; 2 Blue; 3 Yellow
//Numbers: 0-9 Numbers; 10 Skip; 11 Draw 2; 12 Reverse; 13 Any Color; 14 Any Color Draw 4;
import java.util.Scanner;

public class Game {
        public ArrayList<Player> players = new ArrayList<Player>();
        int Players = 0, Cards = 0;
        Scanner keyboard = new Scanner(System.in);
        Game(int importedPlayers, int importedCards){
                Players = importedPlayers;
                Cards = importedCards;
                for(int count = 0; count < Players; count ++){
                        Player player = new Player(Cards);
                        players.add(player);
                }
        }
        public int start(){
                Card currentCard = Card.getNewCard();
                CurrentPlayer currentPlayer = new CurrentPlayer(players.size());
                int count = 0;
                do{
                        currentCard = players.get(currentPlayer.getCurrentPlayer()).playerTurn(currentCard);
                        
                        if(currentCard.type() == CardType.DRAW_TWO){
                        	currentPlayer.nextPlayer();
                            players.get(currentPlayer.getCurrentPlayer()).draw(2);
                            currentPlayer.nextPlayer();
                        }else if(currentCard.type() == CardType.SKIP){
                        	currentPlayer.nextPlayer();
                            currentPlayer.nextPlayer();
                        }else if(currentCard.type() == CardType.WILD_DRAW_FOUR){
                        	currentPlayer.nextPlayer();
                            players.get(currentPlayer.getCurrentPlayer()).draw(4);
                            currentPlayer.nextPlayer();
                        }else if(currentCard.type() == CardType.REVERSE){
                        	currentPlayer.switchDirections();
                            currentPlayer.nextPlayer();
                        }else{
                        	currentPlayer.nextPlayer();
                        }
                        count++;
                }while(!gameOver());
                return count;
        }
        
        private boolean gameOver(){
        	for(Player p : players){
        		if(p.hand().size() == 0){ 
        			return true;
        		}
        	}
        	return false;
        }
}