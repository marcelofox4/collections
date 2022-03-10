package fox.marcelo.collections.set;

import java.util.*;

public class ExampleSetSort {
    public static void main(String[] args) {

        /*
         * Dada as seguintes informações sobre séries, crie um conjunto e ordene este
         * conjunto exibindo:
         * Nome - Gênero - Tempo de Episódio.
         *
         * - Série 1 = Nome: GOT - Gênero: Fantasia - Tempo de Episódio: 60.
         * - Série 2 = Nome: Dark - Gênero: Drama - Tempo de Episódio: 60.
         * - Série 3 = Nome: That '70s show - Gênero: Comédia - Tempo de Episódio: 25.
         * */

        System.out.println("Ordem aleátoria:");
        Set<Serie> seriesHashSet = new HashSet<>() {{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("That '70s show", "Comédia", 25));
        }};
        for (Serie serie :
                seriesHashSet) {
            System.out.println(serie);
        }
        System.out.println();

        System.out.println("Ordem de Inserção:");
        Set<Serie> seriesLinkedHashSet = new LinkedHashSet<>() {{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("That '70s show", "Comédia", 25));
        }};
        for (Serie serie :
                seriesLinkedHashSet) {
            System.out.println(serie);
        }
        System.out.println();

        System.out.println("Ordem Natural (Tempo de Episódio):");
        Set<Serie> seriesTreeSet = new TreeSet<>(seriesLinkedHashSet);
        for (Serie serie :
                seriesTreeSet) {
            System.out.println(serie);
        }
        System.out.println();

        System.out.println("Ordem Natural Nome/Gênero/Tempo de Episódio:");
        Set<Serie> seriesTreeSetTwo = new TreeSet<>(new ComparatorNameGenreEpisodeTime());
        seriesTreeSetTwo.addAll(seriesTreeSet);
        for (Serie serie :
                seriesTreeSetTwo) {
            System.out.println(serie);
        }
        System.out.println();

        System.out.println("Ordem Natural Gênero");
        Set<Serie> seriesTreeSetThree = new TreeSet<>(new ComparatorGenre());
        seriesTreeSetThree.addAll(seriesTreeSet);
        for (Serie serie : seriesTreeSetThree) {
            System.out.println(serie);
        }
        System.out.println();

        System.out.println("Ordem Natural Nome");
        Set<Serie> seriesTreeSetFour = new TreeSet<>(new ComparatorName());
        seriesTreeSetFour.addAll(seriesTreeSet);
        for (Serie serie : seriesTreeSetFour) {
            System.out.println(serie);
        }
        System.out.println();
    }
}

class Serie implements Comparable<Serie> {

    private String name;
    private String genre;
    private int episodeTime;

    public Serie(String name, String genre, int episodeTime) {
        this.name = name;
        this.genre = genre;
        this.episodeTime = episodeTime;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getEpisodeTime() {
        return episodeTime;
    }

    @Override
    public String toString() {
        return "{" +
                "Nome = '" + name + '\'' +
                " - Gênero = '" + genre + '\'' +
                " - Tempo de Episódio = " + episodeTime +
                '}';
    }

    //Verificação para as comparações
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie series = (Serie) o;
        return episodeTime == series.episodeTime && name.equals(series.name) && genre.equals(series.genre);
    }

    //Utilizado para comparações
    @Override
    public int hashCode() {
        return Objects.hash(name, genre, episodeTime);
    }

    @Override
    public int compareTo(Serie serie) {
        int episodeTime = Integer.compare(this.getEpisodeTime(), serie.getEpisodeTime());
        if (episodeTime != 0) {
            return episodeTime;
        }
        return this.getGenre().compareTo(serie.getGenre());
    }
    // Retorno = 0. Os objetos comparados tem nomes iguais;
    // Retorno = 1. Os objetos comparados tem nomes diferentes, mas um sendo maior que o outro;
    // Retorno = -1. Os objetos comparados tem nomes diferente, mas um sendo menor que outro;
}

class ComparatorNameGenreEpisodeTime implements Comparator<Serie> {

    @Override
    public int compare(Serie serieOne, Serie serieTwo) {

        int compareSerieName = serieOne.getName().compareTo(serieTwo.getName());
        if (compareSerieName != 0) {
            return compareSerieName;
        }
        int compareSerieGenre = serieOne.getGenre().compareTo(serieTwo.getGenre());
        if (compareSerieGenre != 0) {
            return compareSerieGenre;
        }
        return Integer.compare(serieOne.getEpisodeTime(), serieTwo.getEpisodeTime());
    }
}

class ComparatorGenre implements Comparator<Serie> {

    @Override
    public int compare(Serie serieOne, Serie serieTwo) {
        return serieOne.getGenre().compareTo(serieTwo.getGenre());
    }
}

class ComparatorName implements Comparator<Serie> {

    @Override
    public int compare(Serie serieOne, Serie serieTwo) {
        return serieOne.getName().compareTo(serieTwo.getName());
    }
}
