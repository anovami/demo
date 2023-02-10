package controllers;

import services.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {

    public static void main(String[] args) {
        Service service = new Service();
        System.out.println(service.getResultModel());
//        String text = "2018-05-24_12:04:13.889";
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss.SSS");
//
//        LocalDateTime time;
//        time = LocalDateTime.parse(text, formatter);
//        System.out.println(text);
//        this.timeStart = LocalDateTime.parse(timeStart, formatter);

    }
}
