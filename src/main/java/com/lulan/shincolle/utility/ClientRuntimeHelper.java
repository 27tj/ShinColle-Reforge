package com.lulan.shincolle.utility;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;

/**
 * Runtime-safe bridge for optional client-only API access.
 * Uses reflection so common-side classes can stay dedicated-server safe.
 */
public final class ClientRuntimeHelper {

	private ClientRuntimeHelper() {
	}

	public static Player getClientPlayer() {
		if (FMLEnvironment.dist != Dist.CLIENT) {
			return null;
		}

		try {
			Class<?> mcClass = Class.forName("net.minecraft.client.Minecraft");
			Method getInstance = mcClass.getMethod("getInstance");
			Object mc = getInstance.invoke(null);
			Field playerField = mcClass.getField("player");
			Object playerObj = playerField.get(mc);
			return playerObj instanceof Player player ? player : null;
		} catch (Throwable ignored) {
			return null;
		}
	}

	public static boolean isControlDown() {
		if (FMLEnvironment.dist != Dist.CLIENT) {
			return false;
		}

		try {
			Class<?> screenClass = Class.forName("net.minecraft.client.gui.screens.Screen");
			Method hasControlDown = screenClass.getMethod("hasControlDown");
			Object result = hasControlDown.invoke(null);
			return result instanceof Boolean b && b;
		} catch (Throwable ignored) {
			return false;
		}
	}
}
