package org.ligi.androidhelper.test;


import org.ligi.ufo.WayPoint;

public class TestSeeds {

    public static WayPoint WAYPOINT1() {
        WayPoint wayPoint = new WayPoint(42, 23);
        wayPoint.setHeading(-10);
        wayPoint.setSpeed(11);
        wayPoint.setAltitude(1000);
        wayPoint.setName("Foo");
        return wayPoint;
    }

    public static WayPoint WAYPOINT2() {
        WayPoint wayPoint = new WayPoint(42, 23);
        wayPoint.setHeading(0);
        wayPoint.setSpeed(11);
        wayPoint.setAltitude(1000);
        wayPoint.setName("Bar");
        return wayPoint;
    }

    public static WayPoint WAYPOINT3() {
        WayPoint wayPoint = new WayPoint(42, 23);
        wayPoint.setHeading(-3);
        wayPoint.setSpeed(11);
        wayPoint.setAltitude(1000);
        wayPoint.setName("Baz");
        return wayPoint;
    }
}
