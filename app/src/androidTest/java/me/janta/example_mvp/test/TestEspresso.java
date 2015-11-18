package me.janta.example_mvp.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;

import me.janta.example_mvp.MainActivity;
import me.janta.example_mvp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Jorge on 16/11/15.
 */
public class TestEspresso extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public TestEspresso() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        this.mActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testLoadViewElements() {
        onView(withId(R.id.fab)).check(matches(isDisplayed()));
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
        onView(withId(R.id.listElements)).check(matches(isDisplayed()));

    }

    public void testOneElementInRecyclerView() {
        onView(withId(R.id.listElements)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(allOf(withId(R.id.text_name), withText("Element 0"))).check(matches(withText("Element 0")));
        onView(allOf(withId(R.id.text_description), withText("0"))).check(matches(withText("0")));
    }

    public void testNewElement() {
        onView(withId(R.id.fab)).perform(click());
        onView(allOf(withId(R.id.text_name), withText("Name"))).check(matches(withText("Name")));
        onView(allOf(withId(R.id.text_description), withText("Description"))).check(matches(withText("Description")));
    }


}
