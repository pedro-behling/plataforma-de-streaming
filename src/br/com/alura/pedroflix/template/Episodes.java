package br.com.alura.pedroflix.template;

import br.com.alura.pedroflix.calculators.Rated;

public class Episodes extends Serie implements Rated {
    private int numberOfEpisodes;
    private String episodesName;
    private Serie serie;
    private int views;

    public Episodes(String titleName, int releaseYear) {
        super(titleName, releaseYear);
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public String getEpisodesName() {
        return episodesName;
    }

    public void setEpisodesName(String episodesName) {
        this.episodesName = episodesName;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getRating() {
        if (views > 100) {
            return 4;
        } else {
            return 2;
        }
    }
}
