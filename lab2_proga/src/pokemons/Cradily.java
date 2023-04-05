package pokemons;

import physical_skills.*;
import ru.ifmo.se.pokemon.Type;

public class Cradily extends Lileep {
    public Cradily(String name, int level){
        super(name, level);
        this.setType(Type.ROCK, Type.GRASS);
        this.setStats(86, 81, 97, 81, 107, 43);
        this.addMove(new Bulldoze());
    }
}
