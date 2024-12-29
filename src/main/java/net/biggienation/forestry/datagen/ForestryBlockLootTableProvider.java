package net.biggienation.forestry.datagen;

import net.biggienation.forestry.block.ForestryBlocks;
import net.biggienation.forestry.block.Cinnamon_Tree_Pack;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ForestryBlockLootTableProvider  extends BlockLootSubProvider {
    protected ForestryBlockLootTableProvider (HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),registries);
    }

    @Override
    protected void generate() {
        dropSelf(ForestryBlocks.ASH_BLOCK.get());
        dropSelf(ForestryBlocks.MAGIC_BLOCK.get());
        dropSelf(ForestryBlocks.STONE_OVEN.get());
        dropSelf(ForestryBlocks.EMBER_BLOCK.get());

        //Cinnamon_tree Blocks
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get());
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_LOG.get());
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_LEAVES.get());
//        dropSelf(Cinnamon_Tree_Pack.STRIPED_CINNAMON_LOG.get());

//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_PLANK_STAIRS.get());
//        add(Cinnamon_Tree_Pack.CINNAMON_PLANK_SLAB.get(),
//                block -> createSlabItemTable(Cinnamon_Tree_Pack.CINNAMON_PLANK_SLAB.get()));
//
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_PLANK_PRESSURE_PLATE.get());
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_PLANK_BUTTON.get());
//
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE.get());
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE_GATE.get());
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_PLANK_WALL.get());
//
//        dropSelf(Cinnamon_Tree_Pack.CINNAMON_PLANK_TRAP_DOOR.get());
//        add(Cinnamon_Tree_Pack.CINNAMON_PLANK_DOOR.get(),
//                block -> createDoorTable(Cinnamon_Tree_Pack.CINNAMON_PLANK_DOOR.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForestryBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
