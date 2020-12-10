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
    void addMiningPoints(@NotNull Material material);
    int getMiningPoints(@NotNull Material material);
    int getMiningPoints();
    void addBlocks(@NotNull Material material);
    int getBlocks(@NotNull Material material);
    int getBlocks();
    void addKillPoints(@NotNull EntityType entity);
    int getKillPoints(@NotNull EntityType entity);
    int getKillPoints();
    void setUnlocked(@NotNull AchievementAPI achievement);
    void revokeAchievement(@NotNull AchievementAPI achievement);
    boolean isUnlocked(@NotNull AchievementAPI achievement);
    void removePendingReward(@NotNull AchievementAPI achievement, int index);
    void addPendingReward(@NotNull AchievementAPI achievement);
    @NotNull
    ICollectionList<String> getPendingRewards();
    @NotNull
    List<String> getUnlockedAchievementsString();
    @NotNull
    CollectionList<AchievementAPI> getUnlockedAchievements();
    boolean hasUnlocked(@NotNull AchievementAPI achievement);
    void setLastFly(double time);
    double getLastFly();
    boolean canFly();
    void setInventory(@NotNull Inventory inventory);
    boolean hasInventory();
    @NotNull
    Inventory getInventory();
    int getPlayTime();
    void setPlayTime(int playTime);
    int getHoes();
    void setHoes(int hoes);
    long getItemBreaks(@NotNull Material material);
    void addItemBreaks(@NotNull Material material);
    void setItemBreaks(@NotNull Material material, long amount);
    long getCrafting(@NotNull Material material);
    void addCrafting(@NotNull Material material);
    void setCrafting(@NotNull Material material, long amount);
}
