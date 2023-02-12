package controllers;

import dao.DAO;
import models.ResultModel;
import services.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controller {

    public static void main(String[] args) {
        DAO dao = new DAO();
//        System.out.println(dao.getStartTimeInfo());
        Service service = new Service();
        List<ResultModel> listOfResultModels;
        listOfResultModels = service.getResultModel();
        for (int i = 0; i < listOfResultModels.size(); i++) {
            System.out.println(listOfResultModels.get(i));
        }
    }
}
