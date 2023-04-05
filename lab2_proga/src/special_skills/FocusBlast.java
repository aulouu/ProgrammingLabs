package special_skills;

import ru.ifmo.se.pokemon.*;

public class FocusBlast extends SpecialMove {
    public FocusBlast(){
        super(Type.FIGHTING, 120, 70);
    }
    protected String describe(){
        return "Применяет FocusBlast! Наносит урон и с вероятностью 10% снижает специальную защиту цели на одну ступень.";
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        p.addEffect(new Effect().chance(0.1).stat(Stat.SPECIAL_DEFENSE, -1));
    }
}
