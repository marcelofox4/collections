package fox.marcelo.collections.exercises;

import java.util.*;

public class ProposedExerciseSet02 {
    public static void main(String[] args) {

        /*
         * Crie uma Classe LinguagemFavorita que possua os Atributos:
         * - Nome;
         * - Ano de Criação;
         * - IDE.
         *
         * Em seguida crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto
         * por:
         * a) Ordem de Inserção;
         * b) Ordem Natural (Nome);
         * c) IDE;
         * d) Ano de Criação e Nome;
         * e) Nome, Ano de Criação e IDE.
         *
         * Ao final, exiba as linguagens no Console, uma abaixo da outra.
         * */

        System.out.println("Crie um conjunto com 3 linguagens:");
        Set<FavoriteLanguage> favoriteLanguagesLinkedHashSet = new LinkedHashSet<>() {{
            add(new FavoriteLanguage("Java", 1991, "Intellij"));
            add(new FavoriteLanguage("C#", 2000, "Visual Studio"));
            add(new FavoriteLanguage("PHP", 1994, "NetBeans"));
        }};
        System.out.println();

        System.out.println("Ordem de Inserção:");
        for (FavoriteLanguage language : favoriteLanguagesLinkedHashSet) {
            System.out.println(language);
        }
        System.out.println();

        System.out.println("Ordem Natural - Nome:");
        Set<FavoriteLanguage> favoriteLanguagesTreeSet = new TreeSet<>(favoriteLanguagesLinkedHashSet);
        for (FavoriteLanguage language :
                favoriteLanguagesTreeSet) {
            System.out.println(language);
        }
        System.out.println();

        System.out.println("Ordem Natural - IDE:");
        Set<FavoriteLanguage> favoriteLanguagesTreeSetTwo = new TreeSet<>(new ComparatorIde());
        favoriteLanguagesTreeSetTwo.addAll(favoriteLanguagesLinkedHashSet);
        for (FavoriteLanguage language :
                favoriteLanguagesTreeSetTwo) {
            System.out.println(language);
        }
        System.out.println();

        System.out.println("Ordem Natural - Ano de Criação/Nome");
        Set<FavoriteLanguage> favoriteLanguagesTreeSetThree = new TreeSet<>(new ComparatorCreationYearName());
        favoriteLanguagesTreeSetThree.addAll(favoriteLanguagesLinkedHashSet);
        for (FavoriteLanguage language :
                favoriteLanguagesTreeSetThree) {
            System.out.println(language);
        }
        System.out.println();

        System.out.println("Ordem Natural - Nome/Ano de Criação/IDE");
        Set<FavoriteLanguage> favoriteLanguagesTreeSetFour = new TreeSet<>(new ComparatorNameCreationYearIde());
        favoriteLanguagesTreeSetFour.addAll(favoriteLanguagesLinkedHashSet);
        for (FavoriteLanguage language :
                favoriteLanguagesTreeSetFour) {
            System.out.println(language);
        }
        System.out.println();
    }
}

class FavoriteLanguage implements Comparable<FavoriteLanguage> {

    private String name;
    private int CreationYear;
    private String Ide;

    public FavoriteLanguage(String name, int creationYear, String ide) {
        this.name = name;
        CreationYear = creationYear;
        Ide = ide;
    }

    public String getName() {
        return name;
    }

    public int getCreationYear() {
        return CreationYear;
    }

    public String getIde() {
        return Ide;
    }

    @Override
    public String toString() {
        return "{" +
                "Nome = " + name +
                " - Ano de Criação = " + CreationYear +
                " - IDE = " + Ide +
                '}';
    }

    @Override
    public int compareTo(FavoriteLanguage language) {
        return this.name.compareTo(language.getName());
    }
}

class ComparatorIde implements Comparator<FavoriteLanguage> {

    @Override
    public int compare(FavoriteLanguage languageOne, FavoriteLanguage languageTwo) {

        int compareToIde = languageOne.getIde().compareTo(languageTwo.getIde());
        if (compareToIde != 0) {
            return compareToIde;
        }

        return languageOne.getName().compareTo(languageTwo.getName());
    }
}

class ComparatorCreationYearName implements Comparator<FavoriteLanguage> {

    @Override
    public int compare(FavoriteLanguage languageOne, FavoriteLanguage languageTwo) {

        int compareToCreationYear = Integer.compare(languageOne.getCreationYear(), languageTwo.getCreationYear());
        if (compareToCreationYear != 0) {
            return compareToCreationYear;
        }

        return languageOne.getName().compareTo(languageTwo.getName());
    }
}

class ComparatorNameCreationYearIde implements Comparator<FavoriteLanguage> {

    @Override
    public int compare(FavoriteLanguage languageOne, FavoriteLanguage languageTwo) {

        int compareToName = languageOne.getName().compareTo(languageTwo.getName());
        if (compareToName != 0) {
            return compareToName;
        }

        int compareToCreationYear = Integer.compare(languageOne.getCreationYear(), languageTwo.getCreationYear());
        if (compareToCreationYear != 0) {
            return compareToCreationYear;
        }

        return languageOne.getIde().compareTo(languageTwo.getIde());
    }
}
