package com.example.omar.energy.module;

/**
 * Created by omar on 05/07/17.
 */

import java.util.List;

public class Room {

    private int roomId;
    private String roomName;
    private int roomImageId;
    private int KWH;
    private List<Device> deviceList;
    private int Temp;
    private int devicesNumber;

    public Room() {
    }

    public Room(String roomName, int roomImageId) {
        this.roomName = roomName;
        this.roomImageId = roomImageId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomImageId() {
        return roomImageId;
    }

    public void setRoomImageId(int roomImageId) {
        this.roomImageId = roomImageId;
    }

    public int getKWH() {
        return KWH;
    }

    public void setKWH(int KWH) {
        this.KWH = KWH;
    }

    public List<Device> getDeviceList() {
        return deviceList;
    }

    public void setDeviceList(List<Device> deviceList) {
        this.deviceList = deviceList;
    }

    public int getTemp() {
        return Temp;
    }

    public void setTemp(int temp) {
        Temp = temp;
    }

    public int getDevicesNumber() {
        return devicesNumber;
    }

    public void setDevicesNumber(int deviceNumber) {
        this.devicesNumber = deviceNumber;
    }
}
