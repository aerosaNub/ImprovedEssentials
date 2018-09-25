package org.improved.ess.managers;

import org.bukkit.World;
import org.improved.ess.flatfiles.WarpFlatFile;

public class Warps {

    private WarpFlatFile flatFile;
    private String warpName;
    private String world;
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;

    public Warps(WarpFlatFile flatFile, String warpName, String world, double x, double y, double z, float yaw, float pitch) {
        this.flatFile = flatFile;
        this.warpName = warpName;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public String getWorld() {
        return world;
    }

    public double getX() {
        return x;
    }

    public float getYaw() {
        return yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public String getWarpName() {
        return warpName;
    }

    public void setWarpName(String warpName) {
        this.warpName = warpName;
    }
}
