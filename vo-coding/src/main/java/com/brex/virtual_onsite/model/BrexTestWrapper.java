package com.brex.virtual_onsite.model;

import java.util.List;

public class BrexTestWrapper {

    private List<Company> data;

    public List<Company> getData() {
        return data;
    }

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
