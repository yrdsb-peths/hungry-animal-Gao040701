import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apple 
 * 
 * @author Angela 
 * @version 05/26/2023
 */
public class BadApple extends Actor
{
    int speed = 1;
    
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY() + speed;
        setLocation(x,y);
        
        MyWorld world = (MyWorld) getWorld();
        if (isTouching(Elephant.class)){
            world.gameOver();
            world.removeObject(this);
            world.removeObjects(world.getObjects(Apple.class));
        }
    }
    
    /**
     * set the speed of the apple dropping
     */
    public void setSpeed(int spd){
        speed = spd;
    }
}
