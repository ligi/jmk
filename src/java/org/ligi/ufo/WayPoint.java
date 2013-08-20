/*********************************************
 *
 * License:
 *  http://creativecommons.org/licenses/by-nc-sa/2.0/de/ 
 *  (Creative Commons / Non Commercial / Share Alike)
 *  Additionally to the Creative Commons terms it is not allowed
 *  to use this project in _any_ violent manner! 
 *  This explicitly includes that lethal Weapon owning "People" and 
 *  Organisations (e.g. Army & Police) 
 *  are not allowed to use this Project!
 *
 ********************************************/

package org.ligi.ufo;

/**
 * class to describe a MikroKopter WayPoint
 *
 * @author ligi ( aka: Marcus Bueschleb | mail: ligi at ligi dot de )
 */
public class WayPoint extends MKPosition {

    public final static int STATUS_INVALID = 0;
    public final static int STATUS_NEWDATA = 1;
    public final static int STATUS_PROCESSED = 2;

    public final static int TYPE_WAYPOINT = 0;
    public final static int TYPE_POI = 1;
    public final static int TYPE_LAND = 2;
    public final static int TYPE_EMERGENCYLAND = 3;
    public final static int TYPE_INVALID = 255;

    /**
     * time the MK should hold the position in seconds *
     */
    private int hold_time = 3;


    /**
     * the radius aound the waypoint in meters in which the point is seen as reached *
     */
    private int tolerance_radius = 5;

    private int index;                // to indentify different waypoints, workaround for bad communications PC <-> NC
    private int altitude;
    private int status;
    private int heading;            // orientation, 0 no action, 1...360 fix heading, neg. = Index to POI in WP List
    private int event_flag;            // future implementation
    private int type = TYPE_WAYPOINT;    // typeof Waypoint
    private int event_channel_value;
    private int altitude_rate;        // rate to change the setpoint
    private int speed;                // rate to change the Position
    private int cam_angle;            // Camera nick servo angle
    private String name = "";               // 4 chars

    public WayPoint(int lat, int lon) {
        this.setLat(lat);
        this.setLon(lon);
    }

    public WayPoint(int[] data, int offset) {

        this(MKHelper.parse_arr_4(offset + 4, data), MKHelper.parse_arr_4(offset, data));

        setAltitude(MKHelper.parse_arr_4(offset + 8, data) / 10);

        setStatus((byte) data[offset + 12]);

        setHeading(MKHelper.parse_signed_arr_2(offset + 13, data));

        setToleranceRadius((byte) data[offset + 15]);

        setHoldTime((byte) data[offset + 16]);

        setEventFlag((byte) data[offset + 17]);

        setIndex((byte) data[offset + 18]);

        setType((byte) data[offset + 19]);

        setEventChannelValue((byte) data[offset + 20]);

        setAltitudeRate((byte) data[offset + 21]);

        setSpeed((byte) data[offset + 22]);

        setCamAngle((byte) data[offset + 23]);

        setName(MKHelper.parse_string(offset + 24, 4, data));

    }

    public int getHoldTime() {
        return hold_time;
    }

    public void setHoldTime(int t) {
        hold_time = t;
    }

    public void setToleranceRadius(int tolerance_radius) {
        this.tolerance_radius = tolerance_radius;
    }

    public int getToleranceRadius() {
        return tolerance_radius;
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getEventFlag() {
        return event_flag;
    }

    public void setEventFlag(int event_flag) {
        this.event_flag = event_flag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEventChannelValue() {
        return event_channel_value;
    }

    public void setEventChannelValue(int event_channel_value) {
        this.event_channel_value = event_channel_value;
    }

    public int getAltitudeRate() {
        return altitude_rate;
    }

    public void setAltitudeRate(int altitude_rate) {
        this.altitude_rate = altitude_rate;
    }

    public int getCamAngle() {
        return cam_angle;
    }

    public void setCamAngle(int cam_angle) {
        this.cam_angle = cam_angle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        //android.R.drawable.ic_menu_close_clear_cancel
    }

    public String toHumanString() {
        return "" + getIndex() + " " + getName() + " @ " + getLon() + ":" + getLat()
                + " heading:" + getHeading()
                + " cam_angle:" + getCamAngle()
                + " alt:" + getAltitude()
                + " radius:" + getToleranceRadius()
                + " speed:" + getSpeed()
                + " time:" + getHoldTime()
                + " chan_event:" + getEventChannelValue()
                + " type:" + getType();
    }

    public byte[] toByteArray() {
        byte[] res = new byte[30];


        MKHelper.int32ToByteArr(getLon(), res, 0);
        MKHelper.int32ToByteArr(getLat(), res, 4);

        // alt
        MKHelper.int32ToByteArr(getAltitude() * 10, res, 8); // todo check why

        // status
        res[12] = (byte) ((0xFF) & (status));

        // heading
        MKHelper.int16ToByteArr(getHeading(), res, 13);

        // tolerance
        res[15] = (byte) ((0xFF) & (getToleranceRadius()));

        // holdtime
        res[16] = (byte) ((0xFF) & (getHoldTime()));

        // event flag
        res[17] = (byte) ((0xFF) & (0));

        //index
        res[18] = (byte) ((0xFF) & (index));

        //type 19
        //res[19]= (byte)(0);
        res[19] = (byte) ((0xFF) & (getType()));

        // channel event
        res[20] = (byte) ((0xFF) & (getEventChannelValue()));

        res[21] = (byte) ((0xFF) & (getAltitudeRate()));
        res[22] = (byte) ((0xFF) & (getSpeed()));
        res[23] = (byte) ((0xFF) & (getCamAngle()));
        byte prefix[] = getName().getBytes();
        for (int i = 0; i < 4; i++)
            res[24 + i] = (prefix.length > i) ? prefix[i] : 0;
        return res;
    }


    @Override
    public boolean equals(Object o) {
        if (!super.equals(o))
            return false;

        if (!(o instanceof WayPoint))
            return false;

        WayPoint other_wp = (WayPoint) o;
        if (other_wp.index != index)
            return false;

        if (other_wp.cam_angle != cam_angle)
            return false;


        if (other_wp.heading != heading)
            return false;

        if (other_wp.speed != speed)
            return false;

        if (other_wp.altitude != altitude)
            return false;

        if (other_wp.cam_angle != cam_angle)
            return false;

        if (other_wp.getEventChannelValue() != getEventChannelValue())
            return false;

        // TODO complete the tests here

        return true;
    }
}
