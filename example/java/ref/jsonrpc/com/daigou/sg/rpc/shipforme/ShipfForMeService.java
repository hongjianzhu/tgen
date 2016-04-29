package com.daigou.sg.rpc.shipforme;

/**
 * This file is auto-generated by tgen
 * Don't change manually
 */
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.daigou.sg.rpc.BaseModule;
import com.daigou.sg.rpc.GsonUtils;
import com.daigou.sg.rpc.RpcRequest;
import com.daigou.sg.rpc.TRpc;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.Charset;
<<<<<<< 0536d024a95f5cb2a41bfd41472a5b9f94d7f4b1:example/java/ref/jsonrpc/com/daigou/sg/rpc/shipforme/ShipfForMeService.java
public class ShipfForMeService {
=======
import java.util.ArrayList;
import java.util.Map;

public class PaymentService {
>>>>>>> modify java template: add import:example/java/ref/rest/com/daigou/sg/rpc/payment/PaymentService.java
    private static final Gson gson = GsonUtils.getGsonInstance();
    private static int msgID = 1;

    private ShipfForMeService() {
        // Constructor hidden because this is a singleton
    }

    private static String getMsgID() {
        msgID += 1;
        return Integer.toString(msgID);
    }

    public static RpcRequest GetCourierCompaniesByRegion(final String originCode, final Listener<java.util.ArrayList<String>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        java.util.ArrayList<String> result;
                        result = BaseModule.fromJSONArray(response, String.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(originCode);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.GetCourierCompaniesByRegion");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserAddNewShipForMeOrder(final String warehouseCode, final String shipperName, final String wayBill, final String alternative, final boolean takePhoto, final String originCode, final String repack, final Listener<Integer> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Integer result;
                        result = BaseModule.fromJSON(response, Integer.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(warehouseCode);
                params.add(shipperName);
                params.add(wayBill);
                params.add(alternative);
                params.add(takePhoto);
                params.add(originCode);
                params.add(repack);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserAddNewShipForMeOrder");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserConfirmShipForMeRepack(final boolean confirm, final int orderId, final Listener<Void> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
<<<<<<< 0536d024a95f5cb2a41bfd41472a5b9f94d7f4b1:example/java/ref/jsonrpc/com/daigou/sg/rpc/shipforme/ShipfForMeService.java
                public void onResponse(String response) {if (listener != null) {
=======
                public void onResponse(String response) {
                    try {
                        TCreditCardInfo result;
                        result = BaseModule.doFromJSON(response, TCreditCardInfo.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

>>>>>>> modify java template: add import:example/java/ref/rest/com/daigou/sg/rpc/payment/PaymentService.java
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(confirm);
                params.add(orderId);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserConfirmShipForMeRepack");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserDeleteShipForMeOrder(final int orderId, final Listener<Void> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
<<<<<<< 0536d024a95f5cb2a41bfd41472a5b9f94d7f4b1:example/java/ref/jsonrpc/com/daigou/sg/rpc/shipforme/ShipfForMeService.java
                public void onResponse(String response) {if (listener != null) {
=======
                public void onResponse(String response) {
                    try {
                        TPaymentBillDetail result;
                        result = BaseModule.doFromJSON(response, TPaymentBillDetail.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

>>>>>>> modify java template: add import:example/java/ref/rest/com/daigou/sg/rpc/payment/PaymentService.java
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(orderId);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserDeleteShipForMeOrder");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeAddressByRegion(final String originCode, final Listener<java.util.ArrayList<TShipformeAddress>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        java.util.ArrayList<TShipformeAddress> result;
                        result = BaseModule.fromJSONArray(response, TShipformeAddress.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(originCode);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserGetShipForMeAddressByRegion");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeHomeSummary(final TShipType shipType, final Listener<TShipForMeOrderHomeSummary> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TShipForMeOrderHomeSummary result;
                        result = BaseModule.fromJSON(response, TShipForMeOrderHomeSummary.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
<<<<<<< 426d8c35cacb2945a2e01575b9ca889913f8c645
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
=======
                final ArrayList<Object> params = new ArrayList<>();
>>>>>>> modify generated source files
                params.add(shipType);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserGetShipForMeHomeSummary");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeOrderDetailByOrderId(final int orderId, final Listener<TShipForMeOrder> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TShipForMeOrder result;
                        result = BaseModule.fromJSON(response, TShipForMeOrder.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(orderId);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserGetShipForMeOrderDetailByOrderId");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeOrderFeeByOrderIds(final java.util.ArrayList<String> orderIds, final boolean insured, final String deliveryMethod, final String shipmentTypeCode, final int customerAddressId, final String originCode, final String warehouseCode, final String couponCode, final Listener<TShipformeOrderBill> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TShipformeOrderBill result;
                        result = BaseModule.fromJSON(response, TShipformeOrderBill.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(orderIds);
                params.add(insured);
                params.add(deliveryMethod);
                params.add(shipmentTypeCode);
                params.add(customerAddressId);
                params.add(originCode);
                params.add(warehouseCode);
                params.add(couponCode);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserGetShipForMeOrderFeeByOrderIds");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeOrderListByStatus(final String originCode, final String warehouseCode, final String status, final int offset, final int limit, final Listener<java.util.ArrayList<TShipForMeOrder>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        java.util.ArrayList<TShipForMeOrder> result;
                        result = BaseModule.fromJSONArray(response, TShipForMeOrder.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(originCode);
                params.add(warehouseCode);
                params.add(status);
                params.add(offset);
                params.add(limit);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserGetShipForMeOrderListByStatus");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeSummary(final com.daigou.sg.rpc.payment.TPaymentType paymentType, final Listener<TShipForMeOrderSummary> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TShipForMeOrderSummary result;
                        result = BaseModule.fromJSON(response, TShipForMeOrderSummary.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
<<<<<<< 426d8c35cacb2945a2e01575b9ca889913f8c645
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
=======
                final ArrayList<Object> params = new ArrayList<>();
>>>>>>> modify generated source files
                params.add(paymentType);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserGetShipForMeSummary");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserPackShipForMeOrder(final java.util.ArrayList<String> orderIds, final boolean insured, final String deliveryMethod, final String shipmentTypeCode, final int customerAddressId, final String originCode, final String warehouseCode, final String couponCode, final Listener<Integer> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Integer result;
                        result = BaseModule.fromJSON(response, Integer.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(orderIds);
                params.add(insured);
                params.add(deliveryMethod);
                params.add(shipmentTypeCode);
                params.add(customerAddressId);
                params.add(originCode);
                params.add(warehouseCode);
                params.add(couponCode);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserPackShipForMeOrder");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserSaveShipForMeOrderPrice(final String orderIds, final double price, final Listener<Void> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
<<<<<<< 0536d024a95f5cb2a41bfd41472a5b9f94d7f4b1:example/java/ref/jsonrpc/com/daigou/sg/rpc/shipforme/ShipfForMeService.java
                public void onResponse(String response) {if (listener != null) {
=======
                public void onResponse(String response) {
                    try {
                        TPrimePaymentSummary result;
                        result = BaseModule.doFromJSON(response, TPrimePaymentSummary.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

>>>>>>> modify java template: add import:example/java/ref/rest/com/daigou/sg/rpc/payment/PaymentService.java
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(orderIds);
                params.add(price);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserSaveShipForMeOrderPrice");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserSendToTelephone(final String phoneNumber, final Listener<Boolean> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Boolean result;
                        result = BaseModule.fromJSON(response, Boolean.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(phoneNumber);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserSendToTelephone");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserUpdateShipForMeOrder(final int orderId, final String warehouseCode, final String shipperName, final String wayBill, final String alternative, final boolean takePhoto, final String repack, final Listener<Void> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
<<<<<<< 0536d024a95f5cb2a41bfd41472a5b9f94d7f4b1:example/java/ref/jsonrpc/com/daigou/sg/rpc/shipforme/ShipfForMeService.java
                public void onResponse(String response) {if (listener != null) {
=======
                public void onResponse(String response) {
                    try {
                        TPrimePaymentResult result;
                        result = BaseModule.doFromJSON(response, TPrimePaymentResult.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

>>>>>>> modify java template: add import:example/java/ref/rest/com/daigou/sg/rpc/payment/PaymentService.java
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(orderId);
                params.add(warehouseCode);
                params.add(shipperName);
                params.add(wayBill);
                params.add(alternative);
                params.add(takePhoto);
                params.add(repack);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserUpdateShipForMeOrder");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserValidationPhone(final String phoneNumber, final String validationCode, final Listener<Boolean> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getJsonRpcUrl(),
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Boolean result;
                        result = BaseModule.fromJSON(response, Boolean.class);

                        listener.onResponse(result);
                    } catch (Exception ex) {

                        // Log.d("ex", ex.toString());
                        // Log.d("jsonObject", response);

                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onResponse(null);
            }
        }) {
            @Override
            public byte[] getBody() {
                final java.util.ArrayList<Object> params = new java.util.ArrayList<>();
                params.add(phoneNumber);
                params.add(validationCode);

                java.util.HashMap<String, Object> msg = new java.util.HashMap<>();
                msg.put("id", getMsgID());
                msg.put("method", "ShipfForMe.UserValidationPhone");
                msg.put("params", params);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }
}
