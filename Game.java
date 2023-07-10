package blackjack;
import java.util.Random;
import java.util.Scanner;
public class Game {
    public int hscore[]=new int[4];
   public Card decks[]=new Card [52];
    public Player play[]=new Player[4];
    
    
    public void gen(){
        int s=0;
        for(int su=0;su<4;su++){
         for(int ra=0;ra<13;ra++){
         int value;
         if(ra>9){
          value=10;
         }
         else{
             value=ra+1;
         }
         Card cc=new Card(su,ra,value);    
         decks[s]=cc;
         s++;
         }   
        }
    }
    public Card drawrand(){
       Card thecard;
         Random rand=new Random();
         while(true){
            int num=rand.nextInt(51);   
            if(decks[num]!=null){
             thecard=new Card (decks[num]);
             decks[num]=null;
      /**do{
            int num=rand.nextInt(51);
            thecard=decks[num];
            decks[num]=null;
            
        }while(thecard==null);
*/ 
         
       return thecard;  
          
       
    }     
            }
}
     public void setInfo(){
        Scanner scan=new Scanner(System.in);
        for (int i=0;i<play.length-1;i++) {
            System.out.print("Enter Name of Player " + (i + 1) +" : " );
       
            play[i]=new Player();
            play[i].name=scan.next();
            play[i].count(this.drawrand());
            play[i].count(this.drawrand());
             }
        play[3]=new Player();
        play[3].name="Dealer";
        play[3].count(this.drawrand());
        play[3].count(this.drawrand());
               
    }
    
        
        public void updateScore(){
            for(int i=0;i<hscore.length;i++){
                if(hscore[i]<=21){
                   hscore[i]= play[i].score;

                }
                else{
                    hscore[i]=0;
                }
            }
        }
    }

