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

public class TPendingDeliveryPackage implements Serializable {
    public int shipmentId;
    public String localDeliveryMethod;
    public String stationName;
    public String periodName;
    public String localDeliveryDate;
    public String shipToAddress;
    public boolean canBeEdited;
    public int mrtStationItemId;
    public int neighbourhoodStationItemId;
    public int selfStationId;
    public double totalFee;
    public ArrayList<TPackage> packages;

    static TPendingDeliveryPackage fromJSON(JsonParser jp) throws IOException {
        // Sanity check: verify that we got "Json Object":
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start with a TPendingDeliveryPackage Object");
        }

        return doFromJSON(jp);
    }

    private static TPendingDeliveryPackage doFromJSON(JsonParser jp) throws IOException {
        TPendingDeliveryPackage result = new TPendingDeliveryPackage();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jp.getCurrentName();

            if (false) {
            } else if (fieldName.equals("shipmentId")) {
                jp.nextToken();
                result.shipmentId = jp.getIntValue();
            } else if (fieldName.equals("localDeliveryMethod")) {
                jp.nextToken();
                result.localDeliveryMethod = jp.getText();
            } else if (fieldName.equals("stationName")) {
                jp.nextToken();
                result.stationName = jp.getText();
            } else if (fieldName.equals("periodName")) {
                jp.nextToken();
                result.periodName = jp.getText();
            } else if (fieldName.equals("localDeliveryDate")) {
                jp.nextToken();
                result.localDeliveryDate = jp.getText();
            } else if (fieldName.equals("shipToAddress")) {
                jp.nextToken();
                result.shipToAddress = jp.getText();
            } else if (fieldName.equals("canBeEdited")) {
                jp.nextToken();
                result.canBeEdited = jp.getBooleanValue();
            } else if (fieldName.equals("mrtStationItemId")) {
                jp.nextToken();
                result.mrtStationItemId = jp.getIntValue();
            } else if (fieldName.equals("neighbourhoodStationItemId")) {
                jp.nextToken();
                result.neighbourhoodStationItemId = jp.getIntValue();
            } else if (fieldName.equals("selfStationId")) {
                jp.nextToken();
                result.selfStationId = jp.getIntValue();
            } else if (fieldName.equals("totalFee")) {
                jp.nextToken();
                result.totalFee = jp.getDoubleValue();
            } else if (fieldName.equals("packages")) {
                result.packages = TPackage.fromJSONArray(jp);
            }
        }
        return result;
    }

    static ArrayList<TPendingDeliveryPackage> fromJSONArray(JsonParser jp) throws IOException {
        if (jp.nextToken() != JsonToken.START_ARRAY) {
            throw new IOException("Expected data to start with a TPendingDeliveryPackage array");
        }

        ArrayList<TPendingDeliveryPackage> result = new ArrayList<TPendingDeliveryPackage>();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            result.add(doFromJSON(jp));
        }
        return result;
    }
}
