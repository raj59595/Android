package com.vivek.sampleapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vivek on 1/31/2018.
 */

public class ProductResources {
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("data")
    @Expose
    public List<Reviews> data = new ArrayList<>();

    public class Reviews {
        @SerializedName("user")
        @Expose
        private String user;
        @SerializedName("rating")
        @Expose
        private Integer rating;
        @SerializedName("body")
        @Expose
        private String body;
    }
}
