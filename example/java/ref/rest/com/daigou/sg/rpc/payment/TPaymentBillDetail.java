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

public class TPaymentBillDetail extends BaseModule<TPaymentBillDetail> implements Serializable {
    public TPaymentBill paymentBill;
    public ArrayList<com.daigou.sg.rpc.tpackage.TPackageDetail> packageInfo;
    public ArrayList<com.daigou.sg.rpc.order.TOrderBill> orderInfo;
}