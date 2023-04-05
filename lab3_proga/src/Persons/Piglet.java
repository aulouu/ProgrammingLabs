package Persons;

import Moves.MovesInGround;




public class Piglet extends Person implements MovesInGround {
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
    @Override
    public void sit(){
        System.out.print(getName() + " сидел ");
    }
    @Override
    public void wonder(){
        System.out.print(" и гадал ");
    }
    @Override
    public void know(){
        System.out.println(" выясняя - " + Action.LOVE.getAction() + ", " + Action.DONTLOVE.getAction() + ", " + Action.SPIT.getAction() + ", " + Action.KISS.getAction() + ".");
    }
    @Override
    public void remember(){
        System.out.println("Оказалось, что плюнет, и он теперь старался вспомнить, на кого он загадл, надеясь, что это не Пух. ");
    }
    public void go(){
        System.out.print("за ним " + getName());
    }
}
