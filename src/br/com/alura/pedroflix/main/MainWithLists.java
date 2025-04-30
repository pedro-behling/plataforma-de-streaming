package br.com.alura.pedroflix.main;

import br.com.alura.pedroflix.template.Movie;
import br.com.alura.pedroflix.template.Serie;
import br.com.alura.pedroflix.template.Title;

import java.util.*;

public class MainWithLists {
    public static void main(String[] args) {
        Movie arremessandoAlto = new Movie("Arremessando Alto", 2021);
        arremessandoAlto.setReview(10);
        Movie coachCarter = new Movie("Coach Carter: Um treino para vida", 2005);
        coachCarter.setReview(7);
        Serie strangerThings = new Serie("Stranger Things", 2018);

        List<Title> list = new ArrayList<>();
        list.add(coachCarter);
        list.add(arremessandoAlto);
        list.add(strangerThings);

        for (Title title : list) {
            System.out.println(title);
            if (title instanceof Movie movie && movie.getRating() > 2) {
                System.out.println("Classificação: " + movie.getRating());
            }
        }

        Collections.sort(list);
        System.out.println(list);
        list.sort(Comparator.comparing(Title::getReleaseYear));
        System.out.println(list);
    }
}
