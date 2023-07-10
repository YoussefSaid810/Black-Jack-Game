package blackjack;

public class Card {
    private final int suit;
    private final int rank;

    private final int value;
    public Card (int s,int r,int v){
     suit=s;
     rank=r;
     value=v;
    
}
    public Card(Card card){
     suit=card.suit;
     rank=card.rank;
     value=card.value;
    
        
    }
    public Card(){
        this.suit=0;
        this.rank=0;
        this.value=0;
    }
      public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
}
    

