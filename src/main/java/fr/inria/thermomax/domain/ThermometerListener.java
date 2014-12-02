package fr.inria.thermomax.domain;

@FunctionalInterface
public interface ThermometerListener {

    void notify(double temperature);
}
