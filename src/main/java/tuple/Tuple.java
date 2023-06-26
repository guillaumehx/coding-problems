package tuple;

import java.util.List;

public interface Tuple<T> {
    List<T> getElementsAsList();
    boolean contains(Object element);
    String toString();
}
