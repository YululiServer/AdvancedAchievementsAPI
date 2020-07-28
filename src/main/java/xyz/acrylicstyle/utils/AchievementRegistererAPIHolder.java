package xyz.acrylicstyle.utils;

import org.jetbrains.annotations.NotNull;
import util.Validate;

class AchievementRegistererAPIHolder {
    private static AchievementRegisterer instance = null;

    @NotNull
    public static AchievementRegisterer getInstance() {
        return Validate.notNull(instance, "instance isn't defined yet!");
    }

    public static void setInstance(@NotNull AchievementRegisterer instance) {
        if (AchievementRegistererAPIHolder.instance != null) throw new IllegalArgumentException("Cannot redefine instance");
        AchievementRegistererAPIHolder.instance = Validate.notNull(instance, "instance cannot be null");
    }
}
