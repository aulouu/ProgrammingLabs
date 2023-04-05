package pokemons;

import physical_skills.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import special_skills.*;

public class Poliwag extends Pokemon {
    public Poliwag(String name, int level){
        super(name, level);
        this.setType(Type.WATER);
        this.setStats(40, 50, 40, 40, 40, 90);
        this.setMove(new Scald(), new DoubleSlap());
    }
}
