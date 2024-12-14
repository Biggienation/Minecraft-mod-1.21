package net.biggienation.forestry.block;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.custom.MagicBlock;
import net.biggienation.forestry.item.ModItems;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Forestry.MODID);

    // Press shift twice and search for BLOCKS and you can find the block properties
    public static final DeferredBlock<Block> ASH_BLOCK = registerBlock("ash_block",
            () -> new ColoredFallingBlock(new ColorRGBA(-8356741),BlockBehaviour.Properties.of()
                    .strength(1).sound(SoundType.SNOW)));
    //ColoredFallingBlocks need an RGBA color and then the properties, (sand, gravel)


    public static final DeferredBlock<Block> STONE_OVEN = registerBlock("stone_oven",
            () ->
                new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .requiresCorrectToolForDrops()
                        .strength(3.5F)));


    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock (String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        register(name, toReturn);
        return toReturn;
    };

    private static <T extends Block> void register(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
