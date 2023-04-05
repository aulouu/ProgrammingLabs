package Persons;

public class Rabbit extends Person{
    public Rabbit(String name){
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
        return "Кролик";
    }
    public void go(){
        System.out.print(" и " + getName() + ", ");
    }
}
