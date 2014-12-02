package fr.inria.thermomax;

import fr.inria.thermomax.domain.*;
import fr.inria.thermomax.ui.TherminatorToPrinter;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        final Therminator therminator = new Therminator(new MyThermometer());
        new TherminatorToPrinter(therminator, System.out::println).start(Executors.newSingleThreadScheduledExecutor());
    }

    private static class MyThermometer implements Thermometer {


        public MyThermometer() {
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(this::random, 0, 5, TimeUnit.SECONDS);
        }

        private void random() {
            if(listener!= null) {
                listener.notify(Math.random()*10);
            }
        }

        @Override
        public void addListener(ThermometerListener listener) {
            this.listener = listener;
        }

        private ThermometerListener listener;
    }
}
