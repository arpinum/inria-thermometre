package fr.inria.thermomax.domain;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TherminatorTest {

    @Before
    public void setUp(){
        thermometer = new ThermometerStub();
        therminator = new Therminator(thermometer);
    }

    @Test
    public void given_the_temperature_is_20_the_max_temperature_is_20() {
        thermometer.listener.notify(20);

        assertThat(therminator.maxTemperature()).isEqualTo(20);
    }

    @Test
    public void given_the_temperature_is_21_the_max_temperature_is_21() {
        thermometer.listener.notify(21);

        assertThat(therminator.maxTemperature()).isEqualTo(21);
    }

    @Test
    public void given_a_sequence_of_temperatures_gives_the_highest_one() {
        thermometer.listener.notify(21);
        thermometer.listener.notify(16);

        assertThat(therminator.maxTemperature()).isEqualTo(21);
    }

    private Therminator therminator;
    private ThermometerStub thermometer;
}
