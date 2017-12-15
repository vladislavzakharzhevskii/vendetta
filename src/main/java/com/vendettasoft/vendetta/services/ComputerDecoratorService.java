package com.vendettasoft.vendetta.services;

import com.vendettasoft.vendetta.models.decorator.PartProductBase;
import com.vendettasoft.vendetta.models.decorator.Product;
import com.vendettasoft.vendetta.models.decorator.computers.ArtLineComputer;
import com.vendettasoft.vendetta.models.decorator.computers.AsusComputer;
import com.vendettasoft.vendetta.models.decorator.computers.ComputerBase;
import com.vendettasoft.vendetta.models.decorator.computers.LenovoComputer;
import com.vendettasoft.vendetta.models.decorator.computers.partials.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ComputerDecoratorService implements DecoratorService {

    @Autowired
    private JdbcOperations jdbc;

    private final static Map<Long, Product> COMPUTER_STRATEGY = new HashMap<Long, Product>();
    static {
        Product pr1 = new ArtLineComputer();
        COMPUTER_STRATEGY.put(pr1.getId(), pr1);
        Product pr2 = new AsusComputer();
        COMPUTER_STRATEGY.put(pr2.getId(), pr2);
        Product pr3 = new LenovoComputer();
        COMPUTER_STRATEGY.put(pr3.getId(), pr3);

        Product pt1 = new AMDRyzen7(ComponentType.PROCESSOR);
        COMPUTER_STRATEGY.put(pt1.getId(), pt1);
        Product pt2 = new GeforceGTX1080(ComponentType.VIDEO_CARD);
        COMPUTER_STRATEGY.put(pt2.getId(), pt2);
        Product pt3 = new IntelCoreI7(ComponentType.PROCESSOR);
        COMPUTER_STRATEGY.put(pt3.getId(), pt3);
        Product pt4 = new RadeonAsus(ComponentType.VIDEO_CARD);
        COMPUTER_STRATEGY.put(pt4.getId(), pt4);
        Product pt5 = new SeagateExpansion(ComponentType.HARD_DISK);
        COMPUTER_STRATEGY.put(pt5.getId(), pt5);
        Product pt6 = new WesternDigital(ComponentType.HARD_DISK);
        COMPUTER_STRATEGY.put(pt6.getId(), pt6);
    }


    @Override
    public List<Product> getOrderModel(List<Long> partialsIds) {
        List<Product> partials = new ArrayList<>();
        for (Long partialsId : partialsIds) {
//            if (COMPUTER_STRATEGY.containsKey(partialsId)) {}/*TODO DOES IT NEED TO USE?*/

            partials.add(COMPUTER_STRATEGY.get(partialsId));
        }

        return partials;
    }

    @Override
    public Product getOrderModel(Long productId) {
        return COMPUTER_STRATEGY.get(productId);
    }

    @Override
    public Map<String, Object> getOrderModel(List<Long> partialsIds, Long baseTypeId) {
        Map<String, Object> model = new HashMap<>(2);
//        if (COMPUTER_STRATEGY.containsKey(baseTypeId)) {}/*TODO DOES IT NEED TO USE?*/

        model.put(ComputerBase.COMPUTER_BASE, COMPUTER_STRATEGY.get(baseTypeId));
        model.put(PartComputer.PARTIALS_COMPUTER, getOrderModel(partialsIds));

        return model;
    }

    @Override
    public List<Product> getProductsByType(String type) {
        List<Product> productByType = new ArrayList<>();

        Collection<Product> values = COMPUTER_STRATEGY.values();
        for (Product value : values) {
            if (value.getType().equals(type)) {
                productByType.add(value);
            }
        }
        return productByType;
    }


    @Override
    public void restoreProducts() {
        for (Long key : COMPUTER_STRATEGY.keySet()) {
            Product product = COMPUTER_STRATEGY.get(key);
            if (product instanceof PartProductBase) {
                ((PartProductBase) product).addProduct(null);
            }
        }
    }
}
