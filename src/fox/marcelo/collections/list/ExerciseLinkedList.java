package fox.marcelo.collections.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExerciseLinkedList {
    public static void main(String[] args) {

        /*
         * Resolva esses Exercícios utilizando os métodos da implementação LinkedList:
         * - Crie uma lista chamada notas2 e coloque todos os elementos da List ArrayList nessa nova lista.
         * - Mostre a primeira nota da nova lista sem removê-lo;
         * - Mostre a primeira nota da nova lista removendo-o.
         * */

        List<Double> studentGrades = new ArrayList<Double>(); //Generics(jdk 5) - Diamond Operator.
        studentGrades.add(7.0);
        studentGrades.add(8.5);
        studentGrades.add(9.3);
        studentGrades.add(5.0);
        studentGrades.add(7.0);
        studentGrades.add(0.0);
        studentGrades.add(3.6);
        System.out.println(studentGrades + "\n");

        System.out.println("Crie uma lista chamada notas2 e coloque todos os elementos da List ArrayList nessa nova lista:");
        List<Double> studentGradesTwo = new LinkedList<Double>(studentGrades);
        System.out.println(studentGradesTwo + "\n");

        System.out.println("Mostre a primeira nota da nova lista sem removê-lo:");
        System.out.println(studentGradesTwo.get(0) + "\n");

        System.out.println("Mostre a primeira nota da nova lista removendo-o:");
        studentGradesTwo.remove(studentGradesTwo.get(0));
        System.out.println(studentGradesTwo);
    }
}
