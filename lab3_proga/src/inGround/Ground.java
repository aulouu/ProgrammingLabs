package inGround;

import Moves.ForGround;

public class Ground implements ForGround {
    private String name;
    public Ground (String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Земля";
    }
    @Override
    public void sit(){
        System.out.print("на " + getName());
    }
}
