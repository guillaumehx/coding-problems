import java.util.List;

public class BuyACar {

    public static void main(String[] args) {

        System.out.println(calculate(8000, 12000, 1000, 1.5));

    }

    public static List<Integer> calculate(double oldCarPrice, double newCarPrice, double amountSavedPerMonth, double percentDecrease) {

        double difference = oldCarPrice - newCarPrice;

        if(difference >= 0.0) {
            return List.of(0, (int) difference);
        }

        double oldCharDecreased = oldCarPrice - (oldCarPrice / 100) * percentDecrease;
        double newCarDecreased = newCarPrice - (newCarPrice / 100) * percentDecrease;


        System.out.println(oldCharDecreased);
        System.out.println(newCarDecreased);



        System.exit(0);


        return calculate(0,0,0,0);
    }

}
