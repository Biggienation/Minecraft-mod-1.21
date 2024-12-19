package net.biggienation.forestry.datagen;

import net.biggienation.forestry.block.ForestryBlocks;
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
        dropSelf(ForestryBlocks.CINNAMON_PLANKS.get());
        dropSelf(ForestryBlocks.STONE_OVEN.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForestryBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
