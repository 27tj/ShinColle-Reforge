package com.lulan.shincolle.utility;

import com.lulan.shincolle.block.BasicBlockMulti;
import com.lulan.shincolle.init.ModBlocks;
import com.lulan.shincolle.tileentity.BasicTileMulti;
import com.lulan.shincolle.tileentity.TileMultiGrudgeHeavy;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MulitBlockHelper {

    /**
     * pattern array [type][x][y][z]
     * type: 0:large shipyard 1:large workshop
     * value: -1:other 0:water,air 1:polymetal 2:grudge
     * <p>
     * TYPE 0001 - Large Shipyard: o:polymetal block g:heavy grudge block
     * 1.ooo 2.o o 4.
     * ooo g
     * ooo o o
     */
    private static final byte[][][][] PATTERN = {
            // type 0001:
            { // y = 0 y = 1 y = 2
                    {{1, 1, 1}, {1, -1, 1}, {-1, -1, -1}}, // x = 0
                    {{1, 1, 1}, {-1, -1, -1}, {-1, 2, -1}}, // x = 1
                    {{1, 1, 1}, {1, -1, 1}, {-1, -1, -1}} // x = 2
            }
    };

    public MulitBlockHelper() {
    }

    private static boolean hasValidLargeShipyardCore(Level level, BlockPos corePos) {
        BlockEntity coreTile = level.getBlockEntity(corePos);
        return coreTile instanceof TileMultiGrudgeHeavy core && core.hasCorePos();
    }

    public static void printPattern() {
        LogHelper.info("INFO: PATTERN len " + PATTERN.length + " " + PATTERN[0].length + " " + PATTERN[0][0].length
                + " " + PATTERN[0][0][0].length);

        for (int i = 0; i < PATTERN.length; i++) {
            LogHelper.info("INFO: PATTERN TYPE " + i);
            for (int x = 0; x < PATTERN[i].length; x++) {
                LogHelper.info("INFO: PATTERN X = " + x);
                for (int y = PATTERN[i][x].length - 1; y >= 0; y--) {
                    LogHelper.info("INFO: PATTERN   " + PATTERN[i][x][y][2] + "," + PATTERN[i][x][y][1] + ","
                            + PATTERN[i][x][y][0]);
                }
            }
        }
    }

    /**
     * CHECK MULTI BLOCK FORM
     * called when RIGHT CLICK heavy grudge block
     * (heavy grudge block is always at TOP-MIDDLE, so check X+-1 Y-2 Z+-1)
     */
    public static int checkMultiBlockForm(Level level, int xCoord, int yCoord, int zCoord) {
        BlockState state;
        BlockPos pos;
        Block block;
        int blockType;
        int patternTemp;
        int patternMatch = 1; // init match pattern = 0001 (bit)

        // [PORT] 1.10.2 -> 1.20.1: world min build height can be negative; the
        // original y<3 guard should map to "need 2 blocks below core" relative to
        // current world floor instead of absolute Y=3.
        if (yCoord < level.getMinBuildHeight() + 2)
            return -1;

        // scan a 3x3x3 area
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                for (int z = 0; z < 3; z++) {
                    pos = new BlockPos(xCoord - 1 + x, yCoord - 2 + y, zCoord - 1 + z);

                    // 1. get block
                    state = level.getBlockState(pos);
                    block = state.getBlock();

                    blockType = -1;
                    if (block == ModBlocks.POLYMETAL.get())
                        blockType = 1;
                    if (block == ModBlocks.GRUDGE_HEAVY.get())
                        blockType = 2;
                    LogHelper.debug("DEBUG: multi block check: pos " + pos.getX() + " " + pos.getY() + " "
                            + pos.getZ() + " " + block + " " + blockType);

                    // 2. match pattern
                    patternTemp = 0;
                    for (int t = 0; t < PATTERN.length; t++) {
                        if (blockType == PATTERN[t][x][y][z]) {
                            patternTemp += (int) Math.pow(2, t);
                        }
                    }
                    patternMatch = (patternMatch & patternTemp);

                    LogHelper.debug("DEBUG: check structure: type " + patternMatch + " " + patternTemp);
                    if (patternMatch == 0)
                        return -1;

                    // 3. check core block - only unowned blocks can join
                    if (blockType > 0) {
                        BlockEntity t = level.getBlockEntity(pos);
                        if (t instanceof BasicTileMulti bm && bm.hasCorePos()) {
                            if (hasValidLargeShipyardCore(level, bm.getCorePos())) {
                                return -1;
                            }
                            // [PORT] 1.10.2 -> 1.20.1: stale core references can survive crashes/world
                            // edits and block multiblock re-forming; auto-clean invalid references.
                            bm.resetCorePos();
                            BasicBlockMulti.updateBlockState(0, level, pos);
                        }
                        if (t instanceof TileMultiGrudgeHeavy gh && gh.hasCorePos()) {
                            if (hasValidLargeShipyardCore(level, gh.getCorePos())) {
                                return -1;
                            }
                            gh.resetCorePos();
                            BasicBlockMulti.updateBlockState(0, level, pos);
                        }
                    }

                } // end z for
            } // end y for
        } // end x for

        LogHelper.debug("DEBUG: check structure: type " + patternMatch);
        return patternMatch;
    }

    /**
     * setup multi block struct
     * <p>
     * input: level, masterX, masterY, masterZ, structure type
     * <p>
     * type: 0:no MBS, 1:large shipyard, 2:-
     */
    public static void setupStructure(Level level, int xCoord, int yCoord, int zCoord, int type) {
        BlockPos pos;
        BlockPos masterPos = new BlockPos(xCoord, yCoord, zCoord);
        LogHelper.debug("DEBUG: setup structure type: " + type);

        // get all tiles and set core position, then update blockstates
        for (int x = xCoord - 1; x < xCoord + 2; x++) {
            for (int y = yCoord - 2; y < yCoord + 1; y++) {
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    pos = new BlockPos(x, y, z);
                    BlockEntity tile = level.getBlockEntity(pos);

                    if (tile instanceof BasicTileMulti multi) {
                        multi.setCorePos(masterPos);
                        BasicBlockMulti.updateBlockState(1, level, pos);
                    } else if (tile instanceof TileMultiGrudgeHeavy gh) {
                        gh.setCorePos(masterPos);
                        BasicBlockMulti.updateBlockState(1, level, pos);
                    }
                } // end z loop
            } // end y loop
        } // end x loop
    }

    // Reset tile multi, called from master block if struct broken
    public static void resetStructure(Level level, int xCoord, int yCoord, int zCoord) {
        LogHelper.debug("DEBUG: reset struct: client? " + level.isClientSide + " " + xCoord + " " + yCoord + " "
                + zCoord);

        for (int x = xCoord - 1; x < xCoord + 2; x++) {
            for (int y = yCoord - 2; y < yCoord + 1; y++) {
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    BlockPos pos = new BlockPos(x, y, z);
                    BlockEntity tile = level.getBlockEntity(pos);

                    if (tile instanceof BasicTileMulti multi) {
                        multi.resetCorePos();
                    } else if (tile instanceof TileMultiGrudgeHeavy gh) {
                        gh.resetCorePos();
                    }

                    BasicBlockMulti.updateBlockState(0, level, pos);
                }
            }
        }
    }
}
