package com.adamzord.modoluca.block;

import com.adamzord.modoluca.ModoLuca;
import com.adamzord.modoluca.block.custom.CoffeeMakerBlock;
import com.adamzord.modoluca.block.custom.IndustrialCrusherBlock;
import com.adamzord.modoluca.block.custom.VerticalSlabBlock;
import com.adamzord.modoluca.fluid.ModFluids;
import com.adamzord.modoluca.item.ModCreativeModeTab;
import com.adamzord.modoluca.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModoLuca.MOD_ID);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()), ModCreativeModeTab.MODOLUCA_TAB);

    public static final RegistryObject<LiquidBlock> LIQUID_MERCURY_BLOCK = BLOCKS.register("liquid_mercury_block",
            () -> new LiquidBlock(ModFluids.SOURCE_LIQUID_MERCURY, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<Block> INDUSTRIAL_CRUSHER = registerBlock("industrial_crusher",
            () -> new IndustrialCrusherBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.MODOLUCA_TAB);

    public static final RegistryObject<Block> COFFEE_MAKER = registerBlock("coffee_maker",
            () -> new CoffeeMakerBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.MODOLUCA_TAB);

    public static final RegistryObject<Block> VERTICAL_OAK_SLAB = registerBlock("vertical_oak_slab",
            () -> new VerticalSlabBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.MODOLUCA_TAB);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register (IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
