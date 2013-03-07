package org.ligi.ufo;

/**
 * should collect infos which are common between
 *
 * @author ligi
 */
public class VesselData {

    public static class battery {
        private static int voltage = -1;
        private static int current = -1;
        private static int used_capacity = -1;

        /**
         * @return the Voltage in 0.1V or -1 if unknown
         */
        public static int getVoltage() {
            return voltage;
        }

        /**
         * @param new_voltage in 0.1V
         */
        public static void setUBatt(int new_voltage) {
            voltage = new_voltage;
        }

        public static void setCurrent(int current) {
            battery.current = current;
        }

        /**
         * in 0.1A
         *
         * @return
         */
        public static int getCurrent() {
            return current;
        }

        /**
         * in maH
         */
        public static void setUsedCapacity(int used_capacity) {
            battery.used_capacity = used_capacity;
        }

        /**
         * in maH
         */
        public static int getUsedCapacity() {
            return used_capacity;
        }
    }

    public static class NickRollYawInfo {
        private int nick;
        private int roll;
        private int yaw;


        public void setNick(int nick) {
            this.nick = nick;
        }

        public int getNick() {
            return this.nick;
        }

        public void setRoll(int roll) {
            this.roll = roll;
        }

        public int getRoll() {
            return roll;
        }

        public void setYaw(int yaw) {
            this.yaw = yaw;
        }

        public int getYaw() {
            return yaw;
        }
    }

    ;

    public static NickRollYawInfo attitude = new VesselData.NickRollYawInfo();
    public static NickRollYawInfo centroid = new VesselData.NickRollYawInfo();
}
