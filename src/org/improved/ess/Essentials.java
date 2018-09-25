package org.improved.ess;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.improved.ess.commands.*;
import org.improved.ess.commands.chat.BroadcastCommand;
import org.improved.ess.commands.chat.ClearChatCommand;
import org.improved.ess.commands.chat.MuteChatCommand;
import org.improved.ess.commands.kits.CreateKitCommand;
import org.improved.ess.commands.kits.KitsCommand;
import org.improved.ess.commands.kits.RemoveKitCommand;
import org.improved.ess.commands.spawn.SetSpawnCommand;
import org.improved.ess.commands.spawn.SpawnCommand;
import org.improved.ess.commands.staffmode.StaffModeCommand;
import org.improved.ess.commands.teleportation.TeleportAllCommand;
import org.improved.ess.commands.teleportation.TeleportCommand;
import org.improved.ess.commands.teleportation.TeleportHereCommand;
import org.improved.ess.commands.teleportation.TeleportPositionCommand;
import org.improved.ess.commands.warp.SetWarpCommand;
import org.improved.ess.commands.warp.WarpCommand;
import org.improved.ess.flatfiles.KitFile;
import org.improved.ess.flatfiles.WarpFlatFile;
import org.improved.ess.listeners.ServerListener;
import org.improved.ess.managers.ChatHandler;
import org.improved.ess.managers.PlayerHandler;
import org.improved.ess.managers.Profile;
import org.improved.ess.managers.Vanish;

import java.util.ArrayList;
import java.util.List;

public class Essentials extends JavaPlugin {

    private List<String> commands = new ArrayList<>();

    private static Essentials essentials;
    private Profile profile;
    private ChatHandler chatHandler;
    private WarpFlatFile warpFlatFile;
    private Vanish vanish;
    private PlayerHandler playerHandler;
    private KitFile kitFile;

    public void onEnable() {
        essentials = this;

        registerCommands();
        registerHandlers();
        registerListeners();
    }

    public void onDisable() {
        essentials = null;
    }

    public void registerHandlers() {
        this.chatHandler = new ChatHandler();
        this.vanish = new Vanish();
        this.playerHandler = new PlayerHandler();
        this.warpFlatFile = new WarpFlatFile(this);
        this.kitFile = new KitFile(this);
    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new ServerListener(), this);
    }

    public void registerCommands() {
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("chat").setExecutor(new MuteChatCommand());
        getCommand("clearinventory").setExecutor(new ClearInventoryCommand());
        getCommand("flight").setExecutor(new FlightCommand());
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("god").setExecutor(new GodCommand());
      //  getCommand("nick").setExecutor(new NickCommand());
       // getCommand("vanish").setExecutor(new VanishCommand());
      //  getCommand("setspawn").setExecutor(new SetSpawnCommand());
      //  getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("teleport").setExecutor(new TeleportCommand());
        getCommand("teleporthere").setExecutor(new TeleportHereCommand());
        getCommand("teleportposition").setExecutor(new TeleportPositionCommand());
        getCommand("teleportall").setExecutor(new TeleportAllCommand());
       // getCommand("setwarp").setExecutor(new SetWarpCommand());
       // getCommand("warp").setExecutor(new WarpCommand());
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("kits").setExecutor(new KitsCommand());
        getCommand("createkit").setExecutor(new CreateKitCommand());
        getCommand("removekit").setExecutor(new RemoveKitCommand());
       // getCommand("staffmode").setExecutor(new StaffModeCommand());
    }

    public static Essentials getEssentials() {
        return essentials;
    }

    public Profile getProfile() {
        return profile;
    }

    public ChatHandler getChatHandler() {
        return chatHandler;
    }

    public WarpFlatFile getWarpFlatFile() {
        return warpFlatFile;
    }

    public Vanish getVanish() {
        return vanish;
    }

    public PlayerHandler getPlayerHandler() {
        return playerHandler;
    }

    public KitFile getKitFile() {
        return kitFile;
    }
}
