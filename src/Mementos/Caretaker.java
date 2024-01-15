package Mementos;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private List<RentalManagementSystemMemento> mementos = new ArrayList<>();

    public void addMemento(RentalManagementSystemMemento memento) {
        mementos.add(memento);
    }

    public RentalManagementSystemMemento getMemento(int index) {
        return mementos.get(index);
    }
}
