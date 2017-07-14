package com.example.omar.energy.data.model;

/**
 * Created by omar on 11/07/17.
 */

public class Device {

    public static final String TAG = Device.class.getSimpleName();
    public static final String TABLE = "Device";
    // Deice Table Columns names
    public static final String COLUMN_DEVICE_ID = "device_id";
    public static final String COLUMN_DEVICE_NAME = "device_name";
    public static final String COLUMN_DEVICE_IMAGE = "device_image";
    public static final String COLUMN_DEVICE_KWH = "device_kwh";
    public static final String COLUMN_DEVICE_USAGE_TIME = "device_usage_time";
    public static final String COLUMN_DEVICE_STATUS = "device_status";
    public static final String COLUMN_FOREIGN_EY = "fk_room";


    public int deviceId;
    public int deviceRoomId;
    public String deviceName;
    public int KWH;
    public int deviceImage;
    public String stutas;
    public int deviceUsageTime;
    public boolean status;

    public Device() {
    }

    public Device(String name, int KWH, int deviceImage) {
        this.deviceName = name;
        this.KWH = KWH;
        this.deviceImage = deviceImage;
        this.stutas = stutas;
    }

    public Device(int deviceId,String deviceName, int KWH, int deviceUsageTime, boolean status) {
        this.deviceId = deviceId;
        this.KWH = KWH;
        this.deviceUsageTime = deviceUsageTime;
        this.status = status;
        this.deviceName=deviceName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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


