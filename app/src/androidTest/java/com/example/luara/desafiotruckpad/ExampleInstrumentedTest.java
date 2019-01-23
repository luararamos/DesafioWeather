package com.example.luara.desafiotruckpad;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.luara.desafiobrunoapplication", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<SplashActivity> activityActivityTestRule = new ActivityTestRule<SplashActivity>(SplashActivity.class);

    @Before
    public void init(){
        activityActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }
}
