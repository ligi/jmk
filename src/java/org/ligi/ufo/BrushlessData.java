package org.ligi.ufo;

public class BrushlessData {
    private int index;            // address of BL-Ctrl
    private int current;
    private int temperature;      // only valid fpr BL-Ctrl >= V2.0
    private int maxPWM;
    private int status;

    public BrushlessData(int[] data, int offset) {
        index = data[offset];
        current = data[offset + 1];
        temperature = data[offset + 2];
        maxPWM = data[offset + 3];
        status = data[offset + 4];
    }

    public int getIndex() {
        return index;
    }

    public int getCurrent() {
        return current;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getMaxPWM() {
        return maxPWM;
    }

    public int getStatus() {
        return status;
    }

    public String toString() {
        return "#" + index + " current:" + getCurrent() + " temp:" + getTemperature() + " maxPWM:" + getMaxPWM() + " status:" + status;
    }

}
