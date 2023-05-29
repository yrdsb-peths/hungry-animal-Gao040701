import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Elephant
 * 
 * @author Angela 
 * @version 05/26/2023 
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    GreenfootImage[] rightImages = new GreenfootImage[8];
    GreenfootImage[] leftImages = new GreenfootImage[8];

    SimpleTimer animationTimer = new SimpleTimer();
    boolean facingRight = true;
    public Elephant(){
        for (int i = 0; i < rightImages.length; i++){
            rightImages[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
            rightImages[i].scale(100,100);
            leftImages[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            leftImages[i].mirrorHorizontally();
            leftImages[i].scale(100,100);
        }
        setImage(rightImages[0]);
        animationTimer.mark();
    }
    
    private int imageIndex = 0;
    /**
     * animate the elephant using arrays
     */
    public void animateElephant(){
        if (animationTimer.millisElapsed() < 200){
            return;
        }
        animationTimer.mark(); 
        if (facingRight){
            imageIndex = (imageIndex + 1) % rightImages.length;
            setImage(rightImages[imageIndex]);
        }else{
            imageIndex = (imageIndex + 1) % leftImages.length;
            setImage(leftImages[imageIndex]);
        }
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("right")){
            facingRight = true;
            move(5);
        }else if(Greenfoot.isKeyDown("left")){
            facingRight = false;
            move(-5);
        }
        
        eat();
        
        animateElephant();
    }
    
    /**
     * when touches an apple, remove it and create a new apple, increase score and play a sound
     */
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
