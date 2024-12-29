package net.biggienation.forestry.block;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.item.ForestryItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class Cinnamon_Tree_Pack {
    public static final DeferredRegister.Blocks BLOCKS
            = DeferredRegister.createBlocks(Forestry.MODID);

    // Cinnamon_tree blocks
    public static final DeferredBlock<Block> CINNAMON_PLANKS = registerBlock("cinnamon_planks",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(1).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CINNAMON_LOG = registerBlock("cinnamon_log",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(1).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPED_CINNAMON_LOG = registerBlock("striped_cinnamon_log",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(1).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CINNAMON_LEAVES = registerBlock("cinnamon_leaves",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN)
                    .strength(0.5F).sound(SoundType.CHERRY_LEAVES)
                    .requiresCorrectToolForDrops()));
    
    //DECORATIONS
    public static final DeferredBlock<StairBlock> CINNAMON_PLANK_STAIRS = registerBlock("cinnamon_plank_stairs",
            () -> new StairBlock(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1f)
                            .sound(SoundType.WOOD)));
    
    public static final DeferredBlock<SlabBlock> CINNAMON_PLANK_SLAB = registerBlock("cinnamon_plank_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1f)
                    .sound(SoundType.WOOD)));
    
    public static final DeferredBlock<PressurePlateBlock> CINNAMON_PLANK_PRESSURE_PLATE = registerBlock("cinnamon_plank_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(1f).sound(SoundType.WOOD)));
    
    public static final DeferredBlock<ButtonBlock> CINNAMON_PLANK_BUTTON = registerBlock("cinnamon_plank_button",
            () -> new ButtonBlock(BlockSetType.OAK,20, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(1f).sound(SoundType.WOOD).noCollission()));
    
    public static final DeferredBlock<FenceBlock> CINNAMON_PLANK_FENCE = registerBlock("cinnamon_plank_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1f)
                    .sound(SoundType.WOOD)));
    
    public static final DeferredBlock<FenceGateBlock> CINNAMON_PLANK_FENCE_GATE = registerBlock("cinnamon_plank_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .strength(1f).sound(SoundType.WOOD))); 
    
    public static final DeferredBlock<WallBlock> CINNAMON_PLANK_WALL = registerBlock("cinnamon_plank_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1f)
                    .sound(SoundType.WOOD)));
    
    public static final DeferredBlock<DoorBlock> CINNAMON_PLANK_DOOR = registerBlock("cinnamon_plank_door",
            () -> new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1f)
                    .sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> CINNAMON_PLANK_TRAP_DOOR = registerBlock("cinnamon_plank_trap_door",
            () -> new TrapDoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1f)
                    .sound(SoundType.WOOD).noOcclusion()));

    

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        register(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void register(String name, DeferredBlock<T> block) {
        ForestryItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
