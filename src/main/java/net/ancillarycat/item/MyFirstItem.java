package net.ancillarycat.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.ancillarycat.fabricfirststeps.FabricFirstSteps;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFirstItem extends Item {
    public MyFirstItem(Settings settings) {
        super(settings);
    }

    public static final String MOD_ID = "fabricfirststeps";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        LOGGER.info("successfully applied sound");
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    public static final Item MY_FIRST_ITEM = registerItem("my_first_item", new Item(new FabricItemSettings()));

    private static void addItemToIngredientTable(FabricItemGroupEntries entries) {
        entries.add(MY_FIRST_ITEM);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FabricFirstSteps.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FabricFirstSteps.LOGGER.info("Registering items for my first mod" + FabricFirstSteps.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTable);
    }
}