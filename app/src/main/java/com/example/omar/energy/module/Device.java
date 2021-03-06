package com.example.omar.energy.module;

/**
 * Created by Lincoln on 18/05/16.
 */
public class Device {
    private int deviceId;
    private int deviceRoomId;
    private String deviceName;
    private int KWH;
    private int deviceImage;
    private String stutas;
    private int deviceUsageTime;

    public Device() {
    }

    public Device(String name, int KWH, int deviceImage) {
        this.deviceName = name;
        this.KWH = KWH;
        this.deviceImage = deviceImage;
        this.stutas = stutas;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getDeviceRoomId() {
        return deviceRoomId;
    }

    public void setDeviceRoomId(int deviceRoomId) {
        this.deviceRoomId = deviceRoomId;
    }

    public String getStutas() {
        return stutas;
    }

    public void setStutas(String stutas) {
        this.stutas = stutas;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getKWH() {
        return KWH;
    }

    public void setKWH(int KWH) {
        this.KWH = KWH;
    }

    public int getDeviceImage() {
        return deviceImage;
    }

    public void setDeviceImage(int deviceImage) {
        this.deviceImage = deviceImage;
    }

    public int getDeviceUsageTime() {
        return deviceUsageTime;
    }

    public void setDeviceUsageTime(int deviceUsageTime) {
        this.deviceUsageTime = deviceUsageTime;
    }
}
