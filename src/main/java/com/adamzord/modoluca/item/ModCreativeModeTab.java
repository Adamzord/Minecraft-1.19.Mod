package com.adamzord.modoluca.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public  static final CreativeModeTab MODOLUCA_TAB = new CreativeModeTab("modolucatab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.STEEL.get());
        }
    };
}
