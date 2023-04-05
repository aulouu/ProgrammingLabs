package Persons;

public enum Action {
    LOVE ("любит"),
    DONTLOVE ("не любит"),
    SPIT ("плюнет"),
    KISS ("поцелует");
    private String action;
    Action(String action){
        this.action = action;
    }
    public String getAction(){
        return action;
    }
}
