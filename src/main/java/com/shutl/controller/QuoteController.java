package com.shutl.controller;

import com.shutl.model.Quote;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class QuoteController {

    HashMap<String, Double> vehicleMarkups = new HashMap<String, Double>();

    public QuoteController() {
        vehicleMarkups.put("bicycle", 1.10);
        vehicleMarkups.put("motorbike", 1.15);
        vehicleMarkups.put("parcel_car", 1.20);
        vehicleMarkups.put("small_van", 1.30);
        vehicleMarkups.put("large_van", 1.40);
    }

    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody
    Quote quote(@RequestBody Quote quote) {

        Double vehicleMarkup = vehicleMarkups.get(quote.getVehicle());

        Long price = Math.round(
                Math.abs((
                        Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36)
                ) / 100000000) * vehicleMarkup);

        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(), price);
    }
}
