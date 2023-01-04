public enum ParkingSlotType {
    TWOWHEELER {
        public double getPriceForParking(long duration) {
            return duration * 0.05;
        }
    },
    FOURWHEELER {
        public double getPriceForParking(long duration) {
            return duration * 0.25;
        }
    },
    LARGE {
        public double getPriceForParking(long duration) {
            return duration * 0.75;
        }
    };

    public abstract double getPriceForParking(long duration);
}
