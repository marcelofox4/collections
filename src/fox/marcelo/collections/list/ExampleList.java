package fox.marcelo.collections.list;

import java.util.*;

public class ExampleList {
    public static void main(String[] args) {
//        Dada uma Lista com 7 nostas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], Faça:

        System.out.println("Crie uma lista e adicione as sete notas");
//        Existe algumas formas de inicialização, são elas:
//        List studentGrades = new ArrayList(); //Antes do Java 5.
//        List<Double> studentGrades = new ArrayList<>(Arrays.asList(7, 8.5, 9.3, 5, 7, 0, 3.6));
        List<Double> studentGrades = new ArrayList<Double>(); //Generics(jdk 5) - Diamond Operator.
        studentGrades.add(7.0);
        studentGrades.add(8.5);
        studentGrades.add(9.3);
        studentGrades.add(5.0);
        studentGrades.add(7.0);
        studentGrades.add(0.0);
        studentGrades.add(3.6);
        System.out.println(studentGrades + "\n");

        //indexOF()
        System.out.println("Exiba a posição da nota 5.0:");
        System.out.println("Posição: " + studentGrades.indexOf(5.0) + "\n");

        //add(index, element)
        System.out.println("Adicione na lista a nota 8.0 na posição 4:");
        studentGrades.add(4, 8.0);
        System.out.println(studentGrades + "\n");

        //set(index número substituir, element)
        System.out.println("Substitua a nota 5.0 pela nota 6.0:");
        studentGrades.set(studentGrades.indexOf(5.0), 6.0);
        System.out.println(studentGrades + "\n");

        //contains(element)
        System.out.println("Confira se a nota 5.0 está na lista:");
        System.out.println(studentGrades.contains(5.0) + "\n");

        //get(index)
        System.out.println("Exiba a terceira nota adicionada:");
        System.out.println(studentGrades.get(2) + "\n");

        //Collection.min(Collection) a List é uma collection
        System.out.println("Exiba a menor nota:");
        System.out.println(Collections.min(studentGrades) + "\n");

        //Collection.max(Collection)
        System.out.println("Exiba a maior nota:");
        System.out.println(Collections.max(studentGrades) + "\n");

        //iterator()
        System.out.println("Exiba a soma das notas:");
        Iterator<Double> iterator = studentGrades.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            double next = iterator.next();
            sum += next;
        }
        System.out.println(sum + "\n");

        System.out.println("Exiba a média das notas:");
        double average = sum / studentGrades.size();
        System.out.println(average + "\n");

        //remove(index ou Object)
        System.out.println("Remova a nota 0.0:");
        studentGrades.remove(0.0);
        System.out.println(studentGrades + "\n");

        System.out.println("Remova a nota na posição 0:");
        studentGrades.remove(0);
        System.out.println(studentGrades + "\n");

        System.out.println("Remova as notas menores que 7.0 e exiba a lista:");
        Iterator<Double> iterator1 = studentGrades.iterator();
        while (iterator1.hasNext()) {
            double next = iterator1.next();
            if (next < 7) {
                iterator1.remove();
            }
        }
        System.out.println(studentGrades + "\n");

        //clear()
        System.out.println("Apague toda a lista:");
        studentGrades.clear();

        //isEmpty
        System.out.println("Confira se a lista está vazia:");
        System.out.println(studentGrades.isEmpty());
    }
}
