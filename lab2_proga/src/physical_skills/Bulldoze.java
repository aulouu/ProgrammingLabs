package physical_skills;

import ru.ifmo.se.pokemon.*;

public class Bulldoze extends PhysicalMove{
    public Bulldoze(){
        super(Type.GROUND, 60, 100);
    }
    protected String describe(){
        return "Применяет Bulldoze! Наносит урон и снижает скорость цели на одну ступень.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().stat(Stat.SPEED, -1));
    }
}
