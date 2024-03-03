package net.ancillarycat.fabricfirststeps;

import net.ancillarycat.item.MyFirstItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricFirstSteps implements ModInitializer {
    /**
     * This is the mod id. It is used to uniquely identify this mod.
     * It is best practice to use your mod id as the prefix for all of your mod's identifiers.
     */
    public static final String MOD_ID = "fabricfirststeps";
    /**
     * This logger is used to write text to the console and the log file.
     * It is considered best practice to use your mod id as the logger's name.
     * That way, it's clear which mod wrote info, warnings, and errors.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Item MY_FIRST_ITEM = Registry.register(Registries.ITEM, new Identifier(FabricFirstSteps.MOD_ID, "my_first_item"), new MyFirstItem(new FabricItemSettings().maxCount(16)));
    public static final Block MY_FIRST_BLOCK = Registry.register(Registries.BLOCK, new Identifier("fabricfirststeps", "my_first_block"), new MyFirstBlock(FabricBlockSettings.create().strength(4.0F)));
    public static Enchantment FROST = new FrostEnchantment();
    public static ToolItem MY_FIRST_HOE = Registry.register(Registries.ITEM, new Identifier("fabricfirststeps", "my_first_hoe"), new HoeItem(OneClickHarvestHoe.ONE_CLICK_HARVEST_HOE, 7, -3.2F, new FabricItemSettings()));

    public static void loggerInfo() {
        FabricFirstSteps.LOGGER.info("Registering items for my first mod" + FabricFirstSteps.MOD_ID);
    }

    /**
     * Register the item group for the mod and add our custom item to it.
     * If we do not need an additional item group, we can use:
     * <pre>
     * {@code
     * import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
     * import net.fabricmc.fabric.impl.content.registry.CompostingChanceRegistryImpl;
     * import net.minecraft.item.ItemGroups;
     * ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
     * content.add(MY_FIRST_ITEM); // lambda expression
     * });
     * }
     * </pre>
     * and in the `onInitialize` function remove the {@code Registry.register} call.
     */
    private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MY_FIRST_ITEM))
            .displayName(Text.translatable("itemGroup.fabricfirststeps.myfirstgroup"))
            .entries((context, entries) -> entries.add(MY_FIRST_ITEM))
            .entries((context, entries) -> entries.add(MY_FIRST_BLOCK))
            .entries(((context, entries) -> entries.add(MY_FIRST_HOE)))
            .build();

    /**
     * This {@code onInitialize} code runs as soon as Minecraft is in a mod-load-ready state.
     * However, some things (like resources) may still be uninitialized.
     * Proceed with mild caution.
     */

    @Override
    public void onInitialize() {
        // log an info message to indicate that the mod is initializing
        loggerInfo();
        // add features to the item
        FuelRegistry.INSTANCE.add(MY_FIRST_ITEM, 300);
        CompostingChanceRegistry.INSTANCE.add(MY_FIRST_ITEM, 3f);
        // Register the item group
        Registry.register(Registries.ITEM_GROUP, new Identifier("fabricfirststeps", "myfirstgroup"), ITEM_GROUP);
        // register the block as an item
        Registry.register(Registries.ITEM, new Identifier("fabricfirststeps", "my_first_block"), new BlockItem(MY_FIRST_BLOCK, new FabricItemSettings()));
        // register the enchantment
        Registry.register(Registries.ENCHANTMENT, new Identifier("fabricfirststeps", "frost"), FROST);
    }
}