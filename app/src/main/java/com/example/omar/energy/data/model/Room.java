package com.example.omar.energy.data.model;

import java.util.List;

/**
 * Created by omar on 11/07/17.
 */

public class Room {


    public static final String TAG = Room.class.getSimpleName();
    public static final String TABLE = "Room";

    // Room Table Columns names
    public static final String COLUMN_ROOM_ID = "room_id";
    public static final String COLUMN_ROOM_NAME = "room_name";
    public static final String COLUMN_ROOM_IMAGE = "room_image";
    public static final String COLUMN_ROOM_KWH = "room_kwh";
    public static final String COLUMN_ROOM_DEVICES_NUM = "room_device_num";

    public int roomId;
    public String roomName;
    public int roomImageId;
    public int KWH;
    public List<Device> deviceList;
    public int Temp;
    public int devicesNumber;

    public Room() {
    }

    public Room(int roomId, String roomName, List<Device> deviceList) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.deviceList = deviceList;
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
