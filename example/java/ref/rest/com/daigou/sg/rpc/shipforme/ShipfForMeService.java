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
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
public class ShipfForMeService {
    private static final Gson gson = GsonUtils.getGsonInstance();
    private static int msgID = 1;

    private ShipfForMeService() {
        // Constructor hidden because this is a singleton
    }

    private static String getMsgID() {
        msgID += 1;
        return Integer.toString(msgID);
    }

    public static RpcRequest GetCourierCompaniesByRegion(final String originCode, final Listener<ArrayList<String>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/GetCourierCompaniesByRegion",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<String> result;
                        result = BaseModule.doFromJSONArray(response, String.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("originCode", originCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserAddNewShipForMeOrder(final String warehouseCode, final String shipperName, final String wayBill, final String alternative, final boolean takePhoto, final String originCode, final String repack, final Listener<Integer> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserAddNewShipForMeOrder",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Integer result;
                        result = BaseModule.doFromJSON(response, Integer.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("warehouseCode", warehouseCode);
                msg.put("shipperName", shipperName);
                msg.put("wayBill", wayBill);
                msg.put("alternative", alternative);
                msg.put("takePhoto", takePhoto);
                msg.put("originCode", originCode);
                msg.put("repack", repack);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserConfirmShipForMeRepack(final boolean confirm, final int orderId, final Listener<Void> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserConfirmShipForMeRepack",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {if (listener != null) {
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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("confirm", confirm);
                msg.put("orderId", orderId);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserDeleteShipForMeOrder(final int orderId, final Listener<Void> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserDeleteShipForMeOrder",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {if (listener != null) {
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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("orderId", orderId);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeAddressByRegion(final String originCode, final Listener<ArrayList<TShipformeAddress>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserGetShipForMeAddressByRegion",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<TShipformeAddress> result;
                        result = BaseModule.doFromJSONArray(response, TShipformeAddress.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("originCode", originCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeHomeSummary(final Listener<TShipForMeOrderHomeSummary> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserGetShipForMeHomeSummary",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TShipForMeOrderHomeSummary result;
                        result = BaseModule.doFromJSON(response, TShipForMeOrderHomeSummary.class);

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
                return "".getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeOrderDetailByOrderId(final int orderId, final Listener<TShipForMeOrder> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserGetShipForMeOrderDetailByOrderId",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TShipForMeOrder result;
                        result = BaseModule.doFromJSON(response, TShipForMeOrder.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("orderId", orderId);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeOrderFeeByOrderIds(final ArrayList<String> orderIds, final boolean insured, final String deliveryMethod, final String shipmentTypeCode, final int customerAddressId, final String originCode, final String warehouseCode, final String couponCode, final Listener<TShipformeOrderBill> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserGetShipForMeOrderFeeByOrderIds",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TShipformeOrderBill result;
                        result = BaseModule.doFromJSON(response, TShipformeOrderBill.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("orderIds", orderIds);
                msg.put("insured", insured);
                msg.put("deliveryMethod", deliveryMethod);
                msg.put("shipmentTypeCode", shipmentTypeCode);
                msg.put("customerAddressId", customerAddressId);
                msg.put("originCode", originCode);
                msg.put("warehouseCode", warehouseCode);
                msg.put("couponCode", couponCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeOrderListByStatus(final String originCode, final String warehouseCode, final String status, final int offset, final int limit, final Listener<ArrayList<TShipForMeOrder>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserGetShipForMeOrderListByStatus",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<TShipForMeOrder> result;
                        result = BaseModule.doFromJSONArray(response, TShipForMeOrder.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("originCode", originCode);
                msg.put("warehouseCode", warehouseCode);
                msg.put("status", status);
                msg.put("offset", offset);
                msg.put("limit", limit);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserGetShipForMeSummary(final String originCode, final Listener<TShipForMeOrderSummary> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserGetShipForMeSummary",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TShipForMeOrderSummary result;
                        result = BaseModule.doFromJSON(response, TShipForMeOrderSummary.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("originCode", originCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserPackShipForMeOrder(final ArrayList<String> orderIds, final boolean insured, final String deliveryMethod, final String shipmentTypeCode, final int customerAddressId, final String originCode, final String warehouseCode, final String couponCode, final Listener<Integer> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserPackShipForMeOrder",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Integer result;
                        result = BaseModule.doFromJSON(response, Integer.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("orderIds", orderIds);
                msg.put("insured", insured);
                msg.put("deliveryMethod", deliveryMethod);
                msg.put("shipmentTypeCode", shipmentTypeCode);
                msg.put("customerAddressId", customerAddressId);
                msg.put("originCode", originCode);
                msg.put("warehouseCode", warehouseCode);
                msg.put("couponCode", couponCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserSaveShipForMeOrderPrice(final String orderIds, final double price, final Listener<Void> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserSaveShipForMeOrderPrice",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {if (listener != null) {
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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("orderIds", orderIds);
                msg.put("price", price);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserSendToTelephone(final String phoneNumber, final Listener<Boolean> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserSendToTelephone",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Boolean result;
                        result = BaseModule.doFromJSON(response, Boolean.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("phoneNumber", phoneNumber);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserUpdateShipForMeOrder(final int orderId, final String warehouseCode, final String shipperName, final String wayBill, final String alternative, final boolean takePhoto, final String repack, final Listener<Void> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserUpdateShipForMeOrder",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {if (listener != null) {
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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("orderId", orderId);
                msg.put("warehouseCode", warehouseCode);
                msg.put("shipperName", shipperName);
                msg.put("wayBill", wayBill);
                msg.put("alternative", alternative);
                msg.put("takePhoto", takePhoto);
                msg.put("repack", repack);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }

    public static RpcRequest UserValidationPhone(final String phoneNumber, final String validationCode, final Listener<Boolean> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, TRpc.getWebApiUrl() + "ShipfForMe/UserValidationPhone",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Boolean result;
                        result = BaseModule.doFromJSON(response, Boolean.class);

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
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("phoneNumber", phoneNumber);
                msg.put("validationCode", validationCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        TRpc.getQueue().add(req);
        return req;
    }
}
