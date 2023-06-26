package tuple;

import java.util.List;
import java.util.Objects;

public class Four<First, Second, Third, Fourth> implements Tuple<Object> {

    private final First first;
    private final Second second;
    private final Third third;
    private final Fourth fourth;

    public static <First, Second, Third, Fourth> Four<First, Second, Third, Fourth> of(First first, Second second, Third third, Fourth fourth) {
        return new Four<>(first, second, third, fourth);
    }

    private Four(First first, Second second, Third third, Fourth fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
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

    public Fourth getFourth() {
        return this.fourth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Four<?, ?, ?, ?> four = (Four<?, ?, ?, ?>) o;
        return Objects.equals(first, four.first) && Objects.equals(second, four.second) && Objects.equals(third, four.third) && Objects.equals(fourth, four.fourth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third, fourth);
    }

    @Override
    public List<Object> getElementsAsList() {
        return List.of(this.first, this.second, this.third, this.fourth);
    }

    @Override
    public boolean contains(Object element) {
        return this.first.equals(element) || this.second.equals(element) || this.third.equals(element) || this.fourth.equals(element);
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ", " + this.fourth + ")";
    }
}
