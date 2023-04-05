package special_skills;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Scald extends SpecialMove {
    public Scald(){
        super(Type.WATER, 80, 100);
    }
    protected String describe(){
        return "Применяет Scald! Наносит урон и имеет 30% шанс сжечь цель.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() <= 0.3) Effect.burn(p);
    }
}
