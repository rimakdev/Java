package PatronMemento;

import java.util.ArrayList;

public class Caretaker {
    protected ArrayList<Memento> mementos = new ArrayList<>();
    public void addMemento(Memento m){
        mementos.add(m);
    }
    public Memento getMemento(int index){
        return mementos.get(index);
    }
}
