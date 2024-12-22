package net.biggienation.forestry.datagen;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.ForestryBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ForestryBlockStateProvider extends BlockStateProvider {
    public ForestryBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Forestry.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ForestryBlocks.ASH_BLOCK);
        blockWithItem(ForestryBlocks.STONE_OVEN);
        blockWithItem(ForestryBlocks.MAGIC_BLOCK);

        //Cinnamon_tree_blocks
        blockWithItem(ForestryBlocks.CINNAMON_LEAF);
        blockWithItem(ForestryBlocks.CINNAMON_LOG);
        blockWithItem(ForestryBlocks.CINNAMON_PLANKS);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
