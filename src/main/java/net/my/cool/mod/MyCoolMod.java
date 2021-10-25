package net.my.cool.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MyCoolMod implements ModInitializer {

    public static final Item FABRIC_ITEM = new FabricItem(new Item.Settings().group(MyCoolMod.ITEM_GROUP));

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
        new Identifier("coolmod", "general"),
        () -> new ItemStack(Blocks.COBBLED_DEEPSLATE));
    
    public static final ItemGroup OTHER_GROUP = FabricItemGroupBuilder.create(
        new Identifier("coolmod", "other"))
        .icon(() -> new ItemStack(Items.NAME_TAG))
        .appendItems(stacks -> {
            stacks.add(new ItemStack(Blocks.BLACK_CANDLE));
            stacks.add(new ItemStack(Items.CAKE));
            stacks.add(ItemStack.EMPTY);
            stacks.add(new ItemStack(FABRIC_ITEM));

        })
        .build();
    

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier("coolmod", "fabric_item"), FABRIC_ITEM);
    }
}