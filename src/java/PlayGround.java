
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.json.simple.JSONArray;

public class PlayGround {
    // get number of dots 100
    public final static int numberOfDots = 100; 
    public int numberOfPlayers;
    private int width,height;
    
    public HashMap<Integer, Players> all_players;
        
    ArrayList<Dots> all_dots= null;
    Random random = new Random();
    
    public boolean isCollide=false;
    public boolean isAte=false;    // for testing the code only
    
    
    // to add a new player
    public void addNewPlayer(int id, Players player){
        
        all_players.put(id, player);
        /*int marks =0;
        for(int n=0;n<dotList.size();n++){
            int [] data = (int[]) dotList.get(n);
            if((data[1]==x) && (data[2]==y)){
                dotList.remove(data);
                if(data[0]==0)
                    marks=marks+2;
                if(data[0]==1)
                    marks=marks+3;
                if(data[0]==2)
                    marks=marks+5;
            }
         */
        numberOfPlayers++;
        
        
    }
  
    public PlayGround(int width, int height){
           
           String [] dot = {"B", "G", "R"};
           
           // array list for record the each of dot characteristics
           all_dots = new ArrayList<>();
           numberOfPlayers = 0;
           
           this.width = width;
           this.height = height;
           
           all_players = new HashMap<>();
           
           // give random coordinates and the random color to each dots
           for(int j=0;j < numberOfDots;j++){
              
                int xCoordinate =  random.nextInt(1000)%45;
                int yCoordinate =  random.nextInt(1000)%45;
                Dots d1 = new Dots(dot[j % 3], xCoordinate, yCoordinate);
                all_dots.add(d1); // add to the arraylist
           }
    }
    
 
    public void playerMosion( int key_value,Players current_player){
        
        // chech whether the number of players equals 4. if the number of players equals 4 let them play otherwise they can not
        //play until 4 player log to the game
        if(numberOfPlayers != 4) 
            return;
        
        current_player.keyStrock(key_value, width, height); // handle key strockes
        
        for(int n = 0; n<numberOfPlayers; n++){
        // if there is player already log in to the system, let him to do the game  
            if(all_players.get(n)==current_player)
                continue;
            // handle collitions
            //get each player in the list and compare with current player coordinates
            if(all_players.get(n).x == current_player.x && all_players.get(n).y == current_player.y){
                
                // if get collide reduse marks of collided both players
                all_players.get(n).playerMarks = all_players.get(n).playerMarks- 2; 
                current_player.playerMarks = current_player.playerMarks- 2; // current player
                
                // if collide give them random coordinates to continue the game again with redused marks
                current_player.x = random.nextInt(1000)%45; // current player
                current_player.y = random.nextInt(1000)%45;
                
                all_players.get(n).x = random.nextInt(1000)%45; // oother player that collided
                all_players.get(n).y = random.nextInt(1000)%45;
                
                isCollide=true;
            }
        }
        eatDots(current_player);
            
    }
    
   
    public void eatDots(Players current){  
        // eat dots and update the score boad
        for(int n =0; n < all_dots.size(); n++){
            
            Dots mydot = all_dots.get(n);
            
            if(current.x == mydot.x && current.y == mydot.y){
                all_dots.remove(mydot);
  
                if(mydot.color.equals("R"))
                    current.playerMarks += 5;
                if(mydot.color.equals("B"))
                    current.playerMarks += 3;
                if(mydot.color.equals("G"))
                    current.playerMarks += 1;
                
                }
            }        
    }
     
   
    public JSONArray getDotCordinates(){
         JSONArray update_dot= new JSONArray();
         
         for(int k=0;k < all_dots.size();k++ ){
             // adding all formated data to the JSONArray
                JSONArray dotdata  = new JSONArray();
                
                dotdata.add(all_dots.get(k).color);
                dotdata.add(all_dots.get(k).x);
                dotdata.add(all_dots.get(k).y);
                update_dot.add(k, dotdata);
         }
         
         return update_dot;  // gte the JSONArray
    }
   
}
