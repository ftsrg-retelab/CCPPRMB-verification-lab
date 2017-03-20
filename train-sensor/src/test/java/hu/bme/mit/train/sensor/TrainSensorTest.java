package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    @Mock
    private TrainController controller;
    @Mock
    private TrainUser user;

    TrainSensor trainSensor;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
        trainSensor = new TrainSensorImpl(controller, user);
    }

    @Test
    public void shouldAlarmWhenSpeedLimitIsUnder0(){
        when(controller.getReferenceSpeed()).thenReturn(0);
        trainSensor.overrideSpeedLimit(-1);

        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void shouldAlarmWhenSpeedLimitIsOver500(){
        when(controller.getReferenceSpeed()).thenReturn(300);
        trainSensor.overrideSpeedLimit(501);

        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void shouldAlarmWhenSlowingLargerThan50Percent(){
        when(controller.getReferenceSpeed()).thenReturn(150);
        trainSensor.overrideSpeedLimit(50);

        verify(user, times(1)).setAlarmState(true);
    }

    @Test
    public void shouldNotAlarmWhenSlowingSmallerThan50Percent(){
        when(controller.getReferenceSpeed()).thenReturn(150);
        trainSensor.overrideSpeedLimit(100);

        verify(user, times(0)).setAlarmState(true);
    }
}
