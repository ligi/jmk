package org.ligi.ufo;

public class MKPosition extends Object {

    public MKPosition() {
    }

    public MKPosition(int lat, int lon) {
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * the latitude in deg*10^-7 *
     */
    private int lat;

    /**
     * the longitude in deg*10^-7 *
     */
    private int lon;

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


    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MKPosition))
            return false;
        MKPosition other_pos = (MKPosition) other;

        if (other_pos.getLat() != getLat())
            return false;

        if (other_pos.getLon() != getLon())
            return false;

        return true;
    }
}
