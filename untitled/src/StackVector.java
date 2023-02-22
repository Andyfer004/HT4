import java.util.Vector;

public class StackVector<T> implements IStack<T> {

    private Vector<T> miVectorInterno;

    public StackVector() {
        miVectorInterno = new Vector<T>();
    }

    @Override
    public int count() {
        return miVectorInterno.size();
    }

    @Override
    public boolean isEmpty() {
        return miVectorInterno.isEmpty();
    }

    @Override
    public void push(T value) {
        miVectorInterno.add(0, value);
    }

    @Override
    public T pull() {
        return miVectorInterno.remove(0);
    }

}

