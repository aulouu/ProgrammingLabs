package physical_skills;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class DoubleSlap extends PhysicalMove {
    public DoubleSlap(){
        super(Type.NORMAL, 10, 85);
    }
    protected String describe(){
        return "Применяет DoubleSlap! Наносит неоднократный удар.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        int x = (int)(Math.random()*(5-2)+2);
        p.addEffect(new Effect().turns(x));
    }
}
