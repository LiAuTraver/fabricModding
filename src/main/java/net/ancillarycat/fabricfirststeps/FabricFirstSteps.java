package net.ancillarycat.fabricfirststeps;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.ancillarycat.item.MyFirstItem;
public class FabricFirstSteps implements ModInitializer {
	public static final String MOD_ID = "fabricfirststeps";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// my first item instance
//	public static final Item myFirstItem = Registry.register(Registries.ITEM, new Identifier("fabric first mod", "myFirstItem"), new Item(new FabricItemSettings()));

	@Override
	public void onInitialize(){
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		MyFirstItem.registerModItems();

	}
}