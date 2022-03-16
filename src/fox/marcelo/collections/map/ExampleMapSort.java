package fox.marcelo.collections.map;

import java.util.*;

public class ExampleMapSort {
    public static void main(String[] args) {

        /*
         * Com as seguintes informações sobre livros favoritos e seus autores, crie um
         * dicionário e ordene ele:
         * Exibindo (Nome Autor - Nome Livro)
         *
         * - Autor = Hawking, Stephen - Livro: Nome = Uma breve história do tempo, Pág: 256;
         * - Autor = Duhigg, Charles - Livro: Nome = O poder do hábito, Pág: 408;
         * - Autor = Harari, Yuval Noah Livro: Nome = 21 Lições para o Século 21, Pág: 432;
         * */

        System.out.println("Ordem Aleatória:");
        Map<String, Book> favoriteBooksHashMap = new HashMap<>() {{
            put("Hawking, Stephen", new Book("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Book("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Book("21 Lições para o Século 21", 432));
        }};
        for (Map.Entry<String, Book> book : favoriteBooksHashMap.entrySet()) {
            System.out.println(book.getKey() + " - " + book.getValue().getName());
        }
        System.out.println();

        System.out.println("Ordem de Inserção:");
        Map<String, Book> favoriteBooksLinkedHashMap = new LinkedHashMap<>() {{
            put("Hawking, Stephen", new Book("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Book("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Book("21 Lições para o Século 21", 432));
        }};
        for (Map.Entry<String, Book> book : favoriteBooksLinkedHashMap.entrySet()) {
            System.out.println(book.getKey() + " - " + book.getValue().getName());
        }
        System.out.println();

        System.out.println("Ordem Alfabética - Autores");
        Map<String, Book> favoriteBooksTreeMap = new TreeMap<>() {{
            put("Hawking, Stephen", new Book("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Book("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Book("21 Lições para o Século 21", 432));
        }};
        for (Map.Entry<String, Book> book : favoriteBooksTreeMap.entrySet()) {
            System.out.println(book.getKey() + " - " + book.getValue().getName());
        }
        System.out.println();

        System.out.println("Ordem Alfabética - Nome do Livro");
        Set<Map.Entry<String, Book>> favoriteBooksTreeSet = new TreeSet<>(new ComparatorBookName());
        favoriteBooksTreeSet.addAll(favoriteBooksTreeMap.entrySet());
        for (Map.Entry<String, Book> book : favoriteBooksTreeSet) {
            System.out.println(book.getValue().getName());
        }
        System.out.println();

        System.out.println("Ordem - Número de Páginas");
        Set<Map.Entry<String, Book>> favoriteBookTreeSetTwo = new TreeSet<>(new ComparatorPagesBook());
        favoriteBookTreeSetTwo.addAll(favoriteBooksHashMap.entrySet());
        for (Map.Entry<String, Book> book : favoriteBookTreeSetTwo) {
            System.out.println(book.getValue().getPages() + " Páginas" +" - " + book.getValue().getName());
        }
    }
}

class Book {

    private String name;
    private int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "{" +
                "Livro = " + name +
                " - Pág = " + pages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book that = (Book) o;
        return pages == that.pages && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pages);
    }
}

class ComparatorBookName implements Comparator<Map.Entry<String, Book>> {

    @Override
    public int compare(Map.Entry<String, Book> bookOne, Map.Entry<String, Book> bookTwo) {
        return bookOne.getValue().getName().compareTo(bookTwo.getValue().getName());
    }
}

class ComparatorPagesBook implements Comparator<Map.Entry<String, Book>> {

    @Override
    public int compare(Map.Entry<String, Book> bookOne, Map.Entry<String, Book> bookTwo) {
        return Integer.compare(bookOne.getValue().getPages(), bookTwo.getValue().getPages());
    }
}
