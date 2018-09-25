package org.improved.ess.managers;

import org.bukkit.World;

public class EzLocation {

    private String world;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;

    public EzLocation(String world, double x, double y, double z, float yaw, float pitch) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public String getWorld() {
        return world;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setZ(double z) {
        this.z = z;
    }
}


