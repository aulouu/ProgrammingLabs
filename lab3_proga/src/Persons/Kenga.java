package Persons;

public class Kenga extends Person {
    public Kenga(String name){
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
        return "Кенга";
    }
    public void go(){
        System.out.print("далее " + getName() + " c ");
    }
}
