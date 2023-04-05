package special_skills;

import ru.ifmo.se.pokemon.*;

public class MudShot extends SpecialMove {
    public MudShot(){
        super(Type.GROUND, 55, 95);
    }
    protected String describe(){
        return "Применяет MudShot! Наносит урон и снижает скорость цели на одну ступень.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().stat(Stat.SPEED, -1));
    }
}
