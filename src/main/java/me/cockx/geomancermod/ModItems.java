package me.cockx.geomancermod;

import me.cockx.geomancermod.items.FoodItemBase;
import me.cockx.geomancermod.items.GlueBallItem;
import me.cockx.geomancermod.items.ItemBase;
import me.cockx.geomancermod.items.MineralChunkItem;
import me.cockx.geomancermod.items.armor.ArmorBase;
import me.cockx.geomancermod.items.tools.*;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class ModItems {

    public static final List<Item> ITEM_LIST = new ArrayList<>();


    // Materials
    public static final Item.ToolMaterial MATERIAL_MINERAL = EnumHelper.addToolMaterial("material_mineral",1,170,4f,1.5f,14);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_MINERAL = EnumHelper.addArmorMaterial("armor_material_mineral",GeomancerMod.MODID+":mineral",14,new int[]{1, 3, 5, 2},14, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,1.0f);


    // Items
    public static final Item MUSH = new ItemBase("mush");
    public static final Item GLUEBALL = new GlueBallItem("glueball");
    public static final Item CHARRED_MUSH = new ItemBase("charredmush");
    public static final Item DIRT_SANDWICH = new FoodItemBase("dirtsandwich",1,1f,false);
    public static final Item MINERAL_CHUNK = new MineralChunkItem("mineralchunk");

    // Tools
    public static final ItemSword MINERAL_SWORD = new ToolSword("mineral_sword",MATERIAL_MINERAL);
    public static final ItemSpade MINERAL_SHOVEL = new ToolSpade("mineral_shovel",MATERIAL_MINERAL);
    public static final ItemPickaxe MINERAL_PICKAXE = new ToolPickaxe("mineral_pickaxe",MATERIAL_MINERAL);
    public static final ItemAxe MINERAL_AXE = new ToolAxe("mineral_axe",MATERIAL_MINERAL);
    public static final ItemHoe MINERAL_HOE = new ToolHoe("mineral_hoe",MATERIAL_MINERAL);


    // Armor
    public static final Item MINERAL_HELMET = new ArmorBase("mineral_helmet",ARMOR_MATERIAL_MINERAL,1, EntityEquipmentSlot.HEAD);
    public static final Item MINERAL_CHESTPLATE = new ArmorBase("mineral_chestplate",ARMOR_MATERIAL_MINERAL,1, EntityEquipmentSlot.CHEST);
    public static final Item MINERAL_LEGGINGS = new ArmorBase("mineral_leggings",ARMOR_MATERIAL_MINERAL,2, EntityEquipmentSlot.LEGS);
    public static final Item MINERAL_BOOTS = new ArmorBase("mineral_boots",ARMOR_MATERIAL_MINERAL,1, EntityEquipmentSlot.FEET);

}
