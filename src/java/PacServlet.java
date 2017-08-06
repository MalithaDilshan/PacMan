/*
 *
    Author :Malitha Dilshan 
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.runtime.Context;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet(
        name = "keypress",urlPatterns = {"/UpdateGame"}
)

public final class PacServlet extends HttpServlet {
    
    //private Dots dot =new Dots();
    //Players player
    HashMap<String, Players> current;
    PlayGround myplay_ground = null;
    boolean isIntialize=false;
    
    //public int value;
   
      
    @Override 
    public void init()throws ServletException{
        //player = new Players()
        
        current = new HashMap<>();
        this.myplay_ground = new PlayGround(44, 44);
        isIntialize=true; // check whether when running the project,call the ini() method
    } 
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get the value of keypress that sent from the client side
        int value = Integer.parseInt(request.getParameter("keypress"));      
        
        HttpSession session = request.getSession();
        Players current_player = (Players) session.getAttribute("currentPlayer");
    
        if(current_player == null) 
            return;    // not connected yet
        
        myplay_ground.playerMosion(value,current_player);                                 
        
        synchronized(this){
           notifyAll();     // notify to all wait threads 
        }        
    }    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        
        HttpSession session = request.getSession();
        String sessionId = session.getId();
        int numberOfPlayers=0;
        
        // handling the session when connect new user and give the update according to the logic
        if(session.isNew()){
            
            if(numberOfPlayers < 4){
                System.out.println("new player");
             
                Players player=null;
                int dots=myplay_ground.numberOfPlayers;
                    if(dots==0)
                        player = new Players("P1", 0, 0);
                    if(dots==1)
                        player = new Players("P2", 0, 44);
                    if(dots==2)
                        player = new Players("P3", 44, 0);
                    if(dots==3)
                        player = new Players("P4", 44, 44);
                
                current.put(sessionId, player);
                myplay_ground.addNewPlayer(myplay_ground.numberOfPlayers, player);
                session.setAttribute("currentPlayer", player);
            }
            else
                return;
            
        }
        else{
           if(current.get(sessionId) == null) 
               return;
        }
        
            JSONObject object  = new JSONObject();  
            try (PrintWriter out = response.getWriter()){
                
                while(!Thread.interrupted()){
                    
                    object.put("DOTS", myplay_ground.getDotCordinates());
                    
                    JSONArray players = new JSONArray();
                    // get the playes data to JSONArray
                    for(int number: myplay_ground.all_players.keySet()){
                        
                        Players playerx = myplay_ground.all_players.get(number);
                        JSONArray array1 = playerx.getCordinates(playerx.playerMarks,playerx.x, playerx.y);

                        players.add(array1.get(0));
                    }
                    
                    // printing all data
                    
                    object.put("PLAYERS", players); 

                    out.print("data:");
                    out.println(object);
                    out.println();
                    out.flush();

                    synchronized(this){
                        wait();
                    }               
                }                
            }
            catch(Exception e){
                Context.printStackTrace(e);
                System.out.println("There may be an error when initiating players");
            }    
    }
    
    @Override
    public void destroy() {
        //player.interrupt();
        
        Logger.getGlobal().log(Level.INFO, "Stopped the game playing");
        
    } 
    
    
}
