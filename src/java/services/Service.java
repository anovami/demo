package services;

import dao.DAO;
import models.RacerModel;
import models.ResultModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service {
    DAO dao = new DAO();
    List<ResultModel> listOfResultModels;
    List<RacerModel> racerModels = dao.getRacerInformation();
    List<TimeStartModel> timeStartModels = dao.getStartTimeInfo();
    List<TimeEndModel> timeEndModels = dao.getEndTimeInfo();

    public String getStartTime(ResultModel resultModel) {
        return timeStartModels.stream()
                .filter(timeStartModel -> timeStartModel.getRacerAbbreviation().equals(resultModel.getRacerAbbreviation()))
                .findAny().orElse(null).getStartTime();
    }

    public String getEndTime(ResultModel resultModel) {
        return timeEndModels.stream()
                .filter(timeEndModel -> timeEndModel.getRacerAbbreviation().equals(resultModel.getRacerAbbreviation()))
                .findAny().orElse(null).getEndTime();
    }

    public List<ResultModel> getResultModel() {

        listOfResultModels = racerModels.stream()
                .map(racerModel -> {
                    ResultModel resultModel = new ResultModel();
                    resultModel.setRacerAbbreviation(racerModel.getRacerAbbreviation());
                    resultModel.setRacerName(racerModel.getRacerName());
                    resultModel.setTimeStart(getStartTime(resultModel));
                    resultModel.setTimeEnd(getEndTime(resultModel));
                    System.out.println(resultModel);
                    return resultModel;
                })
                .collect(Collectors.toList());


        return listOfResultModels;
    }


}

