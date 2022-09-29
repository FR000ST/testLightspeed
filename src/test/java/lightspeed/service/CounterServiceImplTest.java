package lightspeed.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CounterServiceImplTest {

    private CounterService counterService = new CounterServiceImpl();

    @BeforeEach
    void beforeEach() {
        counterService = new CounterServiceImpl();
    }

    @Test
    void create() {
        String counterName = counterService.create();
        assertNotNull(counterName);
    }

    @Test
    void increment() {
        String counterName = counterService.create();
        assertEquals(counterService.increment(counterName), 1);
    }

    @Test
    void get() {
        String counterName = counterService.create();
        assertEquals(counterService.get(counterName), 0);
    }

    @Test
    void delete() {
        String counterName = counterService.create();
        assertTrue(counterService.delete(counterName));
    }

    @Test
    void sum() {
        String counter1Name = counterService.create();
        String counter2Name = counterService.create();
        String counter3Name = counterService.create();
        counterService.increment(counter1Name);
        counterService.increment(counter2Name);
        counterService.increment(counter2Name);
        counterService.increment(counter3Name);
        counterService.increment(counter3Name);
        counterService.increment(counter3Name);
        assertEquals(counterService.sum(), 6);
    }

    @Test
    void nameList() {
        String counter1Name = counterService.create();
        String counter2Name = counterService.create();
        String counter3Name = counterService.create();
        assertEquals(counterService.nameList().size(), 3);
    }
}
