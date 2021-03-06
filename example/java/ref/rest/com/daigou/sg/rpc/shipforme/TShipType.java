package com.daigou.sg.rpc.shipforme;

import com.google.gson.annotations.SerializedName;

/**
 * This file is auto-generated by tgen
 * Don't change manually
 */

public enum TShipType implements java.io.Serializable, com.daigou.sg.rpc.DeserializerEnum {
	@SerializedName("1")
	AA(1),
	@SerializedName("2")
	BB(2);


	int type;

    TShipType(int type) {
        this.type = type;
    }

	@Override
    public String toString() {
        return Integer.toString(type);
    }

    @Override
    public int getValue() {
        return type;
    }
}
