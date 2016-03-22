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

public class TReadyToShipSummary implements Serializable {
    public int arrivedCount;
    public int notArrivedCount;
    public ArrayList<TOrder> orders;
    public com.daigou.sg.rpc.payment.TPaymentBill paymentBill;

    static TReadyToShipSummary fromJSON(JsonParser jp) throws IOException {
        // Sanity check: verify that we got "Json Object":
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start with a TReadyToShipSummary Object");
        }

        return doFromJSON(jp);
    }

    private static TReadyToShipSummary doFromJSON(JsonParser jp) throws IOException {
        TReadyToShipSummary result = new TReadyToShipSummary();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jp.getCurrentName();

            if (false) {
            } else if (fieldName.equals("arrivedCount")) {
                jp.nextToken();
                result.arrivedCount = jp.getIntValue();
            } else if (fieldName.equals("notArrivedCount")) {
                jp.nextToken();
                result.notArrivedCount = jp.getIntValue();
            } else if (fieldName.equals("orders")) {
                result.orders = TOrder.fromJSONArray(jp);
            } else if (fieldName.equals("paymentBill")) {
                result.paymentBill = com.daigou.sg.rpc.payment.TPaymentBill.fromJSON(jp);
                
            }
        }
        return result;
    }

    static ArrayList<TReadyToShipSummary> fromJSONArray(JsonParser jp) throws IOException {
        if (jp.nextToken() != JsonToken.START_ARRAY) {
            throw new IOException("Expected data to start with a TReadyToShipSummary array");
        }

        ArrayList<TReadyToShipSummary> result = new ArrayList<TReadyToShipSummary>();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            result.add(doFromJSON(jp));
        }
        return result;
    }
}
