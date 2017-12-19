package com.vendettasoft.vendetta.controllers.async.traini;

import com.vendettasoft.vendetta.dao.ComputerDao;
import com.vendettasoft.vendetta.models.dto.ComputerOrder;
import com.vendettasoft.vendetta.models.traini.decorator.PartProductBase;
import com.vendettasoft.vendetta.models.traini.decorator.Product;
import com.vendettasoft.vendetta.models.traini.decorator.computers.ComputerBase;
import com.vendettasoft.vendetta.models.traini.decorator.computers.partials.PartComputer;
import com.vendettasoft.vendetta.services.traini.DecoratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductDecoratorController {

    @Autowired
    private DecoratorService decoratorService;

    @Autowired
    private ComputerDao computerDao;


    @RequestMapping("/get-computers-data")
    public Map<String, Object> getComputersProduct() {

        decoratorService.restoreProducts();
        List<Product> computerBase = decoratorService.getProductsByType(ComputerBase.COMPUTER_BASE);
        List<Product> computerParts = decoratorService.getProductsByType(PartComputer.PARTIALS_COMPUTER);


        Map<String, Object> computersProducts = new HashMap<>();
        computersProducts.put("Computer-bases", computerBase);
        computersProducts.put("Computers-parts", computerParts);

        return computersProducts;
    }


    @RequestMapping(value = "/process-order", method = RequestMethod.POST)
    public Map<String, String> decorator(@ModelAttribute ComputerOrder computerOrder) {

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<Product> additionalComponents = decoratorService.getOrderModel(computerOrder.getAdditionalComponentsIds());

        Product root = additionalComponents.get(0);
        additionalComponents.remove(root);

        Long baseComponentId = computerOrder.getBaseComponentId();
        Product baseOrderModel = decoratorService.getOrderModel(baseComponentId);
        ((PartProductBase) additionalComponents.get(additionalComponents.size() - 1)).addProduct(baseOrderModel);

        /*
        * The main idea Decorator pattern is holds object chain into;
        * use only one method to get all related Object's data from
        * It's hack to set Product when object has created.
        *
        * */
        Product secondProduct = additionalComponents.get(0);
        if (secondProduct instanceof PartProductBase) {
            ((PartProductBase) root).addProduct(secondProduct);
        }

        for (int i = 0; i < additionalComponents.size(); i++) {
            if (i <= additionalComponents.size() - 2) {
                ((PartProductBase) additionalComponents.get(i)).addProduct(additionalComponents.get(i + 1));
            }
        }


        Map<String, String> result = new HashMap<>();
        result.put("components", root.getName());
        result.put("description", root.getDescription());
        result.put("cost", String.valueOf(root.getCost()));

        return result;
    }

}
