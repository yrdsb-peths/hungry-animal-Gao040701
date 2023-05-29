import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apple 
 * 
 * @author Angela 
 * @version 05/26/2023
 */
public class Apple extends Actor
{
    int speed = 1;
    
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY() + speed;
        setLocation(x,y);
        
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight()){
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    /**
     * set the speed of the apple dropping
     */
    public void setSpeed(int spd){
        speed = spd;
    }
}
