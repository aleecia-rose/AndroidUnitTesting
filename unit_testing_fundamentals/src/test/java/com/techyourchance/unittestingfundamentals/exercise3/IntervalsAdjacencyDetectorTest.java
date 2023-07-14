package com.techyourchance.unittestingfundamentals.exercise3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.techyourchance.unittestingfundamentals.example3.Interval;

import org.junit.Before;
import org.junit.Test;

public class IntervalsAdjacencyDetectorTest {

    IntervalsAdjacencyDetector SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new IntervalsAdjacencyDetector();
    }

    //interval1 ends at beginning of interval2 (adjacent)

    @Test
    public void isAdjacent_interval1AdjacentBeforeInterval2_trueReturned() {
        Interval interval1 = new Interval(-1, 5);
        Interval interval2 = new Interval(5, 8);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(true));
    }

    //interval1 starts at end of interval2 (adjacent)
    @Test
    public void isAdjacent_interval1AdjacentAfterInterval2_trueReturned() {
        Interval interval1 = new Interval(-1, 5);
        Interval interval2 = new Interval(-3, -1);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(true));
    }
    //interval1 is before interval2
    @Test
    public void isAdjacent_interval1BeforeInterval2_falseReturned() {
        Interval interval1 = new Interval(-1, 5);
        Interval interval2 = new Interval(8, 12);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
    //interval1 is after interval2
    @Test
    public void isAdjacent_interval1AfterInterval2_falseReturned() {
        Interval interval1 = new Interval(-1, 5);
        Interval interval2 = new Interval(-10, -3);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
    //interval1 overlaps beginning of interval2
    @Test
    public void isAdjacent_interval1OverlapsInterval2OnStart_falseReturned() {
        Interval interval1 = new Interval(-1, 5);
        Interval interval2 = new Interval(3, 12);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
    //interval1 overlaps end of interval2
    @Test
    public void isAdjacent_interval1OverlapsInterval2OnEnd_falseReturned() {
        Interval interval1 = new Interval(-1, 5);
        Interval interval2 = new Interval(-4, 4);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
    //interval1 contains interval2
    @Test
    public void isAdjacent_interval1ContainsInterval2_falseReturned() {
        Interval interval1 = new Interval(-1, 5);
        Interval interval2 = new Interval(0, 3);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
    //interval1 is contained within interval2
    @Test
    public void isAdjacent_interval1ContainedWithinInterval2_falseReturned() {
        Interval interval1 = new Interval(-1, 5);
        Interval interval2 = new Interval(-4, 12);
        boolean result = SUT.isAdjacent(interval1, interval2);
        assertThat(result, is(false));
    }
}