import Persons.*;
import inGround.*;
import inArea.*;

public class Main {
    public static void main(String[] args) {
        Piglet piglet = new Piglet("Пятачок");
        WinnieThePooh winnieThePooh = new WinnieThePooh("Винни-Пух");
        ChristopherRobin christopherRobin = new ChristopherRobin("Кристофер Робин");
        LittleRu littleRu = new LittleRu("Крошка Ру");
        Kenga kenga = new Kenga("Кенга");
        Rabbit rabbit = new Rabbit("Кролик");
        Owl owl = new Owl("Сова");
        Ia ia = new Ia("Иа");
        Others others = new Others("все родные и знакомые Кролика");
        Expedition expedition = new Expedition("экспедиция");
        Ground ground = new Ground("на земле");
        Chamomile chamomile = new Chamomile("на ромашке");
        Location isGround = Location.GROUND;
        if (isGround == Location.GROUND){
            piglet.sit();
            ground.sit();
            piglet.wonder();
            chamomile.wonder();
            piglet.know();
            piglet.remember();
            winnieThePooh.appear();
        }
        Location isArea = Location.AREA;
        if (isArea == Location.AREA){
            System.out.print("Спустя немного времени все были в сборе, и ");
            expedition.start();
            christopherRobin.go();
            rabbit.go();
            piglet.go();
            winnieThePooh.go();
            kenga.go();
            littleRu.go();
            owl.go();
            ia.go();
            others.go();
        }
    }
}