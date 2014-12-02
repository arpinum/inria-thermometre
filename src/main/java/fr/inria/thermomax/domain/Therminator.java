package fr.inria.thermomax.domain;

public class Therminator {

    public Therminator(Thermometer thermometer) {
        thermometer.addListener(this::notify);
    }

    public double maxTemperature() {
        return maxTemperature;
    }

    private void notify(double temperature) {
        if (temperature > maxTemperature) {
            maxTemperature = temperature;
        }
    }

    private double maxTemperature;
}
