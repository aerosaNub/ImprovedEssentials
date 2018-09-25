package org.improved.ess.flatfiles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;
import org.improved.ess.managers.Warps;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class WarpFlatFile {

    private Essentials essentials;
    private File file;
    private YamlConfiguration configuration;

    private ArrayList<Warps> warps = new ArrayList<>();

    public WarpFlatFile(Essentials essentials) {
        this.essentials = essentials;
        this.file = new File(this.essentials.getDataFolder(), "warps.yml");
        this.configuration = YamlConfiguration.loadConfiguration(file);

        loadWarps();
    }

    public void loadWarps() {
        if (this.file.exists()) {
            for (String key : this.configuration.getConfigurationSection("Warps").getKeys(false)) {
              new Warps(this,
                        this.configuration.getString("Warps." + key + ".name"),
                        this.configuration.getString("Warps." + key + ".world"),
                        this.configuration.getInt("Warps." + key + ".x"),
                        this.configuration.getInt("Warps." + key + ".y"),
                        this.configuration.getInt("Warps." + key + ".z"),
                        (float) this.configuration.getDouble("Warps." + key + ".yaw"),
                        (float) this.configuration.getDouble("Warps." + key + ".pitch"));
            }

            YamlConfiguration.loadConfiguration(file);
        } else {
            try {
                this.file.createNewFile();
                this.configuration.set("Warps", null);
                this.configuration.save(file);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void createWarps(Player player, String name) {

        Warps warp =  new Warps(this, name, player.getWorld().getName(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());

        warp.setWarpName(name);

        this.file = new File(this.essentials.getDataFolder(), "warps.yml");


        if (this.file.exists()) {
            this.configuration.set("Warps." + name + ".name", name);
            this.configuration.set("Warps." + name + ".world", player.getWorld().getName());
            this.configuration.set("Warps." + name + ".x", player.getLocation().getX());
            this.configuration.set("Warps." + name + ".y", player.getLocation().getY());
            this.configuration.set("Warps." + name + ".z", player.getLocation().getZ());
            this.configuration.set("Warps." + name + ".yaw", player.getLocation().getYaw());
            this.configuration.set("Warps." + name + ".pitch", player.getLocation().getPitch());
        } else {
            this.file = new File(this.essentials.getDataFolder(), "warps.yml");

            this.configuration = YamlConfiguration.loadConfiguration(file);
            this.configuration.set("Warps." + name + ".name", name);
            this.configuration.set("Warps." + name + ".world", player.getWorld().getName());
            this.configuration.set("Warps." + name + ".x", player.getLocation().getX());
            this.configuration.set("Warps." + name + ".y", player.getLocation().getY());
            this.configuration.set("Warps." + name + ".z", player.getLocation().getZ());
            this.configuration.set("Warps." + name + ".yaw", player.getLocation().getYaw());
            this.configuration.set("Warps." + name + ".pitch", player.getLocation().getPitch());

            try {
                save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        warps.add(warp);
    }



    public void reloadConfig() {
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            InputStream defConfigStream = Bukkit.getPluginManager().getPlugin("ImprovedEssentials").getResource("warps.yml");
            if (defConfigStream != null) {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
                if (!(this.file.exists()) || (this.file.length() == 0L)) {
                    configuration.setDefaults(defConfig);
                }
            }
        }
    }

    public FileConfiguration getConfiguration() {
        if (this.file == null) {
            reloadConfig();
        }
        return this.configuration;
    }

    public void save() {
        if ((configuration == null) || (file == null)) {
            return;
        }
        try {
            this.configuration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
