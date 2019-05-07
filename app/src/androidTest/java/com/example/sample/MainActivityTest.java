package com.example.sample;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Random;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private final String[] firstNames = new String[]{"John Oliver", "Henry", "Donn", "Jaylord", "Claire", "Katrina", "Cleo", "Mary", "Joy", "Eloisa"};
    private final String[] lastNames = new String[]{"Rubi", "Jaim", "Roman", "Oguan", "Rodriguez", "Sarmiento", "Dela Cruz", "Makiling", "Batungbakal", "Dimatiba"};
    private Random rand;

    @Rule public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setup(){
       rand = new Random();
    }


    @Test
    public void setNames() {


        String firstName = firstNames[rand.nextInt(10)];
        String lastName = lastNames[rand.nextInt(10)];
        String fullName = firstName + " " + lastName;

        onView(withId(R.id.firstNameField))
                .perform(typeText(firstName), closeSoftKeyboard());

        onView(withId(R.id.lastNameField))
                .perform(typeText(lastName), closeSoftKeyboard());

        onView(withId(R.id.submitBtn)).perform(click());

        onView(withId(R.id.fullNameTextView)).check(matches(withText(fullName)));

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}