package net.biggienation.forestry.datagen;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.ForestryBlocks;
import net.biggienation.forestry.block.Cinnamon_Tree_Pack;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ForestryBlockTagProvider extends BlockTagsProvider {
    public ForestryBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Forestry.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ForestryBlocks.STONE_OVEN.get());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(Cinnamon_Tree_Pack.CINNAMON_LOG.get())
                .add(Cinnamon_Tree_Pack.STRIPED_CINNAMON_LOG.get())
                .add(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL);

        tag(BlockTags.NEEDS_IRON_TOOL);

        tag(BlockTags.LEAVES).add(Cinnamon_Tree_Pack.CINNAMON_LEAVES.get());

        tag(BlockTags.FENCES).add(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE_GATE.get());
        tag(BlockTags.WALLS).add(Cinnamon_Tree_Pack.CINNAMON_PLANK_WALL.get());
    }
}
