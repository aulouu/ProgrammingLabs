package inGround;

import Moves.ForChamomile;

public class Chamomile implements ForChamomile {
    private String name;
    public Chamomile (String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Ромашка";
    }
    @Override
    public void wonder(){
        System.out.print("на " + getName() + ", ");
    }
}
