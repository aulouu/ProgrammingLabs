package status_skills;

import ru.ifmo.se.pokemon.*;

public class ThunderWave extends StatusMove {
    public ThunderWave(){
        super(Type.ELECTRIC, 0, 90);
    }
    protected String describe(){
        return "Применяет ThunderWave! Парализует противника.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().condition(Status.PARALYZE));
        p.addEffect(new Effect().chance(0.75).stat(Stat.ACCURACY, 1));
        p.addEffect(new Effect().stat(Stat.SPEED, (int)p.getStat(Stat.SPEED)/2));
    }
}