package com.example.omar.energy.data.model;

/**
 * Created by omar on 14/07/17.
 */

public class RoomDevice {

    public String roomName;
    public String deviceName1;
    public String deviceName2;
    public boolean roomStatus;
    public boolean deviceStatus1;
    public boolean deviceStatus2;

    public RoomDevice(String roomName, String deviceName1, String deviceName2) {
        this.roomName = roomName;
        this.deviceName1 = deviceName1;
        this.deviceName2 = deviceName2;
        this.roomStatus=false;
        this.deviceStatus1=false;
        this.deviceStatus2=false;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDeviceName1() {
        return deviceName1;
    }

    public void setDeviceName1(String deviceName1) {
        this.deviceName1 = deviceName1;
    }

    public String getDeviceName2() {
        return deviceName2;
    }

    public void setDeviceName2(String deviceName2) {
        this.deviceName2 = deviceName2;
    }

    public boolean isRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public boolean isDeviceStatus1() {
        return deviceStatus1;
    }

    public void setDeviceStatus1(boolean deviceStatus1) {
        this.deviceStatus1 = deviceStatus1;
    }

    public boolean isDeviceStatus2() {
        return deviceStatus2;
    }

    public void setDeviceStatus2(boolean deviceStatus2) {
        this.deviceStatus2 = deviceStatus2;
    }
}
