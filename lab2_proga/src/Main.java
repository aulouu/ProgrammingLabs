import pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();

        Pokemon p1 = new Zekrom("Зекром", 1);
        Pokemon p2 = new Lileep("Лилип", 2);
        Pokemon p3 = new Cradily("Крадили", 1);
        Pokemon p4 = new Poliwag("Поливаг", 3);
        Pokemon p5 = new Poliwhirl("Поливирл", 2);
        Pokemon p6 = new Poliwrath("Поливрат", 3);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p4);
        b.addFoe(p3);
        b.addFoe(p5);
        b.addFoe(p6);

        b.go();
    }
}