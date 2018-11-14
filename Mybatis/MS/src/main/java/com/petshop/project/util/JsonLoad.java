package com.petshop.project.util;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JsonLoad {
    @JsonProperty("data")
    private final List<Object> data = new ArrayList<Object>();


    @JsonProperty("total")
    private int total = 0;


    private boolean success = false;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void add(Object item) {



        if (item == null) return;

        if (item instanceof Collection) {

            for (Object object : (Collection) item) {
                data.add(object);
                total++;
            }

        } else {
            data.add(item);
            total++;
        }
    }
}
