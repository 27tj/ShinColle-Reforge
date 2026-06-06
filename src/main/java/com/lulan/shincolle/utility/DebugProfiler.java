package com.lulan.shincolle.utility;

import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;

/**
 * Small helper for runtime profiling instrumentation.
 *
 * <p>This wrapper keeps profiling calls null-safe so debug instrumentation can be
 * added to hot paths without changing game behavior.</p>
 */
public final class DebugProfiler {

    private DebugProfiler() {
    }

    /**
     * Pushes a profiler section and returns the used profiler instance.
     *
     * @param level   level used to obtain {@link ProfilerFiller}
     * @param section profiler section name
     * @return profiler instance or {@code null} if unavailable
     */
    public static ProfilerFiller push(Level level, String section) {
        if (level == null) {
            return null;
        }

        ProfilerFiller profiler = level.getProfiler();
        profiler.push(section);
        return profiler;
    }

    /**
     * Pops a profiler section when profiler exists.
     *
     * @param profiler profiler instance returned by {@link #push(Level, String)}
     */
    public static void pop(ProfilerFiller profiler) {
        if (profiler != null) {
            profiler.pop();
        }
    }

    /**
     * Increments a profiler counter when profiler exists.
     *
     * @param profiler profiler instance
     * @param key      counter key
     */
    public static void count(ProfilerFiller profiler, String key) {
        if (profiler != null) {
            profiler.incrementCounter(key);
        }
    }
}