package org.ligi.ufo;

public class MKWayPointPool {

    private int count = 0;
    private WayPoint[] waypoints;

    public MKWayPointPool() {
        waypoints = new WayPoint[32];
    }

    public void setWayPoint(int index, WayPoint wp) {
        waypoints[index] = wp;
    }

    public WayPoint getWayPoint(int index) {
        return waypoints[index];
    }

    public WayPoint[] getWayPoints() {
        return waypoints;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
