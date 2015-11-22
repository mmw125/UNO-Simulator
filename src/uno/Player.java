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
//		Card returnCard = null;
//		boolean finished = false;
//		// Attempt to play a normal colored card
//		for (int x = 0; x < hand.size(); x++) {
//			if ((hand.get(x).color() == card.color() || hand.get(x).type() == card
//					.type())
//					&& hand.get(x).type() != CardType.WILD
//					&& hand.get(x).type() != CardType.WILD_DRAW_FOUR) {
//				returnCard = hand.get(x);
//				hand.remove(x);
//				break;
//			}
//		}
//
//		// Attempt to play a uncolored card
//		if (finished == false) {
//			for (int x = 0; x < hand.size(); x++) {
//				if (finished == false
//						&& (hand.get(x).type() == 13 || hand.get(x).CardNumber == 14)) {
//					ReturnCard = hand.get(x);
//					hand.remove(x);
//					finished = true;
//					ReturnCard.CardColor = bestColor();
//					// System.out.println("Played "+x+". And chose "+ReturnCard.CardColor);
//				}
//			}
//		}
//
//		// Draw until you can play
//		while (finished == false) {
//			Card randCard = Card.getNewCard();
//			// System.out.println("Drew a card. Got a "+test.printCard(randCard)+".");
//			if (randCard.color() == card.color()
//					|| randCard.color() == card.color()) {
//				returnCard = randCard;
//				finished++;
//			} else if (randCard.CardNumber == 13 || randCard.CardNumber == 14) {
//				ReturnCard = randCard;
//				// System.out.println("Played it.");
//				ReturnCard.CardColor = bestColor();
//				finished++;
//			} else {
//				hand.add(randCard);
//				// System.out.print("Added it to hand");
//				// try {
//				// System.in.read();
//				// } catch (IOException e) {
//				//
//				// e.printStackTrace();
//				// }
//			}
//		}
//		return returnCard;
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
			
			//Play best color cards
			
			
			
			return null;
		}
		
		public void drawCard(){
			cards.add(Card.getNewCard());
		}

//		private Card matchingColor(CardColor color) {
//			Card cardToPlay = null;
//			for (Card c : cards) {
//				if (c.color() == color) {
//
//				}
//			}
//			return cardToPlay;
//		}
		
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