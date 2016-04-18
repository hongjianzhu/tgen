package com.daigou.sg.rpc.payment;

import com.daigou.sg.rpc.BaseModule;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * This file is auto-generated by tgen
 * Don't change manually
 */

public class TPrimePaymentResult extends BaseModule<TPrimePaymentResult> implements Serializable {
    public boolean result;
    public String message;
    public String paymentType;
    public boolean needTopUp;
    public ArrayList<String> paymentNumber;
    public boolean hasOtherUnpaid;
    public ArrayList<Integer> paymentId;
}
