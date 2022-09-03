package com.adamzord.modoluca.fluid;

import com.adamzord.modoluca.ModoLuca;
import com.mojang.math.Vector3f;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluidTypes {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation LIQUID_MERCURY_OVERLAY_RL = new ResourceLocation(ModoLuca.MOD_ID, "misc/in_liquid_mercury");

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ModoLuca.MOD_ID);

    public static final RegistryObject<FluidType> LIQUID_MERCURY_FLUID_TYPE= register("liquid_mercury_fluid",
            FluidType.Properties.create().lightLevel(1).density(18).viscosity(9));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties)
    {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, LIQUID_MERCURY_OVERLAY_RL, 0xA18E8E8E,
                new Vector3f(142f/255f, 142f/255f, 142f/255f), properties));
    }
    public static void register(IEventBus eventBus)
    {
        FLUID_TYPES.register(eventBus);
    }
}
