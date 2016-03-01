package com.daigou.selfstation.rpc.selfstation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This file is auto-generated by tgen
 * Don't change manually
 */

public class TParcelSection implements Serializable {
    public String name;
    public String value;

    static TParcelSection fromJSON(JsonParser jp) throws IOException {
        // Sanity check: verify that we got "Json Object":
        if (jp.nextToken() != JsonToken.START_OBJECT) {
            throw new IOException("Expected data to start with a TParcelSection Object");
        }

        return doFromJSON(jp);
    }

    private static TParcelSection doFromJSON(JsonParser jp) throws IOException {
        TParcelSection result = new TParcelSection();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jp.getCurrentName();

            if (false) {
            } else if (fieldName.equals("name")) {
                jp.nextToken();
                result.name = jp.getText();
            } else if (fieldName.equals("value")) {
                jp.nextToken();
                result.value = jp.getText();
            }
        }
        return result;
    }

    static ArrayList<TParcelSection> fromJSONArray(JsonParser jp) throws IOException {
        if (jp.nextToken() != JsonToken.START_ARRAY) {
            throw new IOException("Expected data to start with a TParcelSection array");
        }

        ArrayList<TParcelSection> result = new ArrayList<TParcelSection>();

        // Iterate over object fields:
        while (jp.nextToken() != JsonToken.END_ARRAY) {
            result.add(doFromJSON(jp));
        }
        return result;
    }
}
