package services;

import dao.DAO;
import models.RacerModel;
import models.ResultModel;
import models.TimeEndModel;
import models.TimeStartModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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

    //TODO: нужно еще дату старта получить:
    private String findRacerStartDate(ResultModel resultModel) {
        return timeStartModels.stream()
                .filter(timeStartModel -> timeStartModel.getRacerAbbreviation().equals(resultModel.getRacerAbbreviation()))
                .findAny().orElse(null).getStartData();
    }

    //TODO: нужно еще дату конца получить:
    private String findRacerEndDate(ResultModel resultModel) {
        return timeEndModels.stream()
                .filter(timeEndModels -> timeEndModels.getRacerAbbreviation().equals(resultModel.getRacerAbbreviation()))
                .findAny().orElse(null).getEndData();
    }



    //TODO: перенеси этот метод повыше , остальные опусти вниз. Этот метод главный, остальные - вспомогательные
    public List<ResultModel> getResultModel() {

        listOfResultModels = racerModels.stream()
                .map(r -> {
                    ResultModel resultModel = new ResultModel();
                    resultModel.setRacerAbbreviation(r.getRacerAbbreviation());
                    resultModel.setRacerName(r.getRacerName());
                    resultModel.setRacerTeam(r.getRacerTeam());
                    //TODO: на этом этапе мы заполнчем только abr, name и team для каждого рэйсера.
                    // И берем их из файла abbreviations, то есть из модели RacerModel
                    //TODO: всё остальное на этом этапе мы еще заполнить не можем, потому что они идут уже из других моделей, их надо там вытаскивать
//                    resultModel.setTimeStart(getStartTime(resultModel));
//                    resultModel.setTimeEnd(getEndTime(resultModel));
//                    System.out.println(resultModel);
                    return resultModel;
                })//TODO: следующая операция которая нам нужна, это .peek потому что она не изменяет текущую коллекцию в отличие от .map
                //TODO: в .peek нам нужно засетать значение timeStart и timeEnd
                //TODO: Вытянем сначала из модели TimeStartModel значение startTime. Это у тебя реализовано в методе getStartTime(ResultModel resultModel)
                //TODO: Здесь же вытянем startData из модели TimeStartModel. Этого у тебя нет. Должен быть еще один метод, я написала его выше findRacerStartDate(ResultModel racer)
//TODO:Теперь ты можешь сразу засетать в результирующую модель и время и дату старта
                .peek(r -> {
                    r.setTimeStart(getStartTime(r));
                    r.setDataStart(findRacerStartDate(r));
                    r.setTimeStartResult();
                })
                .peek(ResultModel::setTimeStartResult)
                //TODO: в следующем .peek делаешь все тоже самое, сетаешь в результирующую модель время конца и дату конца.
                .peek(r -> {
                    r.setTimeEnd(getEndTime(r));
                    r.setDataEnd(findRacerEndDate(r));
                    r.setTimeEndResult();
                })
                .peek(ResultModel::getTimeEndResult)
                //TODO: теперь в еще одном .peek ты можешь засетать дюратион, который сразу рассчитывается в ResultModel --  .peek(ResultModel::setDurationTime)
                .peek(ResultModel::setRaceDuration)
                //TODO: и в следующем .peek уже можно применить метод сортировки по дюратион .sorted(Comparator.comparing(ResultModel::getDurationTime))
                .sorted(Comparator.comparing(ResultModel::getRaceDuration))
                .collect(Collectors.toList());


        return listOfResultModels;
    }


}

