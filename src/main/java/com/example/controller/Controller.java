package com.example.controller;

import com.example.data.Magic;
import com.example.repository.MagicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by WagnerMestrinho on 3/28/17.
 */
@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    MagicRepo magicRepo;

    @RequestMapping(path = "/action", method = RequestMethod.POST)
    public String createNumber(Model data, @RequestParam int number){
        Magic tmp = new Magic(number);

        magicRepo.save(tmp);

        if(tmp.getId()<=0){
            data.addAttribute("msg_success",
                    String.format("%s", number));
        }
        return "forward:/lists";
    }
    @RequestMapping(path = "/sum", method = RequestMethod.GET)
    public String sumAll(Model sumModel){
    String destination = "index";
        Iterable<Magic> found = magicRepo.findAll();

        // convert to list
        Iterator<Magic> itr = found.iterator();
        List<Magic> data = new ArrayList();
        while (itr.hasNext()) {
            data.add(itr.next());
        }
        int Sum = 0;

        for(int i=0; i<data.size(); i++){

            Sum = Sum + data.get(i).getNumber();

        }

        // put list into model
        sumModel.addAttribute("result", Sum);

        return destination;

    }
    @RequestMapping(path = "/clear", method = RequestMethod.GET)
    public String clearall(Model data){
        Iterable<Magic> found = magicRepo.findAll();
        magicRepo.delete(found);
        // find by
        data.addAttribute("delete_success", "Cleared List");
        return "/index";
    }

    @RequestMapping(path = "/lists")
    public String listNumbers(Model xyz) {
        String destination = "index";
        Iterable found = magicRepo.findAll();

        // convert to lists because i like them
        Iterator<Magic> itr = found.iterator();
        List<Magic> data = new ArrayList();
        while (itr.hasNext()) {
            data.add(itr.next());
        }

        // put list into model
        xyz.addAttribute("nList", found);

        // go to jsp
        return destination;

    }
    @RequestMapping(path = "/average", method = RequestMethod.GET)
    public String average(Model averageModel){
        String destination = "index";
        Iterable<Magic> found = magicRepo.findAll();

        // convert to list
        Iterator<Magic> itr = found.iterator();
        List<Magic> averageData = new ArrayList();
        while (itr.hasNext()) {
            averageData.add(itr.next());
        }
        int Sum = 0;

        for(int i=0; i<averageData.size(); i++){

            Sum = Sum + averageData.get(i).getNumber();

        }
        double average = Sum / averageData.size();
        // put list into model
        averageModel.addAttribute("result", average);

        return destination;
    }
    @RequestMapping(path = "/max", method = RequestMethod.GET)
    public String getMaxValue(Model max) {
        String destination = "index";
        Iterable found = magicRepo.findAll();

        // convert to lists because i like them
        Iterator<Magic> itr = found.iterator();
        List<Magic> data = new ArrayList();
        while (itr.hasNext()) {
            data.add(itr.next());
        }

        int maxValue = data.get(0).getNumber();
        for (int i = 1; i < data.size(); i++) {
            if (data.get(i).getNumber() > maxValue) {
                maxValue = data.get(i).getNumber();
            }
            max.addAttribute("result", maxValue);
        }
            return destination;
    }
    @RequestMapping(path = "/min", method = RequestMethod.GET)
    public String getMinValue(Model min){
        String destination = "index";
        Iterable found = magicRepo.findAll();

        // convert to lists because i like them
        Iterator<Magic> itr = found.iterator();
        List<Magic> data = new ArrayList();
        while (itr.hasNext()) {
            data.add(itr.next());
        }
        int minValue = data.get(0).getNumber();
        for(int i=1;i<data.size();i++){
            if(data.get(i).getNumber() < minValue){
                minValue = data.get(i).getNumber();
            }
            min.addAttribute("result", minValue);
        }
        return destination;
    }
}

