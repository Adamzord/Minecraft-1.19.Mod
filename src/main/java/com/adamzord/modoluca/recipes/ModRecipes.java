package com.adamzord.modoluca.recipes;

import com.adamzord.modoluca.ModoLuca;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ModoLuca.MOD_ID);

    public static final RegistryObject<RecipeSerializer<IndustrialCrusherRecipe>> INDUSTRIAL_CRUSHING_SERIALIZER =
            SERIALIZERS.register("pulverizing", () -> IndustrialCrusherRecipe.Serializer.INSTANCE);
    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
