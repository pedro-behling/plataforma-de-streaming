package br.com.alura.pedroflix.template;

public class Serie extends Title {
    private int seasons;
    private int seasonEpisodes;
    private boolean active;
    private int episodeDuration;

    public Serie(String titleName, int releaseYear) {
        super(titleName, releaseYear);
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getSeasonEpisodes() {
        return seasonEpisodes;
    }

    public void setSeasonEpisodes(int seasonEpisodes) {
        this.seasonEpisodes = seasonEpisodes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodeDuration() {
        return episodeDuration;
    }

    public void setEpisodeDuration(int episodeDuration) {
        this.episodeDuration = episodeDuration;
    }

    @Override
    public int getDuration() {
        return seasons * (seasonEpisodes * episodeDuration);
    }

    @Override
    public String toString() {
        return "Série: " + this.getTitleName() + "(" + this.getReleaseYear() + ")";
    }
}
