package uno;

import java.util.Random;

public class Card {
        private CardColor color;
        private CardType type;
        private Card(CardColor color, CardType type){
                this.color = color;
                this.type = type;
        }
        
        public CardColor color(){
        	return color;
        }

        public static Card getNewCard(){
        	return new Card(randCardColor(), randCardType()); 
        }
        
        public CardType type(){
        	return type;
        }
        
        private static CardType randCardType(){
        	Random random = new Random();
        	switch(random.nextInt(15)){
        	case 0: return CardType.ZERO;
        	case 1: return CardType.ONE;
        	case 2: return CardType.TWO;
        	case 3: return CardType.THREE;
        	case 4: return CardType.FOUR;
        	case 5: return CardType.FIVE;
        	case 6: return CardType.SIX;
        	case 7: return CardType.SEVEN;
        	case 8: return CardType.EIGHT;
        	case 9: return CardType.NINE;
        	case 10: return CardType.DRAW_TWO;
        	case 11: return CardType.SKIP;
        	case 12: return CardType.REVERSE;
        	case 13: return CardType.WILD;
        	case 14: return CardType.WILD_DRAW_FOUR;
        	}
        	return null;
        }
        
        private static CardColor randCardColor(){
        	Random random = new Random();
        	switch(random.nextInt(4)){
        	case 0: return CardColor.BLUE;
        	case 1: return CardColor.RED;
        	case 2: return CardColor.GREEN;
        	case 3: return CardColor.YELLOW;
        	}
        	return null;	
        }
}