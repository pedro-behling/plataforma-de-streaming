package br.com.alura.pedroflix.template;

import com.google.gson.annotations.SerializedName;

public class Title implements Comparable<Title> {
    @SerializedName("Title")
    private String titleName;
    @SerializedName("Year")
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
        return "titleName='" + titleName + '\'' +
                ", releaseYear=" + releaseYear + '\'' +
                ", duration=" + duration;
    }
}
