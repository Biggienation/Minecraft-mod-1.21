package net.biggienation.forestry.datagen;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.ForestryBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ForestryItemTagProvider extends ItemTagsProvider {
    public ForestryItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                   CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Forestry.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.PLANKS)
                .add(ForestryBlocks.CINNAMON_PLANKS.get().asItem());

        tag(ItemTags.LOGS)
                .add(ForestryBlocks.CINNAMON_LOG.get().asItem());
    }
}
