package com.udacity.jinal.buildbigger.app;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest implements EndpointsAsyncTask.EndpoinrResponseInterface{
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    private final CountDownLatch mSignal = new CountDownLatch(1);

    @Test
    public void testJokeRetriever() {
        new EndpointsAsyncTask(this ).execute();
        try {
            boolean success = mSignal.await(5, TimeUnit.SECONDS);
            if (!success) {
                fail("Test timed out, make sure the server is actually running.");
            }
        } catch (InterruptedException e) {
            fail();
        }
    }

    @Override
    public void onResponse(boolean isSuccess, String result) {
        assertTrue(isSuccess && result != null && result.length() > 0);
        mSignal.countDown();
    }
}