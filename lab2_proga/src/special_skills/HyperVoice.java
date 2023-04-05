package special_skills;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class HyperVoice extends SpecialMove {
    public HyperVoice(){
        super(Type.NORMAL, 90, 100);
    }
    protected String describe(){
        return "Применяет HyperVoice! Наносит урон без дополнительного эффекта.";
    }
}
