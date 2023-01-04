package entity;

import java.util.List;

public class Screen {
    long screenId;
    List<Seat> seatList;

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
