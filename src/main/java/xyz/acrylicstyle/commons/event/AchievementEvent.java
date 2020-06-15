package xyz.acrylicstyle.commons.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import xyz.acrylicstyle.commons.AchievementAPI;

import java.util.Objects;

public class AchievementEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel;
    private AchievementAPI achievement;
    private Player player;

    public AchievementEvent(AchievementAPI what, Player who) {
        this.achievement = Objects.requireNonNull(what);
        this.player = Objects.requireNonNull(who);
    }

    public AchievementAPI getAchievement() { return this.achievement; }

    public void setAchievement(AchievementAPI achievement) { this.achievement = achievement; }

    public Player getPlayer() { return this.player; }

    public void setPlayer(Player player) { this.player = player; }

    @NotNull
    @Override
    public HandlerList getHandlers() { return handlers; }

    public static HandlerList getHandlerList() { return handlers; }

    @Override
    public boolean isCancelled() { return cancel; }

    @Override
    public void setCancelled(boolean cancel) { this.cancel = cancel; }
}
