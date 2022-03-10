package fox.marcelo.collections.set;

import java.util.*;

public class ExampleSet {
    public static void main(String[] args) {

        //Dada uma lista com 7 notas de um aluno {7, 8.5, 9.3, 5, 7, 0, 3.6}, faça:

        System.out.println("Crie um conjunto e adicione as notas:");
        //HashSet
        // - Não mantém a ordem dos elementos;
        // - Não aceita duplicidade;
        Set<Double> studentGradles = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(studentGradles + "\n");

        //Não é possível acessar um índice dentro de um HashSet
        //System.out.println("Exiba a posição da nota 5.0:");

        //Não é possível acessar um índice, portanto não é possível acessar um posição de incerção
        //de um elemento.
        //System.out.println("Adicione na s lista a nota 8.0 na posição 4:");

        //Não é possível fazer essa substituição pelos mesmo motivos das questões anteriores;
        //System.out.println("Substitua a nota 5.0 pela nota 6.0:");

        //contains();
        System.out.println("Confira se a nota 5.0 está no conjunto:");
        System.out.println(studentGradles.contains(5d) + "\n");

        //Não é possível acessar índices, não é possível saber qual a posição;
        //System.out.println("Exiba a terceira nota adicionada:");

        System.out.println("Exiba a menor nota:");
        System.out.println(Collections.min(studentGradles) + "\n");

        System.out.println("Exiba a maior nota:");
        System.out.println(Collections.max(studentGradles) + "\n");

        //iterator()
        System.out.println("Exiba a soma dos valores");
        Iterator<Double> iterator = studentGradles.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        System.out.println(sum + "\n");

        //size()
        System.out.println("Exiba a média das notas");
        double average = sum / studentGradles.size();
        System.out.println(average + "\n");

        //remove(element)
        System.out.println("Remova a nota 0:");
        studentGradles.remove(0.0);
        System.out.println(studentGradles + "\n");

        System.out.println("Remova as notas menores de 7 e exiba a lista");
        Iterator<Double> iterator1 = studentGradles.iterator();
        while (iterator1.hasNext()) {
            double next = iterator1.next();
            if (next < 7) {
                iterator1.remove();
            }
        }
        System.out.println(studentGradles + "\n");

        //A LinkedHashSet mantém a ordem de inserção dos elementos
        System.out.println("Exiba as notas na ordem em que foram informadas");
        Set<Double> studentGradesSort = new LinkedHashSet<>(Arrays.asList());
        studentGradesSort.add(7d);
        studentGradesSort.add(8.5);
        studentGradesSort.add(9.3);
        studentGradesSort.add(5d);
        studentGradesSort.add(7d);
        studentGradesSort.add(0d);
        studentGradesSort.add(3.6);
        System.out.println(studentGradesSort + "\n");

        //A TreeSet mantém a ordem natural dos elementos
        System.out.println("Exiba todas as notas na ordem crescente:");
        Set<Double> studentGradesNaturalSort = new TreeSet<>(studentGradesSort);
        System.out.println(studentGradesNaturalSort + "\n");

        //clear()
        System.out.println("Apague todo o conjunto: \n");
        studentGradesNaturalSort.clear();

        //isEmpty()
        System.out.println("Confira se o conjunto está vazio:");
        System.out.println(studentGradesNaturalSort.isEmpty());
    }
}
