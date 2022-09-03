package com.adamzord.modoluca.block.entity;

import com.adamzord.modoluca.ModoLuca;
import com.adamzord.modoluca.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ModoLuca.MOD_ID);

    public static final RegistryObject<BlockEntityType<IndustrialCrusherBlockEntity>> INDUSTRIAL_CRUSHER =
            BLOCK_ENTITIES.register("industrial_crusher", () -> BlockEntityType.Builder.of(IndustrialCrusherBlockEntity::new,
                    ModBlocks.INDUSTRIAL_CRUSHER.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
