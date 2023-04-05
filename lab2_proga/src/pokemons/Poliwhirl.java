package pokemons;

import ru.ifmo.se.pokemon.Type;
import special_skills.*;

public class Poliwhirl extends Poliwag {
    public Poliwhirl(String name, int level){
        super(name, level);
        this.setType(Type.WATER);
        this.setStats(65, 65, 65, 50, 50, 90);
        this.addMove(new MudShot());
    }
}
