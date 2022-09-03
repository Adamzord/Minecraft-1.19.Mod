package com.adamzord.modoluca.fluid;

import com.adamzord.modoluca.ModoLuca;
import com.adamzord.modoluca.block.ModBlocks;
import com.adamzord.modoluca.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, ModoLuca.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_LIQUID_MERCURY = FLUIDS.register("liquid_mercury_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.LIQUID_MERCURY_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_LIQUID_MERCURY = FLUIDS.register("flowing_liquid_mercury",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.LIQUID_MERCURY_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties LIQUID_MERCURY_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.LIQUID_MERCURY_FLUID_TYPE, SOURCE_LIQUID_MERCURY, FLOWING_LIQUID_MERCURY).slopeFindDistance(2).levelDecreasePerBlock(2)
            .block(ModBlocks.LIQUID_MERCURY_BLOCK).bucket(ModItems.LIQUID_MERCURY_BUCKET);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }
}
