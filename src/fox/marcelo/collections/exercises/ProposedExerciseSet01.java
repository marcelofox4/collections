package fox.marcelo.collections.exercises;

import java.util.*;

public class ProposedExerciseSet01 {
    public static void main(String[] args) {

        /*
         * Crie um conjunto contendo as cores do arco-íris e:
         * a) Exiba as cores uma abaixo da outra;
         * b) Exiba a quantidade de cores que o arco-íris tem;
         * c) Exiba as cores em ordem alfabética;
         * d) Exiba as cores na ordem inversa da que foi informada;
         * e) Exiba todas as cores que começam com a letra "V";
         * f) Remova todas as cores que não começam com a letra "V";
         * g) Limpe o conjunto;
         * h) Confira se o conjunto está vazio;
         * */

        //Vermelho
        //Laranja
        //Amarelo
        //Verde
        //Azul
        //Anil
        //Violeta

        System.out.println("Crie um conjunto contendo as cores do arco-íris:");
        Set<String> rainbowColors = new LinkedHashSet<>() {{
            add("vermelho");
            add("laranja");
            add("amarelo");
            add("verde");
            add("azul");
            add("anil");
            add("violeta");
        }};

        System.out.println("Exiba as cores uma abaixo da outra:");
        for (String color : rainbowColors) {
            System.out.println(color);
        }
        System.out.println();

        System.out.println("Exiba a quantidade de cores que o arco-íris tem:");
        System.out.println(rainbowColors.size() + "\n");

        System.out.println("Exiba as cores em ordem alfabética:");
        Set<String> rainbowColorsTreeSet = new TreeSet<>(rainbowColors);
        for (String color : rainbowColorsTreeSet) {
            System.out.println(color);
        }
        System.out.println();

        System.out.println("Exiba as cores na ordem inversa da que foi informada:");
        List<String> rainbowColorsList = new ArrayList<>(rainbowColorsTreeSet);
        for (int i = rainbowColorsList.size() - 1; i > 0; i--) {
            String reverseOrder = rainbowColorsList.get(i);
            System.out.println(reverseOrder);
        }
        System.out.println();

        /*
        Exercício realiado pela Camila Cavalcante
        System.out.println("Exiba as cores na ordem inversa da que foi informada ");
        Set<String> coresArcoIris3 = new LinkedHashSet<>(
                Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        System.out.println(coresArcoIris3);
        List<String> coresArcoIrisList = new ArrayList<>(coresArcoIris3);
        Collections.reverse(coresArcoIrisList);
        System.out.println(coresArcoIrisList);
        * */

        System.out.println("Exiba todas as cores que começam com a letra \"v\":");
        for (int i = 0; i < rainbowColorsList.size(); i++) {
            boolean isStartWithV = rainbowColorsList.get(i).startsWith("v");
            if (isStartWithV) {
                System.out.println(rainbowColorsList.get(i));
            }
        }
        System.out.println();

        /*
        Exercício realiado pela Camila Cavalcante
        System.out.println("Exiba todas as cores que começam com a letra ”v”: ");
        for (String cor: coresArcoIris) {
            if(cor.startsWith("v")) System.out.println(cor);
        }
        * */

        System.out.println("Remova todas as cores que não começam com a letra \"v\":");
        Iterator<String> iterator = rainbowColorsList.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().startsWith("v")) {
                iterator.remove();
            }
        }
        System.out.println(rainbowColorsList + "\n");

        /*
        System.out.println("Remova todas as cores que não começam com a letra “v”: ");
        Iterator<String> iterator2 = coresArcoIris.iterator();
        while (iterator2.hasNext()) {
            if (!iterator2.next().startsWith("v")) iterator2.remove();
        }
        System.out.println(coresArcoIris);
        */

        System.out.println("Limpe o conjunto:");
        rainbowColors.clear();
        rainbowColorsTreeSet.clear();
        rainbowColorsList.clear();
        System.out.println("Conjuntos limpos" + "\n");

        System.out.println("Confira se o conjunto está vazio:");
        System.out.println("rainbowColors.isEmpty: " + rainbowColors.isEmpty());
        System.out.println("rainbowColorsTreeSet.isEmpty: " + rainbowColorsTreeSet.isEmpty());
        System.out.println("rainbowColorsList: " + rainbowColorsList.isEmpty());
    }
}
