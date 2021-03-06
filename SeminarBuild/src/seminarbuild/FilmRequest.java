/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seminarbuild;

/**
 *
 * @author Dakota
 */
public class FilmRequest {

    private Film film;
    private String name;
    public int timeRemaining;
    private boolean accepted;
    private boolean filmComplete;
    
    FilmRequest(Film film, String name){
        this.film = film;
        this.name = name;
        this.timeRemaining = this.film.getDuration();
        this.accepted = false;
        this.filmComplete = false;
    }
    
    //returns the requesting user's name
    public String getName() {
        return this.name;
    }
    
    //returns the film
    public Film getFilm() {
        return this.film;
    }
    
    //returns the remaining time
    public int getTime(){
        return this.timeRemaining;
    }
    
    //returns whether or not the request has been accepted
    public boolean isAccepted(){
        return this.accepted;
    }
    
    //returns whether or not the film has completed
    public boolean isComplete(){
        return this.filmComplete;
    }
    
    //accepts the crrent request
    public boolean accept(){
        boolean accept = false;
        try{
            this.accepted = true;
            accept = true;
        }catch(Exception e){
            System.out.println("couldn't accept film");
        }
        return accept;
    }
    
    //decrements the time remaining
    private void decTime(){
        if(this.timeRemaining>0){
            this.timeRemaining--;
        }
    }
    
    //returns a string of the request's film name, user's name, the bandwidth
    //consumption, and the duration or the time remaining if it's been accepted
    @Override
    public String toString(){
        String output = "";
        output += ("Film: " + this.film.getTitle() + "\n");
        output += ("Requested by: " + this.getName() + "\n");
        output += ("Bandwidth Consumption: " + this.film.getBandConsum() + "\n");
        if(this.isAccepted()){
            output += ("Time remaining: " + this.timeRemaining);
        }
        else{
            output += ("Duration: " + this.film.getDuration());
        }
        return output;
    }
    
    //decrements the requests time if it's been accepted
    public void update(){
        if(this.accepted && this.timeRemaining!=0){
            this.decTime();
        }
    }
}
