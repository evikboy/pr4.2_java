package CharacterCreator.Memento;

import CharacterCreator.Stats;

public class Originator {
    private Stats state;

    public Stats getState() {
        return state;
    }

    public void setState(Stats state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Stats stats) {
        this.state = stats;
    }

}
