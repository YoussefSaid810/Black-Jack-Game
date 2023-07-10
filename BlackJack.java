package blackjack;

import java.util.Scanner;


public class BlackJack {
    
   static Game game = new Game();


public static void main(String[] args) {
   
    GUI gui=new GUI();
    game.gen();
    game.setInfo();  





    gui.runGUI(game.decks,
    game.play[0].getplaying(),
    game.play[1].getplaying(),
    game.play[2].getplaying(),
    game.play[3].getplaying());

    turnPlayers(gui);

game.updateScore();
    dealersTurn(gui);

    game.updateScore();
  check();
  
}
   public static void turnPlayers(GUI gui){
     Scanner scanner=new Scanner(System.in);  
    
   
    for(int i=0;i<game.play.length-1;i++){
      

        String in="";
        while(!in.toLowerCase().equals("stand")){

       System.out.print("Player Number " + (i+1) + " HIT OR STAND"); 
       in=scanner.next();
        if(in.toLowerCase().equals("hit")){

            addToPlayer(i,gui);

        }
    }
}
        
    
   
   }
public static void addToPlayer(int d ,GUI gui){


Card card=game.drawrand();
game.play[d].count(card);
gui.updatePlayerHand(card, d);
}
public static void dealersTurn(GUI gui) {

    boolean dwin=true;
    int high=0;
    for(int i=0;i<game.play.length-1;i++){
        if(game.hscore[i]>=game.play[3].score){
            dwin=false;

        }
        if(game.hscore[i]>high){
            high=game.hscore[i];
        }
        }
        if(!dwin){
         addToDealer(gui, high);

        }else{
            return ;
        }
    }

public static void addToDealer(GUI gui , int high) {
    while(game.play[3].score < high){

        Card card=game.drawrand();
        game.play[3].count(card);
        gui.updateDealerHand(card,game.decks);
    }
}

public static void check() {
    int highscore=0;
    int win=-1;
    for(int i=0; i<game.play.length;i++){
        if (game.hscore[i]>highscore){
            highscore=game.hscore[i];
            win=i;

        }
    }

    if(win>=0){
        System.out.println("THE WINNER IS :" );
        System.out.println(game.play[win].name);
        System.out.println("THE SCORE IS : " + highscore);
    }

    /**public static void who_win() {
        if (game.play[0].score > game.play[2].score && game.play[0].score > game.play[1].score && game.play[0].score > game.play[3].score )
            System.out.println("Player 1 wins");
        else if (game.play[1].score > game.play[0].score && game.play[1].score > game.play[2].score && game.play[1].score > game.play[3].score )
            System.out.println("Player 2 wins");
        else if (game.play[2].score > game.play[0].score && game.play[2].score > game.play[1].score && game.play[2].score > game.play[3].score )
            System.out.println("Player 3 wins");
        else if (game.play[3].score > game.play[0].score && game.play[3].score > game.play[1].score && game.play[3].score > game.play[2].score )
            System.out.println("dealer wins");
        else
            System.out.println("it's a push");
    */}
}


