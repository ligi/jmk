import org.junit.Test;
import org.ligi.androidhelper.test.TestSeeds;
import org.ligi.ufo.MKHelper;
import org.ligi.ufo.WayPoint;

import static org.fest.assertions.Fail.fail;
import static org.junit.Assert.assertTrue;

public class WayPointProtocolRoundTripTest {

    @Test
    public void WayPointWIthNegativeHeadingShouldBeTheSameAfterRoundTrip() {
        WayPoint pnt= TestSeeds.WAYPOINT3();
        pnt.setHeading(-100);
        WayPoint trippedPnt=new WayPoint(MKHelper.byte2intarr(pnt.toByteArray()),0);
        assertTrue("Waypoints are not equal", trippedPnt.equals(pnt));
    }

    @Test
    public void WayPointWIthPositiveHeadingShouldBeTheSameAfterRoundTrip() {
        WayPoint pnt= TestSeeds.WAYPOINT3();
        pnt.setHeading(-0);
        WayPoint trippedPnt=new WayPoint(MKHelper.byte2intarr(pnt.toByteArray()),0);
        assertTrue("Waypoints are not equal", trippedPnt.equals(pnt));
    }

    @Test
    public void WayPointWIthZeroHeadingShouldBeTheSameAfterRoundTrip() {
        WayPoint pnt= TestSeeds.WAYPOINT3();
        pnt.setHeading(0);
        WayPoint trippedPnt=new WayPoint(MKHelper.byte2intarr(pnt.toByteArray()),0);
        assertTrue("Waypoints are not equal", trippedPnt.equals(pnt));
    }


}
