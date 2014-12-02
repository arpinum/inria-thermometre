package fr.inria.thermomax.domain;

public class ThermometerStub implements Thermometer {

    @Override
    public void addListener(ThermometerListener listener) {
        this.listener = listener;
    }

    public ThermometerListener listener;
}
