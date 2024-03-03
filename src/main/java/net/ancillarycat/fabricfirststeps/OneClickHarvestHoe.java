package net.ancillarycat.fabricfirststeps;

import net.ancillarycat.item.MyFirstItem;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class OneClickHarvestHoe implements ToolMaterial {
    /**
     *  ToolMaterials does not have to be registered.
     *  A good way to pass them out to tools that requires them is by keeping an instance of the tool material in the tool class(or somewhere else) and then referencing it when creating the tool.
     *  <b>But tool items should be registered.</b>
     */
    public static final OneClickHarvestHoe ONE_CLICK_HARVEST_HOE = new OneClickHarvestHoe();

    @Override
    public int getDurability(){
        return 1561;
    }

    @Override
    public float getAttackDamage(){
        return 4.0F;
    }

    @Override
    public Ingredient getRepairIngredient(){
        return Ingredient.ofItems(FabricFirstSteps.MY_FIRST_ITEM);
    }

    @Override
    public float getMiningSpeedMultiplier(){
        // wood 2.0F, diamond 8.0F
        return 6.0F;
    }

    @Override
    public int getMiningLevel(){
        // Obsidian: 3+
        return 1;
    }

    @Override
    public int getEnchantability(){
        // gold 22, diamond 10
        return 300;
    }
}
