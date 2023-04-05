package pokemons;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import special_skills.*;
import physical_skills.*;

public class Lileep extends Pokemon {
    public Lileep(String name, int level){
        super(name, level);
        this.setType(Type.ROCK, Type.GRASS);
        this.setStats(66, 41, 77, 61, 87, 23);
        this.setMove(new EnergyBall(), new RockTomb(), new Facade());
    }
}
