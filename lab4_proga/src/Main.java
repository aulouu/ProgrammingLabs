import Persons.*;

public class Main {
    public static void main(String[] args) {
        int count = 21;
        Piglet piglet = new Piglet("Пятачок");
        WinnieThePooh winnieThePooh = new WinnieThePooh("Винни-Пух");
        ChristopherRobin christopherRobin = new ChristopherRobin("Кристофер Робин");
        Rabbit rabbit = new Rabbit("Кролик");
        All all = new All("все");
        Area area = new Area();
        Ground ground = new Ground("земле");
        Ground.Chamomile chamomile = new Ground.Chamomile("ромашке");
        Ground.Chamomile.Petal petal = chamomile.new Petal("лепесток");
        Song song = new Song("песню");
        Ground.Boot boot = new Ground.Boot("сапог");

        winnieThePooh.sit();
        winnieThePooh.rest(christopherRobin.getName());
        christopherRobin.rest(winnieThePooh.getName());
        christopherRobin.pull(boot.getName());
        boot.wear();
        christopherRobin.dontunderstand();
        christopherRobin.went();
        christopherRobin.meet(rabbit.getName());
        christopherRobin.bye(rabbit.getName());
        christopherRobin.run(piglet.getName());

        LocationForPerson isGround = LocationForPerson.GROUND;
        if (isGround == LocationForPerson.GROUND){
            piglet.sit(ground.getName());
            piglet.wonder(chamomile.getName());
            try {
                petal.tear(count, petal.getName());
            } catch (NoPetalsOnChamomile e){
                System.out.println(e.getMessage());
                System.out.println("Сколько на ромашке лепестков? " + count);
            }
            piglet.know();
            piglet.remember();
            winnieThePooh.appear();
        }

        LocationForPerson isArea = LocationForPerson.AREA;
        if (isArea == LocationForPerson.AREA){
            area.expedition();
            christopherRobin.go();
            rabbit.go();
            piglet.go();
            winnieThePooh.go();
            MovesInArea kenga = new MovesInArea() {
                @Override
                public void go() {
                    System.out.print("далее Кенга ");
                }
            };
            kenga.go();
            MovesInArea littleRu = new MovesInArea() {
                @Override
                public void go() {
                    System.out.print("с Крошкой Ру  ");
                }
            };
            littleRu.go();
            MovesInArea owl = new MovesInArea() {
                @Override
                public void go() {
                    System.out.print("и Сова,  ");
                }
            };
            owl.go();
            MovesInArea ia = new MovesInArea() {
                @Override
                public void go() {
                    System.out.println("еще дальше - Иа,");
                }
            };
            ia.go();
            MovesInArea others = new MovesInArea() {
                @Override
                public void go() {
                    System.out.println("а в самом конце, растянувшись длинной цепочкой, шли все Родные и Знакомые Кролика.");
                }
            };
            others.go();
            area.cry();
            all.come();
            all.chat();
            winnieThePooh.compose(song.getName());
            winnieThePooh.sing();
            System.out.print(song.toString());
        }
    }
}

class Area{
    public void expedition(){
        class Expedition{
            void start(){
                System.out.println("Спустя немного времени все были в сборе, и экспедиция началась.");
            }
        }
        Expedition expedition = new Expedition();
        expedition.start();
    }
    public void cry(){
        class Cry{
            void overheard(){
                System.out.print("Тут в голове колонны послышался крик.");
            }
        }
        Cry cry = new Cry();
        cry.overheard();
    }
}