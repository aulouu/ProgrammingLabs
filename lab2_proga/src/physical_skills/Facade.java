package physical_skills;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade(){
        super(Type.NORMAL, 70, 100);
    }
    protected String describe(){
        return "Применяет Facade! Наносит урон и наносит удары с удвоенной силой, если пользователь обожжен, отравлен или парализован.";
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def, damage);
        if ((def.getCondition() == Status.PARALYZE) || (def.getCondition() == Status.POISON) || (def.getCondition() == Status.BURN)){
            def.setMod(Stat.HP, (int)Math.round(2*damage));
        }
    }
}
