package xyz.acrylicstyle;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.acrylicstyle.utils.PlayerConfigAPI;

import java.util.UUID;

@SuppressWarnings("unused")
public interface AdvancedAchievementsAPI {
    /**
     * Sets boolean value that drops extra inventory or not.
     * @param b If true, it will drop everything in the extra inventory. If false, it won't.
     */
    void setDropInventoryOnDeath(boolean b);

    /**
     * Gets player's extra inventory.
     * @param uuid The uuid of player
     * @return Their extra inventory
     */
    @NotNull
    Inventory getExtraInventory(UUID uuid);

    /**
     * Gets player's configuration.
     * @param uuid The uuid of player
     * @return A player's configuration.
     */
    @Nullable
    PlayerConfigAPI getPlayerConfiguration(UUID uuid);

    /**
     * Gets AdvancedAchievement instance.
     * @return AdvancedAchievement instance. May be null.
     */
    @Nullable
    static AdvancedAchievementsAPI getInstance() {
        RegisteredServiceProvider<AdvancedAchievementsAPI> provider = Bukkit.getServicesManager().getRegistration(AdvancedAchievementsAPI.class);
        if (provider != null) {
            return provider.getProvider();
        } else return null;
    }
}
