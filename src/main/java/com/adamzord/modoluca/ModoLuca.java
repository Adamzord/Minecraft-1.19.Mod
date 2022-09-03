package com.adamzord.modoluca;

import com.adamzord.modoluca.block.ModBlocks;
import com.adamzord.modoluca.block.entity.ModBlockEntities;
import com.adamzord.modoluca.fluid.ModFluidTypes;
import com.adamzord.modoluca.fluid.ModFluids;
import com.adamzord.modoluca.item.ModItems;
import com.adamzord.modoluca.screen.IndustrialCrusherScreen;
import com.adamzord.modoluca.screen.ModMenuTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModoLuca.MOD_ID)
public class ModoLuca
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "modoluca";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ModoLuca()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(ModMenuTypes.INDUSTRIAL_CRUSHER_MENU.get(), IndustrialCrusherScreen::new);
        }
    }
}
