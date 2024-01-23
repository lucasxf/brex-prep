package com.brex.virtual_onsite.model;

import java.util.List;

public class BrexTestWrapper {

    private List<Company> data;

    // required by jackson
    public List<Company> getData() {
        return data;
    }

    // required by jackson
    public void setData(List<Company> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BrexTestWrapper{" +
                "data=" + data +
                '}';
    }

}
