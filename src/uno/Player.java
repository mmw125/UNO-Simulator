package uno;

import java.util.ArrayList;

public class Player {
	private Hand playerHand;

	public Player(int InitCards) {
		ArrayList<Card> hand = new ArrayList<Card>();
		for (int x = 0; x < InitCards; x++) {
			hand.add(Card.getNewCard());
		}
		playerHand = new Hand(hand);
	}
	
	public void draw(int num){
		for(int i = 0; i < num; i++){
			playerHand.drawCard();	
		}
	}

	/**
	 * 
	 * @param card
	 *            The card currently at the top of the pile
	 * @return the card the player plays
	 */
	public Card playerTurn(Card card) {
		return playerHand.playCard(card);
	}

	public ArrayList<Card> hand() {
		return playerHand.getHand();
	}

	public static class Hand {
		private ArrayList<Card> cards;

		public Hand(ArrayList<Card> cardsInHand) {
			cards = cardsInHand;
		}

		public Card playCard(Card card) {
			ArrayList<Card> playable = getPlayableCards(card);
			while(playable.size() == 0){
				drawCard();
				playable = getPlayableCards(card);
			}
			
			// Attempt to play a normal colored card
			for(Card play : playable) {
				if(play.color() == card.color()) {
					cards.remove(play);
					return play;
				}
			}
	
			// Attempt to play a uncolored card
			for (Card play : playable) {
				if (play.type() == CardType.WILD || play.type() == CardType.WILD_DRAW_FOUR) {
					cards.remove(play);
					return play;
				}	
			}
	
			// Draw until you can play
			while (true) {
				Card randCard = Card.getNewCard();
				if (randCard.color() == card.color() || randCard.type() == CardType.WILD || randCard.type() == CardType.WILD_DRAW_FOUR) {
					return randCard;
				} else {
					cards.add(randCard);
				}
			}
		}
		
		public void drawCard(){
			cards.add(Card.getNewCard());
		}
		
		/**
		 * Gets the cards that can be played in the hand
		 * @param card the card at the top of the pile
		 * @return a list of cards in hand that can be played
		 */
		private ArrayList<Card> getPlayableCards(Card card){
			ArrayList<Card> output = new ArrayList<Card>();
			for(Card c : cards){
				if(c.color() == card.color() || c.type() == card.type() || c.type() == CardType.WILD || c.type() == CardType.WILD_DRAW_FOUR){
					output.add(c);
				}
			}
			return output;
		}

		/**
		 * Gets the color that you have the most of in your hand
		 * @return the color
		 */
		public CardColor topColor() {
			int blue = 0, red = 0, green = 0, yellow = 0;
			for (Card c : cards) {
				switch (c.color()) {
				case BLUE:
					blue++;
					break;
				case RED:
					red++;
					break;
				case GREEN:
					green++;
					break;
				case YELLOW:
					yellow++;
					break;
				default:
					break;
				}
			}
			int max = Math.max(Math.max(blue, red), Math.max(green, yellow));
			if (max == blue) {
				return CardColor.BLUE;
			} else if (max == red) {
				return CardColor.RED;
			} else if (max == green) {
				return CardColor.GREEN;
			} else {
				return CardColor.YELLOW;
			}

		}
		
		public ArrayList<Card> getHand(){
			return cards;
		}
	}
}