package xyz.acrylicstyle.commons;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import util.Collection;
import util.CollectionList;
import xyz.acrylicstyle.utils.Material2;

@SuppressWarnings("unused")
public interface AchievementAPI {
    String getNamespacedId();
    String getName();
    String getDescription();
    boolean isChallenge();
    String getFullName();
    TextComponent getFullNameWithHoverText();
    CollectionList<Unlock> getUnlock();
    UnlockCondition getCondition();
    Material getMaterial();
    ItemStack getItemStack();
    CollectionList<ItemStack> getReward();
    String getRewardParticle();
    String getRewardParticleType();
    boolean isRevealCondition();
    CollectionList<String> getRewardPermissions();
    CollectionList<String> getRewardList();
    boolean isHidden();
    void unlock(Player player);
    void unlock(OfflinePlayer player);


    enum Unlock {
        ITEM,
        JOIN,
        KILL,
        LOCATION,
        BLOCK_PLACE,
        BLOCK_BREAK,
        PLAY_TIME,
        DAMAGE_TAKEN,
        DAMAGE_DEALT,
        NEVER,
    }

    class UnlockCondition {
        private Collection<Material2, Integer> items = null;
        private Collection<Material2, Integer> miningPoints = null;
        private Collection<Material2, Integer> blocks = null;
        private Collection<EntityType, Integer> killPoints = null;
        private int data = Integer.MAX_VALUE; // it was playTime previously
        private Location location = null;

        public UnlockCondition setItems(Collection<Material2, Integer> items) {
            this.items = items == null || items.size() == 0 ? null : items;
            return this;
        }

        public UnlockCondition setMiningPoints(Collection<Material2, Integer> points) {
            this.miningPoints = points == null || points.size() == 0 ? null : points;
            return this;
        }

        public UnlockCondition setBlocks(Collection<Material2, Integer> points) {
            this.blocks = points == null || points.size() == 0 ? null : points;
            return this;
        }

        public UnlockCondition setKillPoints(Collection<EntityType, Integer> killPoints) {
            this.killPoints = killPoints == null || killPoints.size() == 0 ? null : killPoints;
            return this;
        }

        public UnlockCondition setLocation(Location location) {
            this.location = location;
            return this;
        }

        public UnlockCondition setData(int data) {
            this.data = data;
            return this;
        }

        public Collection<Material2, Integer> getMiningPoints() {
            return miningPoints;
        }

        public Collection<Material2, Integer> getBlocks() {
            return blocks;
        }

        public Collection<Material2, Integer> getItems() {
            return items;
        }

        public Collection<EntityType, Integer> getKillPoints() {
            return killPoints;
        }

        public Location getLocation() {
            return location;
        }

        public int getData() {
            return data;
        }
    }
}
