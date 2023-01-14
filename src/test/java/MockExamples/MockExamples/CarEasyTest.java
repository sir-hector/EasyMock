package MockExamples.MockExamples;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;


public class CarEasyTest {
    private Car myFerrari = EasyMock.createMock(Car.class);

    @Test
    public void test_instance_car(){
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    public void test_default_behavior_needsFuel(){
        assertFalse(myFerrari.needsFuel(), "New test double should return False as boolean");
    }

    @Test
    public void test_default_behavior_temperature(){
        assertEquals(0.0, myFerrari.getEngineTemperature(), "New test double should return 0.0");
    }

    @Test
    public void test_stubbing_mock(){
        EasyMock.expect(myFerrari.needsFuel()).andReturn(true);
        EasyMock.replay(myFerrari);
        assertTrue(myFerrari.needsFuel());

    }

    @Test
    public void test_exception(){
        EasyMock.expect(myFerrari.needsFuel()).andThrow(new RuntimeException());
        EasyMock.replay(myFerrari);
        assertThrows(RuntimeException.class, () -> {
            myFerrari.needsFuel();
        });
    }

    // MY TESTS



    @Test
    public void testNeedsFuel() {
        EasyMock.expect(myFerrari.needsFuel()).andReturn(false);
        EasyMock.replay(myFerrari);
        assertFalse(myFerrari.needsFuel());
        EasyMock.verify(myFerrari);
    }

    @Test
    public void testGetEngineTemperature() {
        EasyMock.expect(myFerrari.getEngineTemperature()).andReturn(90.0);
        EasyMock.replay(myFerrari);
        assertEquals(90.0, myFerrari.getEngineTemperature(), 0.001);
        EasyMock.verify(myFerrari);
    }

    @Test
    public void testDriveTo() {
        myFerrari.driveTo("New York");
        EasyMock.expectLastCall();
        EasyMock.replay(myFerrari);
        myFerrari.driveTo("New York");
        EasyMock.verify(myFerrari);
    }

    @Test
    public void testEngineTemperatureWithException(){
        EasyMock.expect(myFerrari.getEngineTemperature()).andThrow(new RuntimeException());
        EasyMock.replay(myFerrari);
        assertThrows(RuntimeException.class, () -> {
            myFerrari.getEngineTemperature();
        });
    }

}
