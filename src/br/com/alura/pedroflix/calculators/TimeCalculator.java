package br.com.alura.pedroflix.calculators;

import br.com.alura.pedroflix.template.Title;

public class TimeCalculator {
    private int totalTime;

    public int getTotalTime() {
        return totalTime;
    }

    public void include(Title title) {
        this.totalTime += title.getDuration();
    }
}
