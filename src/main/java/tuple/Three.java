package tuple;

import java.util.List;
import java.util.Objects;

public class Three<First, Second, Third> implements Tuple<Object> {

    private final First first;
    private final Second second;
    private final Third third;

    public static <First, Second, Third> Three<First, Second, Third> of(First first, Second second, Third third) {
        return new Three<>(first, second, third);
    }

    private Three(First first, Second second, Third third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public First getFirst() {
        return this.first;
    }

    public Second getSecond() {
        return this.second;
    }

    public Third getThird() {
        return this.third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Three<?, ?, ?> three = (Three<?, ?, ?>) o;
        return Objects.equals(first, three.first) && Objects.equals(second, three.second) && Objects.equals(third, three.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public List<Object> getElementsAsList() {
        return List.of(this.first, this.second, this.third);
    }

    @Override
    public boolean contains(Object element) {
        return this.first.equals(element) || this.second.equals(element) || this.third.equals(element);
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ")";
    }
}
