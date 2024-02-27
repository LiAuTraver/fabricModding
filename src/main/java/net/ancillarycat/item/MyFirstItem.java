package net.ancillarycat.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.ancillarycat.fabricfirststeps.FabricFirstSteps;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyFirstItem extends Item {

    public MyFirstItem(Settings settings) {
        super(settings);
    }

    /**
     * add a custom sound when right-clicking the item
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        FabricFirstSteps.LOGGER.info("successfully applied sound");
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    /**
     * add a tooltip, mouse hovers over the item in inventory to show
     */
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> toolTip, TooltipContext context) {
        Integer currentDay = 1;
        Integer currentMonth = 1;
        toolTip.add(Text.translatable("item.fabricfirststeps.my_first_item.tooltip", currentDay, currentMonth));
    }
}