package net.biggienation.forestry.datagen;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.ForestryBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ForestryBlockStateProvider extends BlockStateProvider {
    public ForestryBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Forestry.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem_cubeAll(ForestryBlocks.ASH_BLOCK);
        simpleBlockWithItem(ForestryBlocks.STONE_OVEN.get(), models().orientable("stone_oven",
                ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/stone_oven_side"),
                ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/stone_oven_front"),
                ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/stone_oven_top")));
        blockWithItem_cubeAll(ForestryBlocks.MAGIC_BLOCK);

        //Cinnamon_tree_blocks
        blockWithItem_cubeAll(ForestryBlocks.CINNAMON_LEAF);
        blockWithItem_cubeAll(ForestryBlocks.CINNAMON_LOG);
        blockWithItem_cubeAll(ForestryBlocks.CINNAMON_PLANKS);
    }

    private void blockWithItem_cubeAll(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}

