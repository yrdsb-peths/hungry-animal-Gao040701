import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    GreenfootImage[] images = new GreenfootImage[8];

    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant(){
        for (int i = 0; i < images.length; i++){
            images[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            images[i].scale(100,100);
        }
        setImage(images[0]);
        animationTimer.mark();
    }
    
    private int imageIndex = 0;
    public void animateElephant(){
        if (animationTimer.millisElapsed() < 300){
            return;
        }
        animationTimer.mark(); 
        
        imageIndex = (imageIndex + 1) % images.length;
        setImage(images[imageIndex]);
    }
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("d")){
            move(5);
        }else if(Greenfoot.isKeyDown("a")){
            move(-5);
        }
        
        eat();
        
        animateElephant();
    }
    
    public void eat(){
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.IncreaseScore();
            elephantSound.play();
        }
    }
}
