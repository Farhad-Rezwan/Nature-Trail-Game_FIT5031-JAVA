/**
 * This Dice class generates random numbers for a dice, as well as generates 
 * random number from 1 to maximum value.
 *
 * @author (Farhad Ullah Rezwan)
 * @version (18.04.2019)
 */
public class Dice
{   
    private int maximumValue;
    private int minimumValue;
    
    /**
     * The default constructor of dice class, creates a object of Dice class with
     * maximum value of 4 and minimum value of 1.
     */
    public Dice()
    {
        maximumValue = 4;
        minimumValue = 1;
    }
    
    /**
     * The non-default constructor of dice class, creates a object of Dice class with
     * when two integar values are provided.
     */
    public Dice(int newMaximumValue, int newMinimumValue)
    {
        maximumValue = newMaximumValue;
        minimumValue = newMinimumValue;
    }
    
    /**
     * returns maximum value of a Dice object
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }
    
    /**
     * this method returns minimum value of a Dice object
     */
    public int getMinimumValue()
    {
        return minimumValue;
    }
    
    /**
     * generates and returns random dice number.
     */
    public int randomDiceNumber()
    {
        int value = minimumValue + (int)(Math.random() * maximumValue);
        return value;
    }
    
    /**
     * stores a maximum value of a dice object
     */
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }
    
    /**
     * stores a minimum value of a dice object
     */
    public void setMinimumVlaue(int newMinimumValue)
    {
        minimumValue = newMinimumValue;
    }
    
}