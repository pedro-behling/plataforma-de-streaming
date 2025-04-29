public class Movie {
    String movieName;
    int releaseYear;
    int duration;
    boolean planInclused;
    private double sumOfRatings;
    private int totalReview;

    int getTotalReview() {
        return totalReview;
    }

    void showTechnicalData() {
        System.out.println("Nome do filme: " + movieName);
        System.out.println("Ano de lançamento: " + releaseYear);
    }

    void setReview(double rating) {
        sumOfRatings += rating;
        totalReview++;
    }

    double averageRating() {
        return sumOfRatings / totalReview;
    }
}
