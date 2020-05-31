package com.g19.breakout.model;

import com.g19.breakout.model.utilities.Dimensions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackgroundModelTests {
    @Test
    public void testGenerateParticles() {
        BackgroundModel backgroundModel = new BackgroundModel(new Dimensions(100, 100));

        backgroundModel.generateParticles();
        assertEquals(100, backgroundModel.getParticles().size());
    }
}
