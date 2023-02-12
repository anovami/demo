package models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResultModel {
    private String racerAbbreviation;
    private String racerName;
    private String racerTeam;
    private String timeStart;
    private String timeEnd;
    private String dataStart;
    private String dataEnd;
    private Duration raceDuration;
    private LocalDateTime timeStartResult;
    private LocalDateTime timeEndResult;


    public String getRacerAbbreviation() {
        return racerAbbreviation;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getRacerTeam() {
        return racerTeam;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public String getDataStart() {
        return dataStart;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public LocalDateTime getTimeStartResult() {
        return timeStartResult;
    }

    public LocalDateTime getTimeEndResult() {
        return timeEndResult;
    }

    public Duration getRaceDuration() {
        return raceDuration;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public void setRacerAbbreviation(String racerAbbreviation) {
        this.racerAbbreviation = racerAbbreviation;
    }

    public void setRacerTeam(String racerTeam) {
        this.racerTeam = racerTeam;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }

    public void setTimeStartResult() {
        String text =  this.dataStart + " " + this.timeStart;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        this.timeStartResult = LocalDateTime.parse(text, formatter);
    }

    public void setTimeEndResult() {
        String text =  this.dataEnd + " " + this.timeEnd;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        this.timeEndResult = LocalDateTime.parse(text, formatter);
    }

    public void setRaceDuration() {
        this.raceDuration = Duration.between(this.timeStartResult, this.timeEndResult);
    }

    @Override
    public String toString() {
        return this.racerAbbreviation + " " + this.racerName + " " + this.timeStart + " " + this.timeEnd + " " + this.raceDuration;
    }
}
