package xyz.acrylicstyle.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import util.CollectionList;
import xyz.acrylicstyle.commons.AchievementAPI;

import java.util.function.Function;

public interface AchievementRegisterer {
    static void setInstance(@NotNull AchievementRegisterer instance) {
        AchievementRegistererAPIHolder.setInstance(instance);
    }

    /**
     * Returns the current active instance.
     */
    @Contract(pure = true)
    @NotNull
    static AchievementRegisterer getInstance() {
        return AchievementRegistererAPIHolder.getInstance();
    }

    /**
     * Returns the list of the advancement files.
     * The returned list contains only file names, not the absolute path.
     */
    @NotNull
    CollectionList<String> getAdvancementFiles();

    @NotNull
    CollectionList<AchievementAPI> getAchievements();

    @NotNull
    CollectionList<AchievementAPI> filterAchievements(Function<AchievementAPI, Boolean> predicate); // todo - it should be Predicate<AchievementAPI>?
}
