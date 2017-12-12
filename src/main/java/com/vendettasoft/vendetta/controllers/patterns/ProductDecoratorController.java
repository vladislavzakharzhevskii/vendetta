package com.vendettasoft.vendetta.controllers.patterns;

import com.vendettasoft.vendetta.models.decorator.Product;
import com.vendettasoft.vendetta.models.decorator.computers.ComputerBase;
import com.vendettasoft.vendetta.models.decorator.computers.partials.PartComputer;
import com.vendettasoft.vendetta.services.DecoratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductDecoratorController {

    @Autowired
    private DecoratorService decoratorService;


    @RequestMapping("/get-computers-data")
    public Map<String, Object> getComputersProduct() {

        List<Product> computerBase = decoratorService.getProductsByType(ComputerBase.COMPUTER_BASE);
        List<Product> computerParts = decoratorService.getProductsByType(PartComputer.PARTIALS_COMPUTER);


        Map<String, Object> computersProducts = new HashMap<>();
        computersProducts.put("Computer-bases", computerBase);
        computersProducts.put("Computers-parts", computerParts);

        return computersProducts;
    }


    @RequestMapping("/process-order")
    public String decorator() {
        return "";
    }

}
