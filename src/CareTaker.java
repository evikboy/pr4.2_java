import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private static int id;
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento memento) {
        mementoList.add(memento);
        System.out.println("!!!State saved: id=" + id);
        id++;
    }

    public Memento get(int index) {
        System.out.println("!!!Loading stats from save: id=" + index);
        return mementoList.get(index);
    }
}
