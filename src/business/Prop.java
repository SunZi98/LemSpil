package business;

public class Prop {

    private String propName;
    private String propDescription;
    private int propValue;
    private boolean consumable;
    
    public Prop(String propName, int propValue){
        this.propName = propName;
        this.propValue = propValue;
        
    }
    
    public boolean isConsumable() {
        return consumable;
    }

    public String getPropName() { //return propName
        return propName;
    }

    public String getPropDescription() { //return propDescriptuin
        return propDescription;
    }

    public void setPropDescription(String popDesripction) { //set a new propDescritpion. 
        this.propDescription = popDesripction;
    }
    
}
