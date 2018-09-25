package org.improved.ess.managers;

import org.bukkit.Bukkit;
import org.improved.ess.Essentials;

public class ChatHandler {

    private boolean mutechat = false;
    private int chatDelayTime = 0;
    private long slowchat = 0L;

    public static ChatHandler get() {
       return Essentials.getEssentials().getChatHandler();
    }

    public void clearChat() {
        for (int i = 0; i < 100; i++ ){
            Bukkit.broadcastMessage(" ");
        }
    }

    public void setMutechat(boolean b) {
        this.mutechat = b;
    }

    public boolean chatIsMuted() {
        return this.mutechat;
    }

    public void setChatDelayTime(int time) {
        this.chatDelayTime = time;
    }

    public void setSlowchat(long slowchat) {
        this.slowchat = slowchat;
    }

    public int getChatDelayTime() {
        return this.chatDelayTime;
    }

    public long getSlowchat() {
        return this.slowchat;
    }
}
