package com.daigou.sg.rpc.tpackage;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This file is auto-generated by tgen
 * Don't change manually
 */

public class TPackageSummary implements Serializable {
    public int pendingReplyCount;
    public int prepareShipmentCount;
    public int shippedCount;
    public int arrangeDeliveryCount;
    public int pendingPaymentCount;
    public int pendingDeliveryCount;
    public int acknowledgeCount;
    public int completedCount;

    static TPackageSummary fromJSON(JsonParser jp) throws IOException {
        // Sanity check: verify that we got "Json Object":
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start with a TPackageSummary Object");
        }

        return doFromJSON(jp);
    }

    private static TPackageSummary doFromJSON(JsonParser jp) throws IOException {
        TPackageSummary result = new TPackageSummary();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jp.getCurrentName();

            if (false) {
            } else if (fieldName.equals("pendingReplyCount")) {
                jp.nextToken();
                result.pendingReplyCount = jp.getIntValue();
            } else if (fieldName.equals("prepareShipmentCount")) {
                jp.nextToken();
                result.prepareShipmentCount = jp.getIntValue();
            } else if (fieldName.equals("shippedCount")) {
                jp.nextToken();
                result.shippedCount = jp.getIntValue();
            } else if (fieldName.equals("arrangeDeliveryCount")) {
                jp.nextToken();
                result.arrangeDeliveryCount = jp.getIntValue();
            } else if (fieldName.equals("pendingPaymentCount")) {
                jp.nextToken();
                result.pendingPaymentCount = jp.getIntValue();
            } else if (fieldName.equals("pendingDeliveryCount")) {
                jp.nextToken();
                result.pendingDeliveryCount = jp.getIntValue();
            } else if (fieldName.equals("acknowledgeCount")) {
                jp.nextToken();
                result.acknowledgeCount = jp.getIntValue();
            } else if (fieldName.equals("completedCount")) {
                jp.nextToken();
                result.completedCount = jp.getIntValue();
            }
        }
        return result;
    }

    static ArrayList<TPackageSummary> fromJSONArray(JsonParser jp) throws IOException {
        if (jp.nextToken() != JsonToken.START_ARRAY) {
            throw new IOException("Expected data to start with a TPackageSummary array");
        }

        ArrayList<TPackageSummary> result = new ArrayList<TPackageSummary>();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            result.add(doFromJSON(jp));
        }
        return result;
    }
}
