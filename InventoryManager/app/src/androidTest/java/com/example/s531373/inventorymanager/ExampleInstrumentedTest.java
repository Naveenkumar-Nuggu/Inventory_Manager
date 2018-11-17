package com.example.s531373.inventorymanager;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.s531373.inventorymanager", appContext.getPackageName());
    }
}
