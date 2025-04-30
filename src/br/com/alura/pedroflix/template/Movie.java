package br.com.alura.pedroflix.template;

import br.com.alura.pedroflix.calculators.Rated;

public class Movie extends Title implements Rated {
    private String director;

    public Movie(String titleName, int releaseYear) {
        super(titleName, releaseYear);
    }

    public String getDirector() {
        return director;
    }

    public String setDirector(String directorName) {
        return this.director = directorName;
    }

    @Override
    public int getRating() {
        return (int) averageRating() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getTitleName() + "(" + this.getReleaseYear() + ")";
    }
}
