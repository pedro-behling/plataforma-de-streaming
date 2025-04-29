import br.com.alura.pedroflix.calculators.RecomendationFilter;
import br.com.alura.pedroflix.calculators.TimeCalculator;
import br.com.alura.pedroflix.template.Episodes;
import br.com.alura.pedroflix.template.Movie;
import br.com.alura.pedroflix.template.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie arremessandoAlto = new Movie("Arremessando Alto", 2021);
        Serie strangerThings = new Serie("Stranger Things", 2018);
        TimeCalculator calculator = new TimeCalculator();
        Episodes first = new Episodes("Primeiro episódio", 2018);
        RecomendationFilter filter = new RecomendationFilter();
        ArrayList<Movie> movies = new ArrayList<>();

        arremessandoAlto.setDuration(180);
        arremessandoAlto.setPlanInclused(true);

        arremessandoAlto.setReview(7);
        arremessandoAlto.setReview(8);
        arremessandoAlto.setReview(5);
        arremessandoAlto.showTechnicalData();

        System.out.println("A média de avaliações: " + arremessandoAlto.averageRating());

        strangerThings.showTechnicalData();
        strangerThings.setSeasons(4);
        strangerThings.setSeasonEpisodes(12);
        strangerThings.setEpisodeDuration(50);
        System.out.println("Duração da Série: " + strangerThings.getDuration());

        calculator.include(arremessandoAlto);
        calculator.include(strangerThings);
        System.out.println(calculator.getTotalTime());

        first.setNumberOfEpisodes(1);
        first.setSerie(strangerThings);
        first.setViews(300);

        filter.filter(arremessandoAlto);
        filter.filter(first);

        movies.add(arremessandoAlto);
        System.out.println(movies.get(0).getTitleName());
        System.out.println(movies);
    }
}
