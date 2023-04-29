package com.justinschaaf.infinitifall.util;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class HandleUtil implements Listener {
    private static Boolean IS_PAPER_FOLIA = null;
    private static boolean tryTeleportAsync() {
        try {
            Class.forName("org.bukkit.event.player.PlayerTeleportEvent$TeleportCause");
            return true;
        } catch (ClassNotFoundException ignored) {
            Bukkit.getLogger().warning("This server does not support the Paper API, which may cause the plugin to not function properly.");
            return false;
        }
    }
    public static boolean isPaperFolia() {
        if (IS_PAPER_FOLIA == null) {
            IS_PAPER_FOLIA = tryTeleportAsync();
        }
        return IS_PAPER_FOLIA;
    }
}
