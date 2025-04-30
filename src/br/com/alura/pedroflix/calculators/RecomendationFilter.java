package br.com.alura.pedroflix.calculators;

public class RecomendationFilter {

    public void filter(Rated rated) {
        if (rated.getRating() >= 4) {
            System.out.println("Está entre os preferidos no momento!");
        } else if (rated.getRating() >= 2) {
            System.out.println("Muito bem avaliado no momento");
        } else {
            System.out.println("Coloque na sua lista para assistir depois");
        }
    }
}
