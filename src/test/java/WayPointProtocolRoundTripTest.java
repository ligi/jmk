import org.junit.Test;
import org.ligi.androidhelper.test.TestSeeds;
import org.ligi.ufo.MKHelper;
import org.ligi.ufo.WayPoint;
import static org.junit.Assert.assertTrue;

public class WayPointProtocolRoundTripTest {

    @Test
    public void WayPointsShouldBeTheSameAfterRoundTrip() {
        WayPoint pnt= TestSeeds.WAYPOINT3();
        for (int i=-100;i<100;i++) {
            pnt.setHeading(i);
            WayPoint trippedPnt=new WayPoint(MKHelper.byte2intarr(pnt.toByteArray()),0);
            assertTrue("Waypoints are not equal", trippedPnt.equals(pnt));

        }

    }

}
