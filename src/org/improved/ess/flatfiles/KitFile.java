package org.improved.ess.flatfiles;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.improved.ess.Essentials;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class KitFile {

    private Essentials ess;
    private File file;
    private YamlConfiguration configuration;

    public KitFile(Essentials ess) {
        this.ess = ess;
        this.file = new File(this.ess.getDataFolder(), "kits.yml");
        this.configuration = YamlConfiguration.loadConfiguration(file);
    }

    public void createKit(Player p, String name) {
        this.configuration.set("ServerKits." + name.toLowerCase() + ".armor", p.getInventory().getArmorContents());
        this.configuration.set("ServerKits." + name.toLowerCase() + ".items", p.getInventory().getContents());

        save();
    }

    public void removeKit(Player p, String kitname) {
        this.configuration.set("ServerKits." + kitname.toLowerCase(), null);

        save();
    }

    public void loadKit(Player p, String name) {
        ItemStack[] items = ((List<ItemStack[]>)this.configuration.get("ServerKits." + name.toLowerCase() + ".items")).toArray(new ItemStack[0]);
        ItemStack[] armor = ((List<ItemStack[]>)this.configuration.get("ServerKits." + name.toLowerCase() + ".armor")).toArray(new ItemStack[0]);

        p.getInventory().setArmorContents(armor);
        p.getInventory().setContents(items);

        save();
    }

    public void reloadConfig() {
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            InputStream defConfigStream = Bukkit.getPluginManager().getPlugin("ImprovedEssentials").getResource("kits.yml");
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
