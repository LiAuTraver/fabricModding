package net.ancillarycat.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.ancillarycat.fabricfirststeps.FabricFirstSteps;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyFirstItem extends Item {
    public MyFirstItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        FabricFirstSteps.LOGGER.info("successfully applied sound");
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> toolTip, TooltipContext context) {
        Integer currentDay = 1;
        Integer currentMonth = 1;
        toolTip.add(Text.translatable("item.fabricfirststeps.my_first_item.tooltip", currentDay, currentMonth));
    }

}