import org.junit.Test;
import org.ligi.androidhelper.test.TestSeeds;
import org.ligi.ufo.MKHelper;
import org.ligi.ufo.WayPoint;

import static org.fest.assertions.Fail.fail;
import static org.junit.Assert.assertTrue;

public class TheWayPoint {

    @Test
    public void withNegativeHeadingShouldBeTheSameAfterRoundTrip() {
        WayPoint pnt= TestSeeds.WAYPOINT3();
        pnt.setHeading(-100);
        WayPoint trippedPnt=new WayPoint(MKHelper.byte2intarr(pnt.toByteArray()),0);
        assertTrue("Waypoints are not equal", trippedPnt.equals(pnt));
    }

    @Test
    public void withPositiveHeadingShouldBeTheSameAfterRoundTrip() {
        WayPoint pnt= TestSeeds.WAYPOINT3();
        pnt.setHeading(-0);
        WayPoint trippedPnt=new WayPoint(MKHelper.byte2intarr(pnt.toByteArray()),0);
        assertTrue("Waypoints are not equal", trippedPnt.equals(pnt));
    }

    @Test
    public void withZeroHeadingShouldBeTheSameAfterRoundTrip() {
        WayPoint pnt= TestSeeds.WAYPOINT3();
        pnt.setHeading(0);
        WayPoint trippedPnt=new WayPoint(MKHelper.byte2intarr(pnt.toByteArray()),0);
        assertTrue("Waypoints are not equal", trippedPnt.equals(pnt));
    }


}
