package Persons;

import Moves.*;

public class WinnieThePooh extends Person implements ForWinnieThePooh {
    public WinnieThePooh(String name){
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
        return "Винни-Пух";
    }
    @Override
    public void sit(){
        System.out.print(getName() + " сел и крепко, изо всех сил, ");
    }
    @Override
    public void rest(String name){
        System.out.println("уперся лапками в землю, а спиной изо всех сил уперся в спину " + name + ", а");
    }
    @Override
    public void appear(){
        System.out.println("И тут появился " + getName() + ". ");
    }
    @Override
    public void go(){
        System.out.print(" и " + getName() + ", ");
    }
    public void compose(String name){
        System.out.println("Все, кроме " + getName() + ", который сочинял " + name + ".");
    }
    @Override
    public void sing(){
        System.out.print("На это " + getName() + " не нашел, что ответить, и поэтому начал петь: ");
    }
}