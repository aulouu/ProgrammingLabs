package physical_skills;

import ru.ifmo.se.pokemon.*;

public class RockTomb extends PhysicalMove {
    public RockTomb(){
        super(Type.ROCK, 60, 95);
    }
    protected String describe(){
        return "Применяет RockTomb! Наносит урон и снижает скорость цели на одну ступень.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().stat(Stat.SPEED, -1));
    }
}
