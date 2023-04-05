package pokemons;

import physical_skills.*;
import ru.ifmo.se.pokemon.Type;

public class Poliwrath extends Poliwhirl {
    public Poliwrath(String name, int level){
        super(name, level);
        this.setType(Type.WATER, Type.FIGHTING);
        this.setStats(90, 95, 95, 70, 90, 70);
        this.addMove(new LowSweep());
    }
}
