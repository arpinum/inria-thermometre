package fr.inria.thermomax.ui;

import fr.inria.thermomax.ui.Printer;

public class ConsoleMock implements Printer {

    @Override
    public void print(String value) {
        this.output = value;
    }

    public String output;
}
