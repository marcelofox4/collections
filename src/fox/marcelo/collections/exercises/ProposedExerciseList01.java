package fox.marcelo.collections.exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProposedExerciseList01 {
    public static void main(String[] args) {

        /*
         * Faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as
         * em uma Lista.
         *
         * Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima
         * desta média, e em que mês ocorreram (mostra o mês por extenso: 1 - Janaeiro, 2 - Fevereiro e etc).
         * */

        List<TemperatureMonth> biannualTemperature = new ArrayList<>() {{
            add(new TemperatureMonth("Janeiro", 40));
            add(new TemperatureMonth("Fevereiro", 32));
            add(new TemperatureMonth("Março", 36.1));
            add(new TemperatureMonth("Abril", 21.2));
            add(new TemperatureMonth("Maio", 20));
            add(new TemperatureMonth("Junho", 20.5));
        }};

        System.out.println("Primeiro Semestre do Ano:");
        System.out.println(biannualTemperature);

        Iterator<TemperatureMonth> iterator = biannualTemperature.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            double next = iterator.next().getTemperature();
            sum += next;
        }
        double temperatureAverage = sum / biannualTemperature.size();

        System.out.println("----------------------------------------------------------------");

        System.out.println("Meses onde a temperatura foi maior que a média semestral de " + temperatureAverage + "C°");
        for (int i = 0; i < biannualTemperature.size(); i++) {
            if (biannualTemperature.get(i).getTemperature() > temperatureAverage) {
                System.out.println(biannualTemperature.get(i));
            }
        }
    }
}

class TemperatureMonth {

    private String MonthName;
    private double temperature;

    public TemperatureMonth(String monthName, double temperature) {
        MonthName = monthName;
        this.temperature = temperature;
    }

    public String getMonthName() {
        return MonthName;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return MonthName + " - " + temperature + "C°";
    }
}
