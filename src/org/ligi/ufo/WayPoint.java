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
 *
 */
public class WayPoint {

	/** time the MK should hold the position in seconds **/
	private int hold_time=23;        
	
	/** the radius around the waypoint in meters in which the point is seen as reached **/
	private int tolerance_radius=5;  
	
	/** TODO make some doc for this value **/
	private int channel_event=200;    
	
	/** the latitude in deg*10^-7 **/
	private int lat;                 
	
	/** the longitude in deg*10^-7 **/
	private int lon; 	
	
	private int index;				// to indentify different waypoints, workaround for bad communications PC <-> NC 
	private int heading;			// orientation, 0 no action, 1...360 fix heading, neg. = Index to POI in WP List
	private int event_flag;			// future implementation       
	private int type;				// typeof Waypoint    
	private int event_channel_value;
	private int altitude_rate;		// rate to change the setpoint 
	private int speed;				// rate to change the Position 
	private int cam_angle;			// Camera nick servo angle 
	private String name;       		// 4 chars
	
	public WayPoint(int lat,int lon) {
		this.setLat(lat);
		this.setLon(lon);
	}
		
	public int getHoldTime() {
		return hold_time;
	}
	
	public void setHoldTime(int t) {
		hold_time=t;
	}

	public void setToleranceRadius(int tolerance_radius) {
		this.tolerance_radius = tolerance_radius;
	}

	public int getToleranceRadius() {
		return tolerance_radius;
	}

	public void setChannelEvent(int channel_event) {
		this.channel_event = channel_event;
	}

	public int getChannelEvent() {
		return channel_event;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLat() {
		return lat;
	}

	public void setLon(int lon) {
		this.lon = lon;
	}

	public int getLon() {
		return lon;
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
}
