package com.example.omar.energy;

/**
 * Created by omar on 19/03/17.
 */

public class Device {

    private int _id;
    private String name;
    private int KWH;
    private int usage_time;

    public Device(int usage_time, int KWH, String name) {
        this.usage_time = usage_time;
        this.KWH = KWH;
        this.name = name;
    }

    public int getUsage_time() {
        return usage_time;
    }

    public void setUsage_time(int usage_time) {
        this.usage_time = usage_time;
    }

    public int getKWH() {
        return KWH;
    }

    public void setKWH(int KWH) {
        this.KWH = KWH;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }
}
