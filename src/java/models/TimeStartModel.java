package models;

public class TimeStartModel {
    private String racerAbbreviation;
    private String startTime;

    private String startData;

    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getStartData() {
        return startData;
    }

    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setStartData(String startData) {
        this.startData = startData;
    }

    @Override
    public String toString() {
        return "StartTime{" +
                "abr='" + racerAbbreviation + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
