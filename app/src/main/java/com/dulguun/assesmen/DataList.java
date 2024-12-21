package com.dulguun.assesmen;

public class DataList {
    private String address;
    private String suburb;
    private String state;
    private String postcode;
    private String price;

    public DataList(String address, String suburb, String state, String postcode, String price) {
        this.address = address;
        this.suburb = suburb;
        this.state = state;
        this.postcode = postcode;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }
    public String getSuburb(){
        return suburb;
    }
    public String getState(){
        return state;
    }
    public String getPostcode(){
        return postcode;
    }
    public String getPrice() {
        return price;
    }

    public String setAddress(String address) {
        this.address = address;
        return address;
    }
    public String setSuburb(String suburb){
        this.suburb = suburb;
        return suburb;
    }
    public String setState(String state){
        this.state = state;
        return state;
    };
    public String setPostcode(String postcode){
        this.postcode = postcode;
        return postcode;
    };
    public String setPrice(String price) {
        this.price = price;
        return price;
    }
}
