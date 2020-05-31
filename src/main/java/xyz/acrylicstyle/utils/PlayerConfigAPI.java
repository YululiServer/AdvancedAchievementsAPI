package xyz.acrylicstyle.utils;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;
import util.CollectionList;
import util.ICollectionList;
import xyz.acrylicstyle.commons.AchievementAPI;

import java.util.List;
import java.util.UUID;

@SuppressWarnings("unused")
public interface PlayerConfigAPI {
    @NotNull
    UUID getUniqueId();
    void addMiningPoints(Material material);
    int getMiningPoints(Material2 material);
    int getMiningPoints();
    void addBlocks(Material material);
    int getBlocks(Material2 material);
    int getBlocks();
    void addKillPoints(EntityType entity);
    int getKillPoints(EntityType entity);
    int getKillPoints();
    void setUnlocked(AchievementAPI achievement);
    void revokeAchievement(AchievementAPI achievement);
    boolean isUnlocked(AchievementAPI achievement);
    void removePendingReward(AchievementAPI achievement, int index);
    void addPendingReward(AchievementAPI achievement);
    ICollectionList<String> getPendingRewards();
    List<String> getUnlockedAchievementsString();
    CollectionList<AchievementAPI> getUnlockedAchievements();
    boolean hasUnlocked(AchievementAPI achievement);
    void setLastFly(double time);
    double getLastFly();
    boolean canFly();
    void setInventory(Inventory inventory);
    boolean hasInventory();
    Inventory getInventory();
}
