package tuple;

import java.util.List;
import java.util.Objects;

public class Two<First, Second> implements Tuple<Object> {

    private final First first;
    private final Second second;

    public static <First, Second> Two<First, Second> of(First first, Second second) {
        return new Two<>(first, second);
    }

    private Two(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public First getFirst() {
        return this.first;
    }

    public Second getSecond() {
        return this.second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Two<?, ?> two = (Two<?, ?>) o;
        return Objects.equals(first, two.first) && Objects.equals(second, two.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public List<Object> getElementsAsList() {
        return List.of(this.first, this.second);
    }

    @Override
    public boolean contains(Object element) {
        return this.first.equals(element) || this.second.equals(element);
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}
