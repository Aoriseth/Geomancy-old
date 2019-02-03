package me.cockx.geomancermod;

import me.cockx.geomancermod.items.FoodItemBase;
import me.cockx.geomancermod.items.GlueBallItem;
import me.cockx.geomancermod.items.ItemBase;
import me.cockx.geomancermod.items.tools.ToolSword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class ModItems {

    public static final List<Item> ITEM_LIST = new ArrayList<>();


    // Materials
    public static final Item.ToolMaterial MATERIAL_MINERAL = EnumHelper.addToolMaterial("material_mineral",1,170,4f,1.5f,14);


    // Items
    public static final Item MUSH = new ItemBase("mush");
    public static final Item GLUEBALL = new GlueBallItem("glueball");
    public static final Item CHARRED_MUSH = new ItemBase("charredmush");
    public static final Item DIRT_SANDWICH = new FoodItemBase("dirtsandwich",1,1f,false);

    // Tools
    public static final ItemSword MINERAL_SWORD = new ToolSword("mineral_sword",MATERIAL_MINERAL);


}
