package com.nidhigondhia.productcatalogue.model;

/**
 * Created by NIDHI on 3/12/2016.
 */
public class Product {
    private String price;
    private String image_url;
    private Integer is_feature;
    private String feature_image_url;
    private String name;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getIs_feature() {
        return is_feature;
    }

    public void setIs_feature(Integer is_feature) {
        this.is_feature = is_feature;
    }

    public String getFeature_image_url() {
        return feature_image_url;
    }

    public void setFeature_image_url(String feature_image_url) {
        this.feature_image_url = feature_image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
