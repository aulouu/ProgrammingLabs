package pokemons;

import physical_skills.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import special_skills.*;
import status_skills.*;

public class Zekrom extends Pokemon {
    public Zekrom(String name, int level){
        super(name, level);
        this.setType(Type.DRAGON, Type.ELECTRIC);
        this.setStats(100, 150, 120, 120, 100, 90);
        this.setMove(new RockSlide(), new HyperVoice(), new ThunderWave(), new FocusBlast());
    }
}
