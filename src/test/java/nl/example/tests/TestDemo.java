package nl.example.tests;

import nl.example.Demo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestDemo {
    @Test
    void testParser() {
        Demo demo = new Demo();
        assertNotNull(demo);
    }
}
