package com.armj.kafka.protobuftopicproducer.service.datagenerator;

import com.armj.kafka.protobuftopicproducer.model.LineItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
public class ProductGenerator {

    private final Random random;
    private final Random qty;
    private final LineItem[] products;

    public ProductGenerator() {
        final String DATAFILE = "src/main/resources/data/products.json";
        ObjectMapper mapper = new ObjectMapper();
        random = new Random();
        qty = new Random();

        try {
            products = mapper.readValue(new File(DATAFILE), LineItem[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public Integer getIndex() {
        return random.nextInt(10);
    }

    public Integer getQuantity() {
        return qty.nextInt(10) + 1;
    }

    public LineItem getNextProduct() {
        LineItem lineItem = products[getIndex()];
        lineItem.setItemQty(getQuantity());
        lineItem.setTotalValue(lineItem.getItemPrice() * lineItem.getItemQty());
        return lineItem;
    }
}
