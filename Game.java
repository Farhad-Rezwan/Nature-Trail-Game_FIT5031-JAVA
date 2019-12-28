import java.util.Scanner;
import java.util.*;
/**
 * This class includes the main method for Nature Feature Game.
 * by calling this method a player can start playing this game.
 * 
 * * @author (your name)
 * @version (18.04.2019)
 */
public class Game
{
    private int trailLength;
    private Trail natureTrail;
    private Player playerOne;
    private Player playerTwo;

    public Game()
    {
        trailLength = 20;
        natureTrail = new Trail();
        playerOne = new Player();
        playerTwo = new Player(); 
    }
    
    /**
     * A method that select an addable score for animal sightings or no animal sightings
     * for a players position.
     */
    public int addableScore(int index )
    {
        int add;
        
        switch (index)
        {
            case 1:add = 10; break;
            case 2:add = 7; break;
            case 3:add = 5; break;
            case 4:add = 2; break;
            case 5:add = -5; break;
            case 6:add = 0; break;
            case 7:add = 0; break;
            case 8:add = 0; break;
            case 9:add = 0; break;
            case 10:add = 0; break;
            default:add = 0; break;
        }
        return add;
    }
    
    /**
     * A method that stores a particular animal or no animal as string form for a player's position.
     */
    public String animals(int index)
    {
        String[] animalName;

        animalName = new String[11];

        animalName[1] = "Koala";
        animalName[2] = "Emu";
        animalName[3] = "Wombat";
        animalName[4] = "Kangaroo";
        animalName[5] = "Redback Spider";
        animalName[6] = "";
        animalName[7] = "";
        animalName[8] = "";
        animalName[9] = "";
        animalName[10] = "";

        return animalName[index];
    }
    
    /**
     * helps to assign unique random feature position
     */
    public void assignRandomFeaturePosition()
    {
        int[] random;
        random = new int[4];
        int index;
        //When Trail Length = 20, this non-default constructor of dice class will generate  4 random unique 
        //numbers between 1 to 18. As position 1 and position 20 can not have Nature Feature for this stage, 
        //by adding 1 at the letter stage will give random unique numbers between 2 to 19
        Dice randomPosition = new Dice(trailLength-2 , 1);
        do
        {
            for (index = 0; index < 4; index++)
            {
                random[index] = randomPosition.randomDiceNumber() + 1;
            }

        } while (random[0] == random[1] || 
                    random[0] == random[2] || 
                    random[0] == random[3] || 
                    random[1] == random[2] || 
                    random[1] == random[3] || 
                    random[2] == random[3]);
        natureTrail.getFeatures(0).setFeaturePosition(random[0]); 
        natureTrail.getFeatures(1).setFeaturePosition(random[1]);
        natureTrail.getFeatures(2).setFeaturePosition(random[2]);
        natureTrail.getFeatures(3).setFeaturePosition(random[3]);
    }
    
    /**
     * requests human player to enter their name, assigns player one name between 1 and 6 
     * characters inclusive, and trims begainig and ending spaces of player name.
     */
    public void createPlayerOne()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Player's Name: ");
        System.out.println("(within 1 and 6 characters)");
        String inputName = input.nextLine();
        if (inputName.length() >= 1 && inputName.length() <=6)
        {
            System.out.println ("Your name has been set to: "+ inputName.trim());
            playerOne.setName(inputName.trim());
        }
        else
            if (inputName.length() == 0)
            {
                System.out.println("Invalid Name: Player's name can not be a blank");
                createPlayerOne();
            }
            else
            {
                System.out.println("You have entered an invalid name");
                createPlayerOne();
            }
        playerOne.setScore(0);
        playerOne.setPosition(1);
    }
    
    /**
     * automatically creates a computer player.
     */
    public void createPlayerTwo()
    {
        playerTwo.setName("Computer");
        playerTwo.setScore(0);
        playerTwo.setPosition(1);
    }
    
    /**
     * displays wellcome message for the user.
     */
    public void displayWelcomeMessage()
    {
        int lineWaveNumber = (trailLength*4);
        int countWave;
        
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 7; countWave++)
        {
            System.out.print("~");
        }
        System.out.print(" WELCOME TO THE ");
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 8; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 7; countWave++)
        {
            System.out.print("~");
        }
        System.out.print(" NATURE FEATURE ");
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 8; countWave++)
        {
            System.out.print("~");
        } 
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 7; countWave++)
        {
            System.out.print("~");
        }
        System.out.print("    GAME!!!!!   ");
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 8; countWave++)
        {
            System.out.print("~");
        } 
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        System.out.println();
    }
    
    /**
     * draws line for computer player to separate each turns of human player and computer.
     */
    private void drawLineComputer()
    {
        int lineWaveNumber = (trailLength*4);
        int countWave;
        
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 7; countWave++)
        {
            System.out.print("~");
        }
        System.out.print(" Computer's Turn");
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 8; countWave++)
        {
            System.out.print("~");
        }    
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        System.out.println();
    }

    /**
     * draws line for human player to separate each turns of human player and computer.
     */
    private void drawLineHuman()
    {
        int lineWaveNumber = (trailLength*4);
        int countWave;

        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 5; countWave++)
        {
            System.out.print("~");
        }
        System.out.print(" Your Turn ");
        for ( countWave = 1; countWave < lineWaveNumber / 2 - 5; countWave++)
        {
            System.out.print("~");
        }    
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        } 
        System.out.println();
        System.out.println();
    }
    
    /**
     * draws a line to separate a particular section from another.
     */
    private void drawOneLine()
    {
        int lineWaveNumber = (trailLength*4);
        int countWave;
        
        System.out.println();
        System.out.println();
        for ( countWave = 1; countWave < lineWaveNumber; countWave++)
        {
            System.out.print("~");
        }
        System.out.println();
        System.out.println();
    }

    /**
     * creates, displays and updates the position graphically and displays the score and
     * position of each indivitdual player in textual format for users understandability.
     */
    private void drawUpdateTrail()
    {
        int lineStarsNumber = (trailLength*4);
        int countStars;
        int i;

        for ( countStars = 1; countStars<lineStarsNumber/2-5; countStars++)
        {
            System.out.print("*");
        }
        System.out.print("Score Card*");
        for ( countStars = 1; countStars<lineStarsNumber/2-5; countStars++)
        {
            System.out.print("*");
        }

        System.out.println("");
        System.out.print("* H: "+ playerOne.getName());
        System.out.print(" (Score: " +playerOne.getScore()+")");
        if (playerOne.getPosition() < trailLength)
            System.out.println(" (Position: " +playerOne.getPosition()+")");
        else
            System.out.println(" (Finished!!!)");
        System.out.println("*");
        System.out.print("* C: "+ playerTwo.getName());
        System.out.print("(Score: " + playerTwo.getScore()+")");
        if (playerTwo.getPosition() < trailLength)
            System.out.println(" (Position: " + playerTwo.getPosition() +")");
        else
            System.out.println(" (Finished!!!)");
        
        for ( countStars = 1; countStars < lineStarsNumber/2-5; countStars++)
        {
            System.out.print("*");
        }
        System.out.print("Play Ground");
        for ( countStars = 1; countStars < lineStarsNumber / 2 - 5; countStars++)
        {
            System.out.print("*");
        }
        System.out.println("");
        for ( i=1; i<trailLength+1; i++)
        {
            if (i ==1)
                System.out.print(" S  ");
            else
                if (i==trailLength)
                    System.out.print("  F ");
                else 
                if (i == playerOne.getPosition() &&
                    i == playerTwo.getPosition())
                        System.out.print(" HC ");
                    else
                        if (i == playerOne.getPosition()) 
                            System.out.print("  H ");
                        else
                            if (i == playerTwo.getPosition())
                                System.out.print("  C ");   
                            else 
                                System.out.print("  - ");
        }
        System.out.println();
        for ( countStars = 1; countStars<lineStarsNumber; countStars++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    
    /**
     * displays the final result of the game.
     */
    public void gameResult ()
    {
        drawOneLine();
        System.out.println("GAME REASULT:");
        System.out.println();
        if (playerOne.getScore() > playerTwo.getScore())
        {
            System.out.println("Congratulations " + playerOne.getName()
                                + "!!! you have just won the game");
            System.out.println("Your Final Score is: " + playerOne.getScore()
                                + ". Computer's Final Score is: " 
                                + playerTwo.getScore() + "." );
        }
        else
        if(playerOne.getScore() == playerTwo.getScore())
        {
            System.out.println("The game have just drawn!!!");
            System.out.println("Your Final Score is: " +
                                playerOne.getScore()+ ". Computer's Final Score is: " 
                                + playerTwo.getScore() +"." );            
        }
        else
        {
            System.out.println("you have just lost this game!!! better luck next time!!!");
            System.out.println("Your Final Score is: " + playerOne.getScore() 
                                + ". Computer's Final Score is: "+ playerTwo.getScore()+"." );            
        }
        drawOneLine();
    }
    
    /**
     * returns player one's status.
     */
    public String getPlayerOne()
    {
        return playerOne.displayStatus();
    }
    
    /**
     * returns player two's status.
     */
    public String getPlayerTwo()
    {
        return playerTwo.displayStatus();
    }
    
    /**
     * returns the trail length integer.
     */
    public int getTrailLength()
    {
        return trailLength;
    }
    
    /**
     * This method manages the overall gameplay. First of all, according to the toss winning player 
     * number this method helps to run his turn first and then run the turn of another player and 
     * so on untill any of the player reaches or cross to the finish position first. Secondly, This method
     * checks for an animal for a player's position and assigns respective scores. Finally, this method 
     * checks for a nature trail for a player's position and assigns respective changes to his position.
     */
    public void manageGamePlay(int newTossWinner)
    {
        int humanDiceNumber;
        int computerDiceNumber;
        int counter;

        Scanner input = new Scanner (System.in);
        Dice roll = new Dice();

        if (newTossWinner == 1)
            counter = 1;
        else
            counter = 2;
        do
        {
            if (counter == 1)
            {
                if (playerOne.getPosition() < trailLength)
                {
                    int animalIndex1;

                    animalIndex1 = randomIndexGenerator();

                    drawLineHuman();
                       
                    System.out.println("Press Enter to roll the Dice");
                    input.nextLine();

                    humanDiceNumber = roll.randomDiceNumber();

                    System.out.println ("Your dice value is " + humanDiceNumber+ "");
                    System.out.println ();
                    playerOne.setPosition(playerOne.getPosition() + humanDiceNumber);
                    System.out.println("You have been moved forward by "+ humanDiceNumber + " step(s)");
                    if (playerOne.getPosition() >= trailLength)
                    {
                        playerOne.setScore(playerOne.getScore() + 10);
                        System.out.println("As you finished first, you recieved 10 extra points");
                        System.out.println();
                    }
                    System.out.println();
                    drawUpdateTrail();
                    System.out.println();
                    if (playerOne.getPosition()<trailLength)
                    {
                        System.out.println("Press enter to check for animals");
                    }
                    else
                    {
                        System.out.println("Press enter to view result");
                    }
                    input.nextLine();
                    if (playerOne.getPosition() < trailLength)
                        if (animalIndex1 <= 5)
                        {
                            System.out.println("You have witnessed an animal : " + animals(animalIndex1) );
                            System.out.println();
                            System.out.println("Your Score has been updated by "
                                                + addableScore(animalIndex1)+" points");
                            playerOne.setScore(addableScore(animalIndex1) + playerOne.getScore());
                            System.out.println();
                            drawUpdateTrail ();
                        }
                        else
                        {
                            System.out.println("You have not seen any animal");
                            System.out.println ();
                            System.out.println("Your score remains same for this time");
                            System.out.println ();
                            drawUpdateTrail ();
                        }
                    if (playerOne.getPosition() == natureTrail.getFeatures(0).getFeaturePosition())
                    {
                        spaceActionHuman(0);
                    }
                    else
                    if (playerOne.getPosition() == natureTrail.getFeatures(1).getFeaturePosition())
                    {
                        spaceActionHuman(1);
                    }    
                    else
                    if (playerOne.getPosition() == natureTrail.getFeatures(2).getFeaturePosition())
                    {
                        spaceActionHuman(2);
                    } 
                    else
                    if (playerOne.getPosition() == natureTrail.getFeatures(3).getFeaturePosition())
                    {
                        spaceActionHuman(3);
                    }
                    else
                        System.out.println();
                    counter++; 
                    input.nextLine();
                } 
            }

            else 
            {
                if (playerTwo.getPosition() < trailLength)
                {
                    int animalIndex2;

                    animalIndex2 = randomIndexGenerator();

                    drawLineComputer();
                    computerDiceNumber = roll.randomDiceNumber();
                    System.out.println ("Computer completed rolling the dice");
                    input.nextLine();
                    System.out.println ("Computer's Dice Value : "+ computerDiceNumber+ " ");
                    System.out.println ();
                    playerTwo.setPosition(playerTwo.getPosition() + computerDiceNumber);
                    System.out.println("Computer's position moved forward by : " + computerDiceNumber + " step(s)");
                    if (playerTwo.getPosition() >= trailLength)
                    {
                        playerTwo.setScore(playerTwo.getScore() + 10);
                        System.out.println("As computer finished first, it got 10 extra points");
                        System.out.println();
                    }
                    drawUpdateTrail ();
                    input.nextLine();
                    if (playerTwo.getPosition()<trailLength)
                        if (animalIndex2 <= 5)
                        {
                            System.out.println("Computer have witnessed an animal : " + animals(animalIndex2) );
                            System.out.println();
                            System.out.println("Computer's Score has been  updated by "
                                                + addableScore(animalIndex2)+" points");
                            playerTwo.setScore(addableScore(animalIndex2) + playerTwo.getScore());
                            System.out.println ();
                            drawUpdateTrail ();
                        }
                        else
                        {
                            System.out.println("Computer have not seen any animal");
                            System.out.println ();
                            System.out.println("Computer's score remains same for this time");
                            System.out.println ();
                            drawUpdateTrail ();
                        }
                    if (playerTwo.getPosition() == natureTrail.getFeatures(0).getFeaturePosition())
                    {
                        spaceActionComputer(0);
                    }
                    else
                    if (playerTwo.getPosition() == natureTrail.getFeatures(1).getFeaturePosition())
                    {
                        spaceActionComputer(1);
                    }    
                    else
                    if (playerTwo.getPosition() == natureTrail.getFeatures(2).getFeaturePosition())
                    {
                        spaceActionComputer(2);
                    } 
                    else
                    if (playerTwo.getPosition() == natureTrail.getFeatures(3).getFeaturePosition())
                    {
                        spaceActionComputer(3);
                    }
                    else
                        System.out.println();
                    counter--;
                    input.nextLine();
                } 
            }
        } while(playerOne.getPosition()< trailLength && playerTwo.getPosition()< trailLength);
    }   

    /**
     * ceates a random number from 1 to 10 for a partuclar position of the trail, to figure out whether a
     * player sees an animal or not.
     */
    public int randomIndexGenerator()
    {
        Dice scoreRoll = new Dice(10,1);

        int diceScroll = scoreRoll.randomDiceNumber();

        return diceScroll;
    }
    
    /**
     * helps to assign a trail length from 10 to 20 inclusive.
     */
    public void requestTrailLength()
    {
        Scanner input = new Scanner (System.in);
        System.out.println("Enter Trail Length between 10 to 20: ");
        int inputTrailLength = input.nextInt();

        if (inputTrailLength>=10 && inputTrailLength<=20)
        {
            System.out.println("System has set the trail length to: "+inputTrailLength);
            trailLength = inputTrailLength;
            System.out.println();
        }
        else
        {
            System.out.println(inputTrailLength + " is invalid Trail Length ");
            requestTrailLength();
            System.out.println();
        }
    }
    
    /**
     * changes the position of computer player depending feature position.
     */
    public void spaceActionComputer(int index)
    {
        Scanner input = new Scanner(System.in);
        
        input.nextLine();
        System.out.println("Computer's Turn is not over yet!!!");
        System.out.println();
        System.out.println("Computer just seen a " 
                            + natureTrail.getFeatures(index).getFeatureType());
        System.out.println();
        System.out.println("Computer's position again been changed by : "
                            + natureTrail.getFeatures(index).getSpacePenalty());
        System.out.println();
        playerTwo.setPosition(playerTwo.getPosition() 
                                + natureTrail.getFeatures(index).getSpacePenalty());
        if (playerTwo.getPosition() <= 0)
            playerTwo.setPosition(1);
        if (playerTwo.getPosition() >= trailLength)
        {
            playerTwo.setScore(playerTwo.getScore() + 10);
            System.out.println("As computer finished first, it got 10 extra points");
        }
        drawUpdateTrail();
    }
    
    /**
     * changes the position of human player depending feature position.
     */
    public void spaceActionHuman(int index)
    {
        Scanner input = new Scanner(System.in);
        
        input.nextLine();
        System.out.println("Your Turn is not over yet!!!");
        System.out.println();
        System.out.println("You have seen a " 
                            + natureTrail.getFeatures(index).getFeatureType());
        System.out.println();
        System.out.println("Your Position has been changed by : "
                            + natureTrail.getFeatures(index).getSpacePenalty());
        System.out.println();
        playerOne.setPosition(playerOne.getPosition() 
                                + natureTrail.getFeatures(index).getSpacePenalty());
        if (playerOne.getPosition() <= 0)
            playerOne.setPosition(1);
        if (playerOne.getPosition() >= trailLength)
        {
            playerOne.setScore(playerOne.getScore() + 10);
            System.out.println("As you finished first, you recieved 10 extra points");
        }
        drawUpdateTrail();
    }
    
    /**
     * A method that decides whether player one or player two win the toss
     * returns 1 if player one wins the toss and returns 2 if player two wins the toss.
     */
    private int startingToss()
    {
        Scanner input = new Scanner (System.in);
        Dice roll = new Dice();
        
        int humanTossNumber;
        int computerTossNumber;
        int tossWinner;
        
        System.out.println("Press Enter to roll the Dice");
        input.nextLine();
        humanTossNumber = roll.randomDiceNumber();
        drawLineHuman();
        System.out.println();
        System.out.println("Your Dice Value : " + humanTossNumber);
        drawOneLine();
        computerTossNumber = roll.randomDiceNumber();
        System.out.println("Press enter to see computer's turn");
        System.out.println();
        input.nextLine();
        drawLineComputer();
        System.out.println();
        System.out.println("Computer's Dice Value : "+ computerTossNumber);
        drawOneLine();
        if (humanTossNumber != computerTossNumber)
        {
            if (humanTossNumber > computerTossNumber)

            {
                System.out.println("You won the Toss, your turn first");
                tossWinner = 1;     //when player one wins the toss
                System.out.println();
                System.out.println("Press enter to Start the Game");
                input.nextLine();
            }
            else
            {
                System.out.println("Computer won the Toss, computer's turn first");
                tossWinner = 2;     // when player two wins the toss
                System.out.println();
                System.out.println ("Press enter to Start the Game");
                input.nextLine();
            }
        }
        else
        {
            System.out.println("Draw!!! lets play a tie breaker now");
            System.out.println();
            System.out.println ("Press enter for toss rematch");
            input.nextLine();
            humanTossNumber = 0;
            computerTossNumber = 0;
            tossWinner = 0;     // no toss winner
            startingToss();
        }
        System.out.println();
        return tossWinner;
    }

    /**
     * this method is used to start the Nature Feature Game. It controls the step by step actions.
     */
    public void startGame()
    {
        displayWelcomeMessage();
        requestTrailLength();
        natureTrail.inputFeatures();
        assignRandomFeaturePosition();
        createPlayerOne();
        createPlayerTwo();
        manageGamePlay(startingToss());
        gameResult();
    }

}    