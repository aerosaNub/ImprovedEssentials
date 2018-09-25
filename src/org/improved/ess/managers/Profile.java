package org.improved.ess.managers;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.improved.ess.Essentials;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

public class Profile {

    private String name;
    private String uuid;
    private File file;
    private YamlConfiguration configuration;

    public Profile(String name, String uuid) {
        this.file = new File(Essentials.getEssentials().getDataFolder(), name + ".yml");
        this.configuration = YamlConfiguration.loadConfiguration(file);
        this.name = name;
        this.uuid = uuid;
    }






}
