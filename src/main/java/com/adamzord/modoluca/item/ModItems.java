package com.adamzord.modoluca.item;

import com.adamzord.modoluca.ModoLuca;
import com.adamzord.modoluca.fluid.ModFluids;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModoLuca.MOD_ID);

    public static final RegistryObject<Item> STEEL = ITEMS.register("steel", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODOLUCA_TAB)));
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODOLUCA_TAB)));

    public static final RegistryObject<Item> MUG = ITEMS.register("mug", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODOLUCA_TAB)));

    public static final RegistryObject<Item> COFFEE_POWDER = ITEMS.register("coffee_powder", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODOLUCA_TAB)));
    public static final RegistryObject<Item> COFFEE_FILTER = ITEMS.register("coffee_filter", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODOLUCA_TAB)));
    public static final RegistryObject<Item> BOILING_WATER = ITEMS.register("boiling_water", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODOLUCA_TAB)));

    public static final RegistryObject<Item> COFFEE_MUG = ITEMS.register("coffee_mug", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.MODOLUCA_TAB)
            .food(new FoodProperties.Builder().nutrition(1).saturationMod(1).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0),1f).build())));
    public static final RegistryObject<Item> LIQUID_MERCURY_BUCKET = ITEMS.register("liquid_mercury_bucket",
            () -> new BucketItem(ModFluids.SOURCE_LIQUID_MERCURY, new Item.Properties().tab(ModCreativeModeTab.MODOLUCA_TAB).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
