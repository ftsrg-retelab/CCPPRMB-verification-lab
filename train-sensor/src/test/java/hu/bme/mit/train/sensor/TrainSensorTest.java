package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Before
    public void before() {
        // TODO Add initializations
    }

    public void shouldAlarmWhenSpeedLimitIsUnder0(){}

    public void shouldAlarmWhenSpeedLimitIsOver500(){}

    public void shouldAlarmWhenSlowingLargerThan50Percent(){}

    public void shouldNotAlarmWhenSlowingSmallerThan50Percent(){}
}
