package com.example.omar.energy.module;

/**
 * Created by omar on 19/03/17.
 */

public class Device {
    private String name;
    private int KWA;
    private int deviceImage;
    private String stutas;

    public Device() {
    }

    public Device(String name, int KWA, int deviceImage) {
        this.name = name;
        this.KWA = KWA;
        this.deviceImage = deviceImage;
        this.stutas = stutas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKWA() {
        return KWA;
    }

    public void setKWA(int KWA) {
        this.KWA = KWA;
    }

    public int getDeviceImage() {
        return deviceImage;
    }

    public void setDeviceImage(int deviceImage) {
        this.deviceImage = deviceImage;
    }
}
