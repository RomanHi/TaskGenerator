package ru.rikabc.generate.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Khayrullin on 21.09.2018
 * @version 1.0
 */
public class Result {
    public List<String> getRes() {
        return res;
    }

    public void setRes(List<String> res) {
        this.res = res;
    }

    private List<String> res = new ArrayList<>(12);
}
