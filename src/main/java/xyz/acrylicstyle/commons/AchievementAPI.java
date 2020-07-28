package xyz.acrylicstyle.commons;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import util.Collection;
import util.CollectionList;

@SuppressWarnings("unused")
public interface AchievementAPI {
    /**
     * Returns the id of the this achievement.
     * @return the id
     */
    @NotNull
    String getNamespacedId();

    /**
     * Returns the namespaced key of the this achievement.
     * @return the namespaced key
     */
    @NotNull
    NamespacedKey getNamespacedKey();

    /**
     * Currently not used, do not use this for any reason.
     * @deprecated Draft API
     * @return always returns null.
     */
    @Deprecated
    String getParentNamespacedId();

    /**
     * Returns the name of this achievement.
     * @return the achievement name
     */
    @NotNull
    String getName();

    /**
     * Returns the defined description of the this achievement.
     * @return the description
     */
    String getDescription();

    /**
     * Returns if this is the challenge or not.
     */
    boolean isChallenge();

    /**
     * Returns the full name of the achievement.
     * Returns name with dark purple if challenge, green if not.
     */
    String getFullName();

    /**
     * Returns the full name with hover text (TextComponent).
     * @return the TextComponent that will be sent to the player when unlocked.
     */
    TextComponent getFullNameWithHoverText();

    /**
     * Returns the list of the unlock enum, the achievement will be unlocked if all conditions were met.
     */
    CollectionList<Unlock> getUnlock();

    /**
     * Returns the unlock condition.
     * @return the unlock condition
     */
    UnlockCondition getCondition();

    /**
     * Returns the material that will be shown on the achievement list.
     * @return the material
     */
    Material getMaterial();

    /**
     * Returns the item that will be shown on the achievement list.
     * @return the item
     */
    ItemStack getItemStack();

    /**
     * Returns the list of the items that will be rewarded on unlock.
     * @return the item list
     */
    CollectionList<ItemStack> getReward();
    String getRewardParticle();
    String getRewardParticleType();

    /**
     * Returns true if reveals unlock condition if player hasn't unlocked.
     */
    boolean isRevealCondition();

    /**
     * Returns the permissions that will be granted on unlock.
     * @return the permission list
     */
    CollectionList<String> getRewardPermissions();

    /**
     * Returns the user-defined rewards list.
     * @return the list of the rewards
     */
    CollectionList<String> getRewardList();

    /**
     * Returns if this achievement is hidden (not shown while player hasn't unlocked)
     */
    boolean isHidden();

    /**
     * Unlocks the achievement immediately.
     * @param player the online player. messages will be sent and notified.
     */
    void unlock(Player player);

    /**
     * Unlocks the achievement immediately.
     * @param player the offline player. messages will not be sent.
     */
    void unlock(OfflinePlayer player);


    enum Unlock {
        ITEM, // => items
        JOIN, // => nothing
        KILL, // => killPoints
        LOCATION, // => location
        BLOCK_PLACE, // => blocks
        BLOCK_BREAK, // => miningPoints
        PLAY_TIME, // => data
        DAMAGE_TAKEN, // => data
        DAMAGE_DEALT, // => data
        HOE, // => data
        ITEM_BREAK, // => items
        NEVER, // => nothing
    }

    class UnlockCondition {
        private Collection<Material, Integer> items = null;
        private Collection<Material, Integer> miningPoints = null;
        private Collection<Material, Integer> blocks = null;
        private Collection<EntityType, Integer> killPoints = null;
        private int data = Integer.MAX_VALUE; // it was playTime previously
        private Location location = null;

        public UnlockCondition setItems(Collection<Material, Integer> items) {
            this.items = items == null || items.size() == 0 ? null : items;
            return this;
        }

        public UnlockCondition setMiningPoints(Collection<Material, Integer> points) {
            this.miningPoints = points == null || points.size() == 0 ? null : points;
            return this;
        }

        public UnlockCondition setBlocks(Collection<Material, Integer> points) {
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

        public Collection<Material, Integer> getMiningPoints() {
            return miningPoints;
        }

        public Collection<Material, Integer> getBlocks() {
            return blocks;
        }

        public Collection<Material, Integer> getItems() {
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
