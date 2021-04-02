package com.armj.kafka.protobuftopicproducer.service.datagenerator;

import com.armj.kafka.protobuftopicproducer.model.DeliveryAddress;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
public class AddressGenerator {

    private final Random random;
    private final DeliveryAddress[] addresses;

    public AddressGenerator() {
        final String DATAFILE = "src/main/resources/data/address.json";
        final ObjectMapper mapper;
        random = new Random();
        mapper = new ObjectMapper();

        try {
            addresses = mapper.readValue(new File(DATAFILE), DeliveryAddress[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Integer getIndex() {
        return random.nextInt(5);
    }

    public DeliveryAddress getNextAddress() {
        return addresses[getIndex()];
    }
}
