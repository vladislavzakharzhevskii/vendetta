package com.vendettasoft.vendetta.controllers.async;

import com.vendettasoft.vendetta.dao.ComputerDao;
import com.vendettasoft.vendetta.dao.UserDAO;
import com.vendettasoft.vendetta.models.hibernate.ComputerPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComputerController {

    //todo use enum instead
    private static final String BASE_TYPE = "Base";
    private static final String ADDITIONAL_TYPE = "Additional";

    @Autowired
    private ComputerDao computerDao;

    @Autowired
    private UserDAO userDAO;


    @RequestMapping("/getComputers")
    public List<ComputerPart> getComputers() {

        Iterable<ComputerPart> computerParts = computerDao.findAllByOrderByPkAsc();

        return (List<ComputerPart>) computerParts;
    }


    @RequestMapping(value = "/getParsedComputerParts", method = RequestMethod.POST)
    public Map<String, List<ComputerPart>> getParsedComputers() {

        Iterable<ComputerPart> computerParts = computerDao.findAll();

        Map<String, List<ComputerPart>> parts = new HashMap<>(2);
        parts.put(BASE_TYPE, new ArrayList<>());
        parts.put(ADDITIONAL_TYPE, new ArrayList<>());

        for (ComputerPart part : computerParts) {
            List<ComputerPart> list = parts.get(part.getType());
            if (list != null) {
                list.add(part);
            }
        }

        return parts;
    }


    @RequestMapping(value = "/saveComputerPart", method = RequestMethod.POST)
    public ComputerPart saveComputer(@ModelAttribute ComputerPart computerPart) {

        ComputerPart part = computerDao.save(computerPart);

        return part;
    }



}
