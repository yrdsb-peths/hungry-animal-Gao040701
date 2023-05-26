import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    Label titleLabel = new Label ("Hungry Elephant",60);
    public TitleScreen(){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, 200, 100);
        prepare();
    }

    public void act(){
        if (Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new MyWorld());
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,479,87);
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,211,307);
        label.setLocation(258,289);
        Label label2 = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label2,241,221);
        label2.setLocation(333,207);
        label.setLocation(311,268);
        label.getImage();
    }
}
//Maybe you can add a background in the title screen.