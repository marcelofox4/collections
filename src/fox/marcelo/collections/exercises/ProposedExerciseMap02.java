package fox.marcelo.collections.exercises;

import java.util.*;

public class ProposedExerciseMap02 {
    public static void main(String[] args) {

        Map<Integer, Integer> saveNumbers = new LinkedHashMap<>();
        for (int i = 0; i < 100; i++) {
            int dice = (int)(Math.random() * 6 ) + 1;
            saveNumbers.put(i, dice);
        }
        System.out.println(saveNumbers);

        int countOne = 0;
        int countTwo = 0;
        int countThree = 0;
        int countFour = 0;
        int countFive = 0;
        int countSix = 0;

        Iterator<Map.Entry<Integer, Integer>> iterator = saveNumbers.entrySet().iterator();
        while(iterator.hasNext()){
            switch (iterator.next().getValue()){
                case 1:
                    countOne++;
                    break;
                case 2:
                    countTwo++;
                    break;
                case 3:
                    countThree++;
                    break;
                case 4:
                    countFour++;
                    break;
                case 5:
                    countFive++;
                    break;
                case 6:
                    countSix++;
                    break;
            }
        }

        System.out.println("1 apareceu " + countOne + " vezes.");
        System.out.println("2 apareceu " + countTwo + " vezes.");
        System.out.println("3 apareceu " + countThree + " vezes.");
        System.out.println("4 apareceu " + countFour + " vezes.");
        System.out.println("5 apareceu " + countFive + " vezes.");
        System.out.println("6 apareceu " + countSix + " vezes.");
    }
}
