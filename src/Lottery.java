import java.util.*;

public class Lottery {
    public static final int NUMBERS = 6;
    public static final int MAX_NUMBER = 40;

    public static void main(String[] args) {

        Set<Integer> winningNumbers = createWinningNumbers();

        System.out.println();
        Random lottoMachine = new Random();
        lottoMachine.setSeed(System.currentTimeMillis());

        System.out.println("\n");
        System.out.print("Numerele mele generate sunt: " + " ");
        Set setofSix = null;
        setofSix = new HashSet<Integer>();
        int counter = 0;
        do {
            int nr = lottoMachine.nextInt(49) + 1;
            boolean success = setofSix.add(nr);
            if (success) {
                counter++;
                System.out.print(nr + " ");
            }
        }
        while (counter < 6);


        Set<Integer> intersection = new TreeSet<Integer>(setofSix);
        intersection.retainAll(winningNumbers);


        System.out.println("\n");
        System.out.println("Numerele generate de agentie sunt " +
                winningNumbers);
        System.out.println();
        System.out.println("Tu ai nimerit " + intersection.size() +
                " numer(e).");
        if (intersection.size() > 0) {
            double prize = 100 * Math.pow(2, intersection.size());
            System.out.println("Numerele castigatoare sunt: " +
                    intersection);
            System.out.println("Premiul tau este de $" + prize);
        }
    }


    public static Set<Integer> createWinningNumbers() {
        Set<Integer> winningNumbers = new TreeSet<Integer>();
        Random r = new Random();
        while (winningNumbers.size() < NUMBERS) {
            int number = r.nextInt(MAX_NUMBER) + 1;
            winningNumbers.add(number);
        }
        return winningNumbers;
    }



    }

