package com.lulan.shincolle.item;

import com.lulan.shincolle.capability.CapaTeitoku;
import com.lulan.shincolle.capability.CapaTeitokuProvider;
import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.utility.ClientRuntimeHelper;
import com.lulan.shincolle.utility.TeamHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

/**
 * Marriage Ring - used to marry ship entities, granting stat bonuses.
 * Right-click to toggle active/inactive state.
 * When active: provides water breathing and fly-in-water abilities
 * based on marriage count.
 */
public class MarriageRing extends BasicItem {

    public MarriageRing() {
        super(new Properties().stacksTo(1));
    }

    /**
     * Right-click to toggle ring active/inactive state.
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            // toggle ring state in NBT
            CompoundTag tag = stack.getOrCreateTag();
            boolean isActive = tag.getBoolean("isActive");
            boolean newState = !isActive;
            tag.putBoolean("isActive", newState);

            // update player capability
            CapaTeitoku capa = player.getCapability(CapaTeitokuProvider.CAPABILITY).orElse(null);


            capa.setRingActive(newState);

            // disable fly when deactivating
            if (!newState && !player.getAbilities().instabuild && capa.isRingFlying()) {
                player.getAbilities().flying = false;
                capa.setRingFlying(false);
                player.onUpdateAbilities();
            }
        }


        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    /**
     * Show enchanted glow when the ring is active.
     */
    @Override
    public boolean isFoil(ItemStack stack) {
        if (stack.hasTag()) {
            assert stack.getTag() != null;
            return stack.getTag().getBoolean("isActive");
        }
        return false;
    }

    /**
     * Ring effects applied every tick while in inventory:
     * - Water breathing (passive, based on marriage count)
     * - Fly mode in water (active, based on marriage count)
     * - Shy emotion on nearby owned ships (server side)
     */
    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean isSelected) {
        if (!(entity instanceof Player owner))
            return;

        CapaTeitoku capa = owner.getCapability(CapaTeitokuProvider.CAPABILITY).orElse(null);


        // water breathing (passive) - both sides
        if (ConfigHandler.ringAbility[0] >= 0 && capa.getMarriageNum() >= ConfigHandler.ringAbility[0]
                && (owner.tickCount & 127) == 0) {
            if (owner.getAirSupply() < 300) {
                owner.setAirSupply(300);
            }
        }

        // fly mode in water (active) - both sides
        if (ConfigHandler.ringAbility[1] >= 0 && capa.getMarriageNum() >= ConfigHandler.ringAbility[1]) {
            if (owner.isInWater() || owner.isInLava()) {
                // not flying and ring is active
                if (!owner.getAbilities().flying && capa.hasRing() && capa.isRingActive()) {
                    owner.getAbilities().flying = true;
                    capa.setRingFlying(true);
                    owner.onUpdateAbilities();
                }
            } else {
                // cancel flying when leave water
                if (capa.isRingFlying() && !owner.getAbilities().instabuild && owner.getAbilities().flying) {
                    owner.getAbilities().flying = false;
                    capa.setRingFlying(false);
                    owner.onUpdateAbilities();
                }
            }
        }

        // server side: shy emotion on nearby ships
        if (!level.isClientSide()) {
            if (isSelected && (entity.tickCount & 63) == 0) {
                AABB aabb = entity.getBoundingBox().inflate(6D, 5D, 6D);
                List<BasicEntityShip> slist = level.getEntitiesOfClass(BasicEntityShip.class, aabb);

                for (BasicEntityShip s : slist) {
                    if (s != null && s.isAlive() && !s.getStateFlag(ID.F.NoFuel)
                            && TeamHelper.checkSameOwner(entity, s)) {
                        s.setStateEmotion(ID.S.Emotion, ID.Emotion.SHY, true);

                        if (s.getRandom().nextInt(5) == 0) {
                            switch (s.getRandom().nextInt(3)) {
                                case 1:
                                    s.applyParticleEmotion(1); // love
                                    break;
                                case 2:
                                    s.applyParticleEmotion(31); // shy
                                    break;
                                default:
                                    s.applyParticleEmotion(15); // kiss
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        Player player = ClientRuntimeHelper.getClientPlayer();
        if (player != null) {
            CapaTeitoku capa = player.getCapability(CapaTeitokuProvider.CAPABILITY).orElse(null);

            tooltip.add(Component.literal(
                    ChatFormatting.AQUA + Component.translatable("gui.shincolle.ringText").getString() + " "
                            + capa.getMarriageNum()));
            return;
        }


        tooltip.add(Component.literal(
                ChatFormatting.AQUA + Component.translatable("gui.shincolle.ringText").getString()));
    }
}
