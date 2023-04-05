package Persons;

public class ChristopherRobin extends Person{
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
    public void go(){
        System.out.print("Первым шёл " + getName());
    }
}
