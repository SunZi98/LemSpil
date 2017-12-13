package business;

public class Prop {
    
    
    //Attributes that define a Prop
    private String propName;
    private String propDescription;
    private boolean consumable;
    
    public Prop(String propName, int propValue){ //Contructor that gives the Prop a name
        this.propName = propName;
        
    }
    
    public boolean isConsumable() {  //returns consumable value
        return consumable;
    }

    public String getPropName() { //return propName value
        return propName;
    }

    public String getPropDescription() { //return propDescription value
        return propDescription;
    }

    public void setPropDescription(String propDesripction) { //set a new propDescritpion. 
        this.propDescription = propDesripction;
    }
    
}
