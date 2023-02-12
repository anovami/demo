package models;

public class TimeEndModel {
    private String racerAbbreviation;
    private String endTime;
    private String endData;

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getEndData() {
        return endData;
    }

    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }

    @Override
    public String toString() {
        return "EndTime{" +
                "abr='" + racerAbbreviation + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
