package com.lulan.shincolle.handler;

import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.common.world.ForgeChunkManager;

/**
 * Chunk loader handler for 1.20.1 ForgeChunkManager.
 * <p>
 * In 1.20.1, chunk loading uses ForgeChunkManager.forceChunk/unforceChunk
 * directly, without the old LoadingCallback system.
 * <p>
 * Chunks are force-loaded by entity position and released when no longer
 * needed.
 */
public class ChunkLoaderHandler {

    /**
     * Force load a chunk at the given block position.
     *
     * @param level the server level
     * @param pos   the block position (converted to chunk coordinates)
     * @return true if chunk was successfully force-loaded
     */
    public static boolean forceChunk(ServerLevel level, BlockPos pos) {
        ChunkPos chunkPos = new ChunkPos(pos);
        boolean result = ForgeChunkManager.forceChunk(level, Reference.MOD_ID,
                pos, chunkPos.x, chunkPos.z, true, true);
        if (result) {
            LogHelper.debug("DEBUG: force loaded chunk at " + chunkPos);
        }
        return result;
    }

    /**
     * Unforce (release) a chunk at the given block position.
     *
     * @param level the server level
     * @param pos   the block position (converted to chunk coordinates)
     * @return true if chunk was successfully released
     */
    public static boolean unforceChunk(ServerLevel level, BlockPos pos) {
        ChunkPos chunkPos = new ChunkPos(pos);
        boolean result = ForgeChunkManager.forceChunk(level, Reference.MOD_ID,
                pos, chunkPos.x, chunkPos.z, false, true);
        if (result) {
            LogHelper.debug("DEBUG: released chunk at " + chunkPos);
        }
        return result;
    }
}
