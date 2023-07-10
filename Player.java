package blackjack;

public class Player {
    private int cardcount=0;
    public String name;
    private Card[] playing=new Card[11];
    public  int score=0;
    
    public void count(Card card){
       if(cardcount<11){     
    playing[cardcount]=card;
    cardcount++;
    score+=card.getValue();
    }
    
    }
    public Card [] getplaying(){
        return this.playing;
    }
}
