package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.ComputerDao;
import com.vendettasoft.vendetta.models.hibernate.ComputerPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComputerController {


    @Autowired
    private ComputerDao computerDao;


    @RequestMapping("/getComputers")
    public List<ComputerPart> getComputers() {

        Iterable<ComputerPart> computerParts = computerDao.findAllByOrderByPkAsc();

        return (List<ComputerPart>) computerParts;
    }


    @RequestMapping(value = "/saveComputerPart", method = RequestMethod.POST)
    public ComputerPart saveComputer(@ModelAttribute ComputerPart computerPart) {

        ComputerPart part = computerDao.save(computerPart);

        return part;
    }



}
