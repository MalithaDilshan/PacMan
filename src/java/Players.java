
import org.json.simple.JSONArray;


public class Players {
   
    int playerMarks=0,x,y;
    String player; 
    
    public Players(String player, int x, int y){
           this.player = player;
           this.x      = x;
           this.y      = y;
          
    }     
   
    
    public JSONArray getCordinates(int score, int x, int y){
         JSONArray array  = new JSONArray();
         JSONArray array_dot = new JSONArray();
         this.playerMarks = score;
         array_dot.add(player);
         array_dot.add(playerMarks);
         array_dot.add(x);
         array_dot.add(y);
                       
         array.add(array_dot);
         
         return array;
    }
    
   /* public int getMarks(String colour){
        // implement the give marks logic
        if("R".equals(colour))
            playerMarks = playerMarks+3;  // if player eat red dot increase the marks by 3
        if("B".equals(colour))
            playerMarks = playerMarks+5;  // if player eat blue dot increase the marks by 5
        if("G".equals(colour))
            playerMarks = playerMarks+7;  // if player eat green dot increase the marks by 7
        
        
        return playerMarks;
    }*/
    
    public void keyStrock(int key, int width, int height){
        
        switch(key) {
            case 37:     
                x = (x - 1 + width)% width;
                break;       
            case 38:         
                y = (y - 1 + height) % height;         
                break;       
            case 39:         
                x = (x + 1) % width;  
                break;       
            case 40:         
                y = (y + 1) % height;         
                break; 
            default:
                break;
            }         
    }
    
    public int getmarks(){
        return playerMarks;
    }
    
}
