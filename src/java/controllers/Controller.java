package controllers;

import services.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {

    public static void main(String[] args) {
        Service service = new Service();
        System.out.println(service.getResultModel());


    }
}
