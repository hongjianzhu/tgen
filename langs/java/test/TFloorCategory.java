package com.daigou.sg.rpc.category;

import com.daigou.sg.rpc.BaseModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This file is auto-generated by tgen
 * Don't change manually
 */

public class TFloorCategory extends BaseModule<TFloorCategory> implements Serializable {

    public int id;
    public int parentId;
    public String name;
    public String picture;
    public String altName;
    public ArrayList<TCategory> subCategories;
    
}
