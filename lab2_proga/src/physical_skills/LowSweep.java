package physical_skills;

import ru.ifmo.se.pokemon.*;

public class LowSweep extends PhysicalMove {
    public LowSweep(){
        super(Type.FIGHTING, 65, 100);
    }
    protected String describe(){
        return "Применяет LowSweep! Наносит урон и снижает скорость цели на одну ступень.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().stat(Stat.SPEED, -1));
    }
}
