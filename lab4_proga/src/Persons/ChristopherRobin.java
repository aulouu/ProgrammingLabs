package Persons;

import Moves.ForChristopherRobin;

public class ChristopherRobin extends Person implements ForChristopherRobin {
    public ChristopherRobin(String name){
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
        return "Кристофер Робин";
    }
    @Override
    public void rest(String name){
        System.out.print(getName() + " изо всех сил уперся в спину " + name);
    }
    @Override
    public void pull(String name){
        System.out.print(" и стал тащить и тянуть свой " + name + ", ");
    }
    @Override
    public void dontunderstand(){
        System.out.print("По правде говоря, он ничего не понял. ");
    }
    @Override
    public void went(){
        System.out.println("И он отправился в путь.");
    }
    @Override
    public void meet(String name){
        System.out.println("Первым, кого он встретил, был " + name + ".");
    }
    @Override
    public void bye(String name){
        System.out.print("Он попрощался с " + name);
    }
    @Override
    public void run(String name){
        System.out.println(" и побежал к дому " + name + ".");
    }
    @Override
    public void go(){
        System.out.print("Первым шёл " + getName());
    }
}
