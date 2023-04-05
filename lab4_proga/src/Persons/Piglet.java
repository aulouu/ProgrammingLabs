package Persons;

import Moves.*;

public class Piglet extends Person implements ForPiglet {
    public Piglet(String name){
        super(name);
    }
    @Override
    public void getLocation(){
        super.getLocation();
    }
    @Override
    public void setLocation(boolean location){
        super.setLocation(location);
    }
    @Override
    public String toString(){
        return "Пятачок";
    }
    LocationForPerson isGround = LocationForPerson.GROUND;
    public void sit(String name) throws NotRightPlace {
        if (isGround == LocationForPerson.AREA){
            throw new NotRightPlace("Пятачок не на земле!");
        }
        else {
        System.out.print(getName() + " сидел на " + name); }
    }
    @Override
    public void wonder(String name){
        System.out.print(" и гадал на " + name + ", ");
    }
    @Override
    public void know(){
        System.out.println(" и выясняя - " + Action.LOVE.getAction() + ", " + Action.DONTLOVE.getAction() + ", " + Action.SPIT.getAction() + ", " + Action.KISS.getAction() + ".");
    }
    @Override
    public void remember(){
        System.out.println("Оказалось, что плюнет, и он теперь старался вспомнить, на кого он загадл, надеясь, что это не Пух. ");
    }
    public void go(){
        System.out.print("за ним " + getName());
    }
}
