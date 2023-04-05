package Persons;

public class LittleRu extends Person{
    public LittleRu(String name){
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
        return "Крошка Ру";
    }
    public void go(){
        System.out.print(getName() + " и ");
    }
}
