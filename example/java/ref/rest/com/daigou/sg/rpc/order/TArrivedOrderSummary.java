package com.daigou.sg.rpc.order;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This file is auto-generated by tgen
 * Don't change manually
 */

public class TArrivedOrderSummary implements Serializable {
    public String shipmentTypeCode;
    public String altShipmentTypeName;
    public int arrivedCount;
    public int notArrivedCount;

    static TArrivedOrderSummary fromJSON(JsonParser jp) throws IOException {
        // Sanity check: verify that we got "Json Object":
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start with a TArrivedOrderSummary Object");
        }

        return doFromJSON(jp);
    }

    private static TArrivedOrderSummary doFromJSON(JsonParser jp) throws IOException {
        TArrivedOrderSummary result = new TArrivedOrderSummary();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jp.getCurrentName();

            if (false) {
            } else if (fieldName.equals("shipmentTypeCode")) {
                jp.nextToken();
                result.shipmentTypeCode = jp.getText();
            } else if (fieldName.equals("altShipmentTypeName")) {
                jp.nextToken();
                result.altShipmentTypeName = jp.getText();
            } else if (fieldName.equals("arrivedCount")) {
                jp.nextToken();
                result.arrivedCount = jp.getIntValue();
            } else if (fieldName.equals("notArrivedCount")) {
                jp.nextToken();
                result.notArrivedCount = jp.getIntValue();
            }
        }
        return result;
    }

    static ArrayList<TArrivedOrderSummary> fromJSONArray(JsonParser jp) throws IOException {
        if (jp.nextToken() != JsonToken.START_ARRAY) {
            throw new IOException("Expected data to start with a TArrivedOrderSummary array");
        }

        ArrayList<TArrivedOrderSummary> result = new ArrayList<TArrivedOrderSummary>();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            result.add(doFromJSON(jp));
        }
        return result;
    }
}
