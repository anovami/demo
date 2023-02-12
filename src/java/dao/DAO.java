package dao;

import models.RacerModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class DAO {
    public List<RacerModel> getRacerInformation() {
        ClassLoader classLoader = DAO.class.getClassLoader();

        List<RacerModel> racerModels;
        try (
                InputStream inputStream = classLoader.getResourceAsStream("abbreviations.txt")
        ){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            racerModels =
                    bufferedReader.lines()
                            .map(line -> line.split("_"))
                            .map(str -> {
                                RacerModel racerModel = new RacerModel();
                                racerModel.setRacerAbbreviation(str[0]);
                                racerModel.setRacerName(str[1]);
                                racerModel.setRacerTeam(str[2]);
//                                System.out.println(racerModel);
                                return racerModel;
                            }).collect(Collectors.toList());


        } catch (IOException e) {
            throw new RuntimeException();
        }
        return racerModels;
    }

    public List<TimeStartModel> getStartTimeInfo() {
        ClassLoader classLoader = DAO.class.getClassLoader();

        List<TimeStartModel> listOfStartTime;
        try (InputStream inputStream = classLoader.getResourceAsStream("start.log")
        ){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            listOfStartTime =
                    bufferedReader.lines()
                            .map(line -> line.split("_"))
                            .map(str -> {
                                TimeStartModel timeStartModel = new TimeStartModel();
                                timeStartModel.setRacerAbbreviation(str[0].substring(0,3));
                                timeStartModel.setStartTime(str[1]);
                                timeStartModel.setStartData(str[0].substring(3));
                                return timeStartModel;
                            })
                            .collect(Collectors.toList());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return listOfStartTime;

    }

    public List<TimeEndModel> getEndTimeInfo() {
        ClassLoader classLoader = DAO.class.getClassLoader();

        List<TimeEndModel> listOfEndTimes;
        try (
                InputStream inputStream = classLoader.getResourceAsStream("end.log")
        ){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            listOfEndTimes =
                    bufferedReader.lines()
                            .map(line -> line.split("_"))
                            .map(str -> {
                                TimeEndModel timeEndModel = new TimeEndModel();
                                timeEndModel.setRacerAbbreviation(str[0].substring(0,3));
                                timeEndModel.setEndTime(str[1]);
                                timeEndModel.setEndData(str[0].substring(3));
                                return timeEndModel;
                            }).collect(Collectors.toList());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfEndTimes;
    }
}