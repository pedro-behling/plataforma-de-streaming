package br.com.alura.pedroflix.template;

import br.com.alura.pedroflix.exceptions.YearConversionError;

public class Title implements Comparable<Title> {
    private String titleName;
    private int releaseYear;
    private int duration;
    private boolean planInclused;
    private double sumOfRatings;
    private int totalReview;

    public Title(String titleName, int releaseYear) {
        this.titleName = titleName;
        this.releaseYear = releaseYear;
    }

    public Title(TitleOmdb myTitleOmdb) {
        this.titleName = myTitleOmdb.title();
        if (myTitleOmdb.year().length() > 4) {
            throw new YearConversionError("Não foi possível converter o ano do título requisitado pois o mesmo contém mais que 4 caracteres");
        }
        this.releaseYear = Integer.valueOf(myTitleOmdb.year());
        this.duration = Integer.valueOf(myTitleOmdb.runtime().substring(0, 3));
    }

    public void showTechnicalData() {
        System.out.println("Nome do título: " + titleName);
        System.out.println("Ano de lançamento: " + releaseYear);
        System.out.println("Duração em minutos: " + duration);
        System.out.println("Incluído no plano: " + planInclused);
        System.out.println("Avaliação: " + averageRating());
    }

    public void setReview(double rating) {
        sumOfRatings += rating;
        totalReview++;
    }

    public double averageRating() {
        return sumOfRatings / totalReview;
    }

    public int getTotalReview() {
        return totalReview;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean getPlanIclused() {
        return this.planInclused;
    }

    public void setPlanInclused(boolean planInclused) {
        this.planInclused = planInclused;
    }

    @Override
    public int compareTo(Title title) {
        return this.getTitleName().compareTo(title.getTitleName());
    }

    @Override
    public String toString() {
        return "(titleName = " + titleName +
                ", releaseYear = " + releaseYear +
                ", duration = " + duration + ")";
    }
}
