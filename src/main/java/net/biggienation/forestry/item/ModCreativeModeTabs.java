package net.biggienation.forestry.item;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.ForestryBlocks;
import net.biggienation.forestry.block.Cinnamon_Tree_Pack;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ForestryBlocks.ASH_BLOCK))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .title(Component.translatable("creativetab.forestry.forestry_block")) //The language key for the title of your CreativeModeTab
                    .displayItems((itemDisplayParameters, output) -> {
                        // Add the example item to the tab. For your own tabs, this method is preferred over the event
                        output.accept(ForestryBlocks.ASH_BLOCK.get());
                        output.accept(ForestryBlocks.STONE_OVEN.get());
                        output.accept(ForestryBlocks.MAGIC_BLOCK.get());

                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get());
                        output.accept(Cinnamon_Tree_Pack.CINNAMON_LEAVES.get());
                        output.accept(Cinnamon_Tree_Pack.CINNAMON_LOG.get());
                        output.accept(Cinnamon_Tree_Pack.STRIPED_CINNAMON_LOG);

                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_STAIRS.get());
                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_SLAB.get());

                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE.get());
                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE_GATE.get());
                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_WALL.get());

                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_BUTTON.get());
                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_PRESSURE_PLATE.get());

                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_DOOR.get());
                        output.accept(Cinnamon_Tree_Pack.CINNAMON_PLANK_TRAP_DOOR.get());

                        output.accept(ForestryBlocks.EMBER_BLOCK.get());
                    }).build());

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final Supplier<CreativeModeTab> FORESTRY_ITEM_TAB = CREATIVE_MODE_TAB.register("forestry_item_tab",
            () -> CreativeModeTab.builder().icon(() -> ForestryItems.MILK_BREAD.get().getDefaultInstance())
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "forestry_block_tab")) // This put the tab after forestry_block_tab
                    .title(Component.translatable("creativetab.forestry.forestry_item")) //The language key for the title of your CreativeModeTab
                    .displayItems((itemDisplayParameters, output) -> {
                        // Add the example item to the tab. For your own tabs, this method is preferred over the event
                        output.accept(ForestryItems.FLOUR.get());
                        output.accept(ForestryItems.DOUGH.get());
                        output.accept(ForestryItems.MILK_BREAD.get());
                        output.accept(ForestryItems.SUGAR_BEET);
                        output.accept(ForestryItems.LIGHTER.get());
                        output.accept(ForestryItems.BUTTER.get());
                        output.accept(ForestryItems.CHEESE.get());
                    }).build());



    public static void init(IEventBus bus) {
        CREATIVE_MODE_TAB.register(bus);
    }
}
