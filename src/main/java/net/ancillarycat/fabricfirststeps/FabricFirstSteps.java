package net.ancillarycat.fabricfirststeps;

import net.ancillarycat.item.MyFirstItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricFirstSteps implements ModInitializer {
    public static final String MOD_ID = "fabricfirststeps";
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Item MY_FIRST_ITEM = Registry.register(Registries.ITEM, new Identifier(FabricFirstSteps.MOD_ID, "my_first_item"),new MyFirstItem(new FabricItemSettings()));

//	private static void addItemToIngredientTable(FabricItemGroupEntries entries) {
//		entries.add(MY_FIRST_ITEM);
//	}

    public static void loggerInfo() {
        FabricFirstSteps.LOGGER.info("Registering items for my first mod" + FabricFirstSteps.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTable);
    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        loggerInfo();
    }
}