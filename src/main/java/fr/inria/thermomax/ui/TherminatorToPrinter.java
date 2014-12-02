package fr.inria.thermomax.ui;

import fr.inria.thermomax.domain.Therminator;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TherminatorToPrinter {

    public TherminatorToPrinter(Therminator therminator, Printer printer) {
        this.therminator = therminator;
        this.printer = printer;
    }

    public void start(ScheduledExecutorService executor) {
        executor.scheduleAtFixedRate(this::updateDisplay, 0, 5, TimeUnit.SECONDS);
    }

    private void updateDisplay() {
        printer.print(String.valueOf(therminator.maxTemperature()));
    }


    private final Therminator therminator;
    private final Printer printer;
}
