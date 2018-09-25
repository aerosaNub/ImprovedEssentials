package org.improved.ess.flatfiles;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.improved.ess.Essentials;
import org.improved.ess.managers.EzLocation;

import javax.xml.stream.Location;
import java.io.File;
import java.util.concurrent.ExecutionException;

public class SpawnFile
{

    private Essentials essentials;

    private Location spawnLocation;

    private File file = new File(this.essentials.getDataFolder(), "spawn.yml");
    private YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    public SpawnFile(Essentials essentials) {
        this.essentials = essentials;

        loadCoordinates();
    }

    public void loadCoordinates() {
        if (this.file.exists()) {
            YamlConfiguration.loadConfiguration(file);

            new EzLocation(
                    configuration.getString("Spawn.World"),
                    configuration.getDouble("Spawn.X"),
                    configuration.getDouble("Spawn.Y"),
                    configuration.getDouble("Spawn.Z"),
                    (float) configuration.getDouble("Spawn.Yaw"),
                    (float) configuration.getDouble("Spawn.Pitch"));
        } else {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Couldn't create spawn.yml!");
            }
        }
    }


}
