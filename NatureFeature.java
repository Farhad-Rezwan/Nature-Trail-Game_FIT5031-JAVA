/**
 * This Dice class generates random dice numbers as well as any range of numbers.
 *
 * @author (Farhad Ullah Rezwan)
 * @version (18.04.2019)
 */
public class NatureFeature
{
    private int featurePosition;
    private String featureType;
    private int spacePenalty;
    
    /**
     * creates an object of nature feature class with default values.
     */
    public NatureFeature()
    {
        featurePosition = 0;
        featureType = "";
        spacePenalty = 0;
    }
    
    /**
     * creates a object of nature feature class when feature position, type and space penalty
     * are provided.
     */
    public NatureFeature(int newFeaturePosition, String newFeatureType, int newSpacePenalty)
    {
        featurePosition = newFeaturePosition;
        featureType = newFeatureType;
        spacePenalty = newSpacePenalty;
    }
    
    /**
     * returns the feature position of an object of nature feature
     */
    public int getFeaturePosition()
    {
        return featurePosition;
    }
    
    /**
     * returns the type of an object of nature feature
     */
    public String getFeatureType()
    {
        return featureType;
    }
    
    /**
     * returns the space penalty of an object of nature feature
     */
    public int getSpacePenalty()
    {
        return spacePenalty;
    }
    
    /**
     * create a new featuer position
     */
    public void setFeaturePosition(int newFeaturePosition)
    {
        featurePosition = newFeaturePosition;
    }
    
    /**
     * creates a new feature type
     */
    public void setFeatureType(String newFeatureType)
    {
        featureType = newFeatureType;
    }
    
    /**
     * create a new space penalty
     */
    public void setSpacePenalty (int newSpacePenalty)
    {
        spacePenalty = newSpacePenalty;
    }
    
}