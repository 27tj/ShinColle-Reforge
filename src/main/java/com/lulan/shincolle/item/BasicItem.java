package com.lulan.shincolle.item;

import net.minecraft.world.item.Item;

/**
 * Base item class for ShinColle items.
 * In 1.20.1, most of the original BasicItem functionality (model registration,
 * creative tab, localization) is handled through other mechanisms.
 */
public class BasicItem extends Item {

    public BasicItem(Properties properties) {
        super(properties);
    }

    public BasicItem() {
        super(new Properties());
    }
}
