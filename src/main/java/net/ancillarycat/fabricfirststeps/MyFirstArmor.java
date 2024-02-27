//package net.ancillarycat.fabricfirststeps;
//
//import net.fabricmc.fabric.api.networking.v1.S2CPlayChannelEvents;
//import net.minecraft.entity.EquipmentSlot;
//import net.minecraft.item.ArmorItem;
//import net.minecraft.item.ArmorMaterial;
//import net.minecraft.recipe.Ingredient;
//import net.minecraft.sound.SoundEvent;
//import net.minecraft.sound.SoundEvents;
//
//public class MyFirstArmor implements ArmorMaterial {
//    /**
//     * base durability: leather 5, diamond 33, netherite 37.
//     */
//    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
//    /**
//     * &#064;A  boots <br>
//     * &#064;B  leggings <br>
//     * &#064;C  chestplate <br>
//     * &#064;D  helmet <br>
//     * protection values:  <br>
//     * leather 1,2,3,1;  <br>
//     * diamond/netherite 3,6,8,3.
//     */
//    private static final int[] PROTECTION_VALUES = new int[]{4, 7, 9, 4};
//
//    @Override
//    public int method_7696(EquipmentSlot slot) {
//        return BASE_DURABILITY[slot.getEntitySlotId()] * 4;
//    }
//
//    @Override
//    public int method_7697(EquipmentSlot slot){
//        return PROTECTION_VALUES[slot.getEntitySlotId()];
//    }
//
//    @Override
//    public int getDurability(EquipmentSlot slot) {
//        return BASE_DURABILITY[slot.getEntitySlotId()];
//    }
//
//    @Override
//    public int getProtection(ArmorItem.Type type) {
//        return 0;
//    }
//
//    @Override
//    public int getEnchantability(){
//        return 4;
//    }
//
//    @Override
//    public SoundEvent getEquipSound(){
//        return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
//    }
//
//    @Override
//    public Ingredient getRepairIngredient(){
//        return Ingredient.ofItems(RegisterItems.MY_FIRST_INGOT);
//    }
//
//    /**
//     * @return must be all lowercase
//     */
//    @Override
//    public String getName(){
//        return "my first boots";
//    }
//
//    /**
//     * must be {@code float} not {@code Float}.
//     */
//    @Override
//    public float getToughness(){
//        return 1.0F;
//    }
//    @Override
//    public float getKnockbackResistance(){
//        return 0.0F;
//    }
//
//
//}
