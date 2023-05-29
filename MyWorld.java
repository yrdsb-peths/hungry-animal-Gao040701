import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The world which the elephant eats the apple
 * 
 * @author Angela 
 * @version 05/26/2023
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    Label gameOverLabel;
    int level = 1;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        GreenfootImage bgImage = new GreenfootImage("images/backgroundColorDesert.png");
        bgImage.scale(400, 400);
        setBackground(bgImage);
        
        Elephant elephant = new Elephant ();
        addObject(elephant, 0, 300);
        
        scoreLabel = new Label("",50);
        addObject(scoreLabel, 50, 50);
        
        createApple();
        
    }
    
    /**
     * increase score by one and increase level for every 5 scores earned 
     */
    public void IncreaseScore(){
        score++;
        scoreLabel.setValue(score);
        if (score % 5 == 0){
            level += 1;
        }
    }
    
    /**
     * create a new apple 
     */
    public void createApple(){
        Apple apple = new Apple();
        BadApple badapple = new BadApple();
        apple.setSpeed(level);
        badapple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int x1 = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
        addObject(badapple, x1, y);
    }
    
    
    /**
     * present game over label 
     */
    public void gameOver(){
        Label gameOverLabel = new Label("Game Over",100);
        addObject(gameOverLabel, 300, 200);
    }
}
