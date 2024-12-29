package net.biggienation.forestry.datagen;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.ForestryBlocks;
import net.biggienation.forestry.block.Cinnamon_Tree_Pack;
import net.biggienation.forestry.block.custom.EmberBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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
        blockWithItem_cubeAll(Cinnamon_Tree_Pack.CINNAMON_LEAVES);
        blockWithItem_cubeAll(Cinnamon_Tree_Pack.CINNAMON_LOG);
        blockWithItem_cubeAll(Cinnamon_Tree_Pack.CINNAMON_PLANKS);

        stairsBlock(Cinnamon_Tree_Pack.CINNAMON_PLANK_STAIRS.get(), blockTexture(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get()));
        blockItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_STAIRS);

        slabBlock(Cinnamon_Tree_Pack.CINNAMON_PLANK_SLAB.get(),
                blockTexture(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get()), blockTexture(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get()));
        blockItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_SLAB);

        pressurePlateBlock(Cinnamon_Tree_Pack.CINNAMON_PLANK_PRESSURE_PLATE.get(), blockTexture(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get()));
        blockItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_PRESSURE_PLATE);

        buttonBlock(Cinnamon_Tree_Pack.CINNAMON_PLANK_BUTTON.get(), blockTexture(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get()));
        blockItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_BUTTON);

        fenceBlock(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE.get(), blockTexture(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get()));

        fenceGateBlock(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE_GATE.get(), blockTexture(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get()));
        blockItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE_GATE);

        wallBlock(Cinnamon_Tree_Pack.CINNAMON_PLANK_WALL.get(),blockTexture(Cinnamon_Tree_Pack.CINNAMON_PLANKS.get()));

        doorBlockWithRenderType(Cinnamon_Tree_Pack.CINNAMON_PLANK_DOOR.get(), modLoc("block/cinnamon_plank_door_bottom"), modLoc("block/cinnamon_plank_door_top"), "cutout");

        trapdoorBlockWithRenderType(Cinnamon_Tree_Pack.CINNAMON_PLANK_TRAP_DOOR.get(), modLoc("block/cinnamon_plank_trap_door"),true, "cutout");
        blockItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_TRAP_DOOR,"_bottom");

        emberBlock();



    }

    private void blockWithItem_cubeAll(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("forestry:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("forestry:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void emberBlock () {
        getVariantBuilder(ForestryBlocks.EMBER_BLOCK.get()).forAllStates(state -> {
            if (state.getValue(EmberBlock.ON_OFF)){
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ember_block_on",
                        ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/ember_block_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("ember_block_off",
                        ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/ember_block_off")))};
        }});

            simpleBlockItem(ForestryBlocks.EMBER_BLOCK.get(), (models().cubeAll("ember_block_on",
                    ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/ember_block_on"))));
    }

}
