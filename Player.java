import java.util.Scanner;
/**
 * This Player class is assigned to generate players for Nature Feature Game.
 *
 * @author (Farhad Ullah Rezwan)
 * @version (18.04.2019)
 */
public class Player
{
    private String name;
    private int position;
    private int score;
    
    /**
     * Adds default values to the name, position and score attribute.
     */
    public Player()
    {
        name = "unknown";
        position = 0;
        score = 0;
    }
    
    /**
     * A non-default constructor, helps to assign a name, position and score of a player.
     */
    public Player(String newName, int newPosition, int newScore)
    {
        name = newName;
        position = newPosition;
        score = newScore;
    }
    
    /**
     * This method returns the state of a particular player.
     */
    public String displayStatus()
    {
        String state;
        state = "Player name: "+ getName() + "." + 
                " Current score: "+ getScore() + "." + 
                " Current Position: "+ getPosition() + ".";
        return state;
    }
    
    /**
     * This method returns the name of a particular player.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * This method returns the current position of a particular player
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * This method returns the current score of a particular player.
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * This method assign a name for a particular Player class object.
     */
    public void setName(String newName)
    {
        name = newName;
    }
    
    /**
     * This method assigns the position of a particular instance of Player class.
     */
    public void setPosition(int newPosition)
    {
        position = newPosition;
    }
    
    /**
     * This method assigns the score of a particular player.
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }
    
}