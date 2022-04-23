package com.tau.drawersampleapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DrawerActivityPracticeTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void givenUserTapsOnDrawer_ThenDrawerOpensWithRequiredControls() {
        // Open drawer and check its opened
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open()).check(matches(isOpen()));

        // Close drawer and check we are on the home fragment
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.close()).check(matches(isClosed()));
    }

    @Test
    public void givenUserOpensDrawerAndTapsOnGallery_ThenGalleryFragmentIsOpened() {
        // Open drawer and check its opened
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open()).check(matches(isOpen()));

        // Click on gallery
        onView(withText("Gallery")).perform(click());

        // Verify Gallery fragment is shown on the screen
        onView(withId(R.id.text_gallery)).check(matches(isDisplayed()));
    }
}
