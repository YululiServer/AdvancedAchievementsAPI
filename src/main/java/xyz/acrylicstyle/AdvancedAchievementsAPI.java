package xyz.acrylicstyle;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import util.Collection;
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
    Inventory getExtraInventory(@NotNull UUID uuid);

    /**
     * Sets player's extra inventory.
     */
    void setExtraInventory(@NotNull UUID player, @NotNull Inventory inventory);

    /**
     * Gets player's configuration.
     * @param uuid The uuid of player
     * @return A player's configuration.
     */
    @Nullable
    PlayerConfigAPI getPlayerConfiguration(@NotNull UUID uuid);

    /**
     * @param uuid The uuid of player
     * @param config A player's configuration.
     */
    void setPlayerConfiguration(@NotNull UUID uuid, @NotNull PlayerConfigAPI config);

    /**
     * Gets all players configuration.
     * @return All players configuration mapped by their UUID..
     */
    @NotNull
    Collection<UUID, PlayerConfigAPI> getPlayerConfiguration();

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
