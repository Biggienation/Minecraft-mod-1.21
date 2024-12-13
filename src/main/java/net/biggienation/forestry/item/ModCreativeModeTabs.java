package net.biggienation.forestry.item;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Forestry.MODID);

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final Supplier<CreativeModeTab> FORESTRY_BLOCK_TAB = CREATIVE_MODE_TAB.register("forestry_block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ASH_BLOCK))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .title(Component.translatable("creativetab.forestry.forestry_block")) //The language key for the title of your CreativeModeTab
                    .displayItems((itemDisplayParameters, output) -> {
                        // Add the example item to the tab. For your own tabs, this method is preferred over the event
                        output.accept(ModBlocks.ASH_BLOCK.get());
                        output.accept(ModBlocks.STONE_OVEN.get());
                    }).build());

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final Supplier<CreativeModeTab> FORESTRY_ITEM_TAB = CREATIVE_MODE_TAB.register("forestry_item_tab",
            () -> CreativeModeTab.builder().icon(() -> ModItems.MILK_BREAD.get().getDefaultInstance())
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "forestry_block_tab")) // This put the tab after forestry_block_tab
                    .title(Component.translatable("creativetab.forestry.forestry_item")) //The language key for the title of your CreativeModeTab
                    .displayItems((itemDisplayParameters, output) -> {
                        // Add the example item to the tab. For your own tabs, this method is preferred over the event
                        output.accept(ModItems.FLOUR.get());
                        output.accept(ModItems.DOUGH.get());
                        output.accept(ModItems.MILK_BREAD.get());
                        output.accept(ModItems.LIGHTER.get());
                    }).build());



    public static void init(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);
    }
}
