package fr.inria.thermomax.ui;

import fr.inria.thermomax.domain.Therminator;
import fr.inria.thermomax.domain.ThermometerStub;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

public class TherminatorToPrinterTest {

    @Before
    public void setUp() throws Exception {
        executor = new FakeExecutor();
        printerMock = mock(Printer.class);
    }

    @Test
    public void given_max_value_is_20_prints_20() {
        Therminator therminator = aTherminatorThatReturns(20);

        createPrinter(therminator);

        verify(printerMock).print("20.0");
    }

    @Test
    public void given_max_value_is_21_prints_21() {
        Therminator therminator = aTherminatorThatReturns(21);

        createPrinter(therminator);

        verify(printerMock).print("21.0");
    }

    @Test
     public void given_max_value_after_refresh_prints_max_value(){
        final ThermometerStub thermometerStub = new ThermometerStub();
        Therminator therminator = new Therminator(thermometerStub);
        thermometerStub.listener.notify((double) 21);

        createPrinter(therminator);
        thermometerStub.listener.notify(22);
        reset(printerMock);
        executor.timeElapsed(5, TimeUnit.SECONDS);

        verify(printerMock).print("22.0");
    }


    private void createPrinter(Therminator therminator) {
        final TherminatorToPrinter therminatorToPrinter = new TherminatorToPrinter(therminator, printerMock);
        therminatorToPrinter.start(executor);

    }

    private Therminator aTherminatorThatReturns(double temperature) {
        final ThermometerStub thermometerStub = new ThermometerStub();
        Therminator therminator = new Therminator(thermometerStub);
        thermometerStub.listener.notify(temperature);
        return therminator;
    }

    private FakeExecutor executor;
    private Printer printerMock;
}