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

public class TPackageDetail implements Serializable {
    public TPackage tPackage;
    public com.daigou.sg.rpc.payment.TPaymentBill paymentBill;
    public ArrayList<com.daigou.sg.rpc.order.TOrder> orders;
    public ArrayList<com.daigou.sg.rpc.order.TOrderRemark> orderRemarks;

    static TPackageDetail fromJSON(JsonParser jp) throws IOException {
        // Sanity check: verify that we got "Json Object":
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start with a TPackageDetail Object");
        }

        return doFromJSON(jp);
    }

    private static TPackageDetail doFromJSON(JsonParser jp) throws IOException {
        TPackageDetail result = new TPackageDetail();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jp.getCurrentName();

            if (false) {
            } else if (fieldName.equals("tPackage")) {
                result.tPackage = TPackage.fromJSON(jp);
                
            } else if (fieldName.equals("paymentBill")) {
                result.paymentBill = com.daigou.sg.rpc.payment.TPaymentBill.fromJSON(jp);
                
            } else if (fieldName.equals("orders")) {
                result.orders = com.daigou.sg.rpc.order.TOrder.fromJSONArray(jp);
            } else if (fieldName.equals("orderRemarks")) {
                result.orderRemarks = com.daigou.sg.rpc.order.TOrderRemark.fromJSONArray(jp);
            }
        }
        return result;
    }

    static ArrayList<TPackageDetail> fromJSONArray(JsonParser jp) throws IOException {
        if (jp.nextToken() != JsonToken.START_ARRAY) {
            throw new IOException("Expected data to start with a TPackageDetail array");
        }

        ArrayList<TPackageDetail> result = new ArrayList<TPackageDetail>();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            result.add(doFromJSON(jp));
        }
        return result;
    }
}
