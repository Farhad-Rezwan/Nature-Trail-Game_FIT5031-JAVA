/**
 * Trail class stores array of all the nature features on the trail.
 *
 * @author (Farhad Ullah Rezwan)
 * @version (18.04.2019)
 */
public class Trail
{
    private NatureFeature[] features;
    
    public Trail()
    {
        features = new NatureFeature[4];
    }

    public Trail(NatureFeature newFeatures)
    {
        features = new NatureFeature[4];
    }
    
    /**
     * sets the features ie. creek, bridge, fallen tree, and landslide and corresponding space penalties;
     * sets positions of these features innitially, however these positions will be changed and 
     * randomly assigned in the Game class.
     */
    public void inputFeatures()
    {
        setFeatures(0,1,"Creek",-2);
        setFeatures(1,2,"Bridge",4);
        setFeatures(2,3,"Fallen Tree",-3);
        setFeatures(3,4,"Landslide",-5);
    }
    
    /**
     * returns whole collection of features.
     */
    public NatureFeature[] getFeatures()
    {
        return features;
    }
    
    /**
     * returns a particular feature taking the index of an array.
     */
    public NatureFeature getFeatures(int index)
    {
        return features[index];
    }
    
    /**
     * saves an object of nature features in array.
     */
    public void setFeatures(NatureFeature[] newFeatures)
    {
        features = newFeatures;
    }
    
    /**
     * sets a particular feature at a time
     */
    public void setFeatures(int index, int featurePosition, String featureType,int spacePenalty)
    {
        features[index] = new NatureFeature(featurePosition, featureType, spacePenalty);
    }
    
}