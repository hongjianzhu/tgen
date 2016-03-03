package com.daigou.sg.rpc.category;

/**
 * This file is auto-generated by tgen
 * Don't change manually
 */

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.daigou.selfstation.utils.JsonUtils;
import com.daigou.selfstation.utils.NetworkError;
import com.daigou.selfstation.utils.RpcRequest;
import com.daigou.selfstation.system.AppUrl;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class CategoryService {
    private static final Gson gson = new Gson();
    private static int msgID = 1;
    private static RequestQueue queue;

    private CategoryService() {
        // Constructor hidden because this is a singleton
    }

    public static void init(RequestQueue requestQueue) {
        queue = requestQueue;
    }

    private static String getMsgID() {
        msgID += 1;
        return Integer.toString(msgID);
    }

    public static void GetAllProductCount(final int id, final String originCode, final Listener<Integer> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, AppUrl.kJsonRpcCoreUrl + "Category/GetAllProductCount",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Integer result;
                        JsonParser jp = JsonUtils.getJsonRpcResult(response);
                        
                        jp.nextToken();
                        result = jp.getIntValue();

                        jp.close();

                        listener.onResponse(result);
                    } catch (IOException ex) {
                        Log.d("ex", ex.toString());
                        Log.d("jsonObject", response);
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null && error.getCause() instanceof java.net.UnknownHostException) {
                    NetworkError.unKnowHost();
                } else if (error.networkResponse != null) {
                    NetworkError.networkError(error.networkResponse.statusCode);
                } else {
                    listener.onResponse(null);
                }
            }
        }) {
            @Override
            public byte[] getBody() {
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("id", id);
                msg.put("originCode", originCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        queue.add(req);
    }

    public static void GetPrimeProducts(final int id, final int offset, final int limit, final Listener<ArrayList<TProductSimple>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, AppUrl.kJsonRpcCoreUrl + "Category/GetPrimeProducts",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<TProductSimple> result;
                        JsonParser jp = JsonUtils.getJsonRpcResult(response);
                        
                        result = TProductSimple.fromJSONArray(jp);

                        jp.close();

                        listener.onResponse(result);
                    } catch (IOException ex) {
                        Log.d("ex", ex.toString());
                        Log.d("jsonObject", response);
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null && error.getCause() instanceof java.net.UnknownHostException) {
                    NetworkError.unKnowHost();
                } else if (error.networkResponse != null) {
                    NetworkError.networkError(error.networkResponse.statusCode);
                } else {
                    listener.onResponse(null);
                }
            }
        }) {
            @Override
            public byte[] getBody() {
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("id", id);
                msg.put("offset", offset);
                msg.put("limit", limit);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        queue.add(req);
    }

    public static void GetPrimeSubCategories(final int categoryId, final Listener<ArrayList<TCategory>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, AppUrl.kJsonRpcCoreUrl + "Category/GetPrimeSubCategories",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<TCategory> result;
                        JsonParser jp = JsonUtils.getJsonRpcResult(response);
                        
                        result = TCategory.fromJSONArray(jp);

                        jp.close();

                        listener.onResponse(result);
                    } catch (IOException ex) {
                        Log.d("ex", ex.toString());
                        Log.d("jsonObject", response);
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null && error.getCause() instanceof java.net.UnknownHostException) {
                    NetworkError.unKnowHost();
                } else if (error.networkResponse != null) {
                    NetworkError.networkError(error.networkResponse.statusCode);
                } else {
                    listener.onResponse(null);
                }
            }
        }) {
            @Override
            public byte[] getBody() {
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("categoryId", categoryId);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        queue.add(req);
    }

    public static void GetPrimeTopLevelCategories(final Listener<ArrayList<TCategory>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, AppUrl.kJsonRpcCoreUrl + "Category/GetPrimeTopLevelCategories",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<TCategory> result;
                        JsonParser jp = JsonUtils.getJsonRpcResult(response);
                        
                        result = TCategory.fromJSONArray(jp);

                        jp.close();

                        listener.onResponse(result);
                    } catch (IOException ex) {
                        Log.d("ex", ex.toString());
                        Log.d("jsonObject", response);
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null && error.getCause() instanceof java.net.UnknownHostException) {
                    NetworkError.unKnowHost();
                } else if (error.networkResponse != null) {
                    NetworkError.networkError(error.networkResponse.statusCode);
                } else {
                    listener.onResponse(null);
                }
            }
        }) {
            @Override
            public byte[] getBody() {
                return "".getBytes(Charset.forName("UTF-8"));
            }
        };
        queue.add(req);
    }

    public static void GetProducts(final int id, final int offset, final int limit, final String originCode, final Listener<ArrayList<TProductSimple>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, AppUrl.kJsonRpcCoreUrl + "Category/GetProducts",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<TProductSimple> result;
                        JsonParser jp = JsonUtils.getJsonRpcResult(response);
                        
                        result = TProductSimple.fromJSONArray(jp);

                        jp.close();

                        listener.onResponse(result);
                    } catch (IOException ex) {
                        Log.d("ex", ex.toString());
                        Log.d("jsonObject", response);
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null && error.getCause() instanceof java.net.UnknownHostException) {
                    NetworkError.unKnowHost();
                } else if (error.networkResponse != null) {
                    NetworkError.networkError(error.networkResponse.statusCode);
                } else {
                    listener.onResponse(null);
                }
            }
        }) {
            @Override
            public byte[] getBody() {
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("id", id);
                msg.put("offset", offset);
                msg.put("limit", limit);
                msg.put("originCode", originCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        queue.add(req);
    }

    public static void GetTopLevelCategories(final String originCode, final Listener<ArrayList<TCategory>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, AppUrl.kJsonRpcCoreUrl + "Category/GetTopLevelCategories",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<TCategory> result;
                        JsonParser jp = JsonUtils.getJsonRpcResult(response);
                        
                        result = TCategory.fromJSONArray(jp);

                        jp.close();

                        listener.onResponse(result);
                    } catch (IOException ex) {
                        Log.d("ex", ex.toString());
                        Log.d("jsonObject", response);
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null && error.getCause() instanceof java.net.UnknownHostException) {
                    NetworkError.unKnowHost();
                } else if (error.networkResponse != null) {
                    NetworkError.networkError(error.networkResponse.statusCode);
                } else {
                    listener.onResponse(null);
                }
            }
        }) {
            @Override
            public byte[] getBody() {
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("originCode", originCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        queue.add(req);
    }

    public static void SearchCategoryProducts(final String keyword, final int offset, final int limit, final int categoryId, final String originCode, final Listener<ArrayList<TProductSimple>> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, AppUrl.kJsonRpcCoreUrl + "Category/SearchCategoryProducts",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        ArrayList<TProductSimple> result;
                        JsonParser jp = JsonUtils.getJsonRpcResult(response);
                        
                        result = TProductSimple.fromJSONArray(jp);

                        jp.close();

                        listener.onResponse(result);
                    } catch (IOException ex) {
                        Log.d("ex", ex.toString());
                        Log.d("jsonObject", response);
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null && error.getCause() instanceof java.net.UnknownHostException) {
                    NetworkError.unKnowHost();
                } else if (error.networkResponse != null) {
                    NetworkError.networkError(error.networkResponse.statusCode);
                } else {
                    listener.onResponse(null);
                }
            }
        }) {
            @Override
            public byte[] getBody() {
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("keyword", keyword);
                msg.put("offset", offset);
                msg.put("limit", limit);
                msg.put("categoryId", categoryId);
                msg.put("originCode", originCode);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        queue.add(req);
    }

    public static void UserGetRecentPrimePurchaseDetail(final int paymentBillId, final int offset, final int limit, final Listener<TRecentPrimePurchase> listener) {
        RpcRequest req = new RpcRequest(Request.Method.POST, AppUrl.kJsonRpcCoreUrl + "Category/UserGetRecentPrimePurchaseDetail",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        TRecentPrimePurchase result;
                        JsonParser jp = JsonUtils.getJsonRpcResult(response);
                        
                        result = TRecentPrimePurchase.fromJSON(jp);

                        jp.close();

                        listener.onResponse(result);
                    } catch (IOException ex) {
                        Log.d("ex", ex.toString());
                        Log.d("jsonObject", response);
                        listener.onResponse(null);
                    }
                }
            }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.getCause() != null && error.getCause() instanceof java.net.UnknownHostException) {
                    NetworkError.unKnowHost();
                } else if (error.networkResponse != null) {
                    NetworkError.networkError(error.networkResponse.statusCode);
                } else {
                    listener.onResponse(null);
                }
            }
        }) {
            @Override
            public byte[] getBody() {
                HashMap<String, Object> msg = new HashMap<String, Object>();
                msg.put("paymentBillId", paymentBillId);
                msg.put("offset", offset);
                msg.put("limit", limit);

                return gson.toJson(msg).getBytes(Charset.forName("UTF-8"));
            }
        };
        queue.add(req);
    }
}