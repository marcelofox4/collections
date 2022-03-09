package fox.marcelo.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExampleListSort {
    public static void main(String[] args) {

        /*
         * Dada as seguintes informações sobre os gatos de um petshop, crie uma lista e ordene exibindo:
         * - Nome, Idade, Cor.
         *
         * Gato 01 = nome: Jon, idade: 18, cor: preto;
         * Gato 02 = nome: Simba, idade: 6, cor: tigrado;
         * Gato 03 = nome: Jon, idade: 12, cor: amarelo;
         * */

        List<Cat> catsList = new ArrayList<>() {{
            add(new Cat("Joh", 18, "Preto"));
            add(new Cat("Simba", 6, "Tigrado"));
            add(new Cat("Joh", 12, "Amarelo"));
        }};

        System.out.println("Ordem de Inserção");
        System.out.println(catsList + "\n");

        //Collections.shuffle(List);
        System.out.println("Ordem Aleatória");
        Collections.shuffle(catsList);
        System.out.println(catsList + "\n");

        // Para ser possível fazer comparações entre os Objetos é necessário a implementação da Interface Comparable
        // na Classe Cat.
        //Colletions.sort(List)
        System.out.println("Ordem Natural por Nome");
        Collections.sort(catsList);
        System.out.println(catsList + "\n");

        //sort(Comparator)
        System.out.println("Ordem por Idade");
        //Collections.sort(catsList, new AgeComparator());
        catsList.sort(new AgeComparator());
        System.out.println(catsList + "\n");

        //sort(Comparator)
        System.out.println("Ordem por Cor");
        //Collections.sort(catsList, new ColorComparator());
        catsList.sort(new ColorComparator());
        System.out.println(catsList + "\n");

        System.out.println("Ordem por Nome/Cor/Idade"); // Criterios de desempate nessa ordem.
        catsList.sort((new NameColorAgeComparator()));
        System.out.println(catsList);


    }
}

class Cat implements Comparable<Cat> {

    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cat cat) {
        return this.getName().compareToIgnoreCase(cat.getName());
    }
    // Retorno = 0. Os objetos comparados tem nomes iguais;
    // Retorno = 1. Os objetos comparados tem nomes diferentes, mas um sendo maior que o outro;
    // Retorno = -1. Os objetos comparados tem nomes diferente, mas um sendo menor que outro;
}

class AgeComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat catOne, Cat catTwo) {
        return Integer.compare(catOne.getAge(), catTwo.getAge());
    }
}

class ColorComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat catOne, Cat catTwo) {
        return catOne.getColor().compareToIgnoreCase(catTwo.getColor());
    }
}

class NameColorAgeComparator implements Comparator<Cat> {

    @Override
    public int compare(Cat catOne, Cat catTwo) {
        int nameComparator = catOne.getName().compareToIgnoreCase(catTwo.getName());
        if (nameComparator != 0) {
            return nameComparator;
        }

        int colorComparator = catOne.getColor().compareToIgnoreCase(catTwo.getColor());
        if (colorComparator != 0) {
            return colorComparator;
        }

        return Integer.compare(catOne.getAge(), catTwo.getAge());
    }
    // Retorno = 0. Os objetos comparados tem nomes iguais;
    // Retorno = 1. Os objetos comparados tem nomes diferentes, mas um sendo maior que o outro;
    // Retorno = -1. Os objetos comparados tem nomes diferente, mas um sendo menor que outro;
}
