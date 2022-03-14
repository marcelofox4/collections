package fox.marcelo.collections.set;

import java.util.*;

public class ExampleSetSort {
    public static void main(String[] args) {

        /*
         * Das as seguintes informações sobre séries, crie um conjunto e ordene este conjunto exibindo:
         * - Nome, Gênero e Tempo de Episódio.
         *
         * Série 01 = Nome: GOT - Gênero: Fantasia - Tempo de Episódio: 60;
         * Série 02 = Nome: Dark - Gênero: Drama - Tempo de Episódio: 60;
         * Série 03 = Nome: That '70 show - Gênero: Comédia - Tempo de Episódio: 25;
         * */

        System.out.println("Ordem Aleatória:");
        Set<Serie> seriesHashSet = new HashSet<>() {{
            add(new Serie("GOT", "Fantasia", 60));
            add(new Serie("Dark", "Drama", 60));
            add(new Serie("That '70 show", "Comédia", 25));
        }};
        for (Serie series : seriesHashSet) {
            System.out.println(series);
        }
        System.out.println();

        System.out.println("Ordem Natural - Tempo de Episódio:");
        Set<Serie> seriesTreeSet = new TreeSet<>(seriesHashSet);
        for (Serie series : seriesTreeSet) {
            System.out.println(series);
        }
        System.out.println();

        System.out.println("Ordem Natural - Nome/Gênero/Tempo de Episódio:");
        Set<Serie> seriesTreeSetTwo = new TreeSet<>(new ComparatorNameGenreEpisodeTime());
        seriesTreeSetTwo.addAll(seriesHashSet);
        for (Serie series : seriesTreeSetTwo) {
            System.out.println(series);
        }
        System.out.println();

        System.out.println("Ordem Natural - Genêro:");
        Set<Serie> seriesTreeSetThree = new TreeSet<>(new ComparatorGenre());
        seriesTreeSetThree.addAll(seriesHashSet);
        for (Serie series : seriesTreeSetThree) {
            System.out.println(series);
        }
        System.out.println();
    }
}

class Serie implements Comparable<Serie> {

    private String Name;
    private String Genre;
    private int episodeTime;

    public Serie(String name, String genre, int episodeTime) {
        Name = name;
        Genre = genre;
        this.episodeTime = episodeTime;
    }

    public String getName() {
        return Name;
    }

    public String getGenre() {
        return Genre;
    }

    public int getEpisodeTime() {
        return episodeTime;
    }

    @Override
    public String toString() {
        return "{" +
                "Nome = " + Name +
                " - Gênero = " + Genre +
                " - Tempo do Episódio = " + episodeTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return episodeTime == serie.episodeTime && Objects.equals(Name, serie.Name) && Objects.equals(Genre, serie.Genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Genre, episodeTime);
    }

    @Override
    public int compareTo(Serie serie) {
        int CompareToEpisodeTime = Integer.compare(this.getEpisodeTime(), serie.getEpisodeTime());
        if (CompareToEpisodeTime != 0) {
            return CompareToEpisodeTime;
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

        int compareToName = serieOne.getName().compareTo(serieTwo.getName());
        if (compareToName != 0) {
            return compareToName;
        }

        int compareToGenre = serieOne.getGenre().compareTo(serieTwo.getGenre());
        if (compareToGenre != 0) {
            return compareToGenre;
        }

        return Integer.compare(serieOne.getEpisodeTime(), serieTwo.getEpisodeTime());
    }
}

class ComparatorGenre implements Comparator<Serie> {

    @Override
    public int compare(Serie serieOne, Serie serieTwo) {
        int compareToGenre = serieOne.getGenre().compareTo(serieTwo.getGenre());
        if (compareToGenre != 0) {
            return compareToGenre;
        }
        return serieOne.getName().compareTo(serieTwo.getName());
    }
}
