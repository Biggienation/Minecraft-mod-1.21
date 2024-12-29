package net.biggienation.forestry.datagen;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.Cinnamon_Tree_Pack;
import net.biggienation.forestry.item.ForestryItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ForestryItemModelProvider extends ItemModelProvider {
    public ForestryItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Forestry.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ForestryItems.BUTTER.get());
        basicItem(ForestryItems.CHEESE.get());
        basicItem(ForestryItems.DOUGH.get());
        basicItem(ForestryItems.FLOUR.get());
        basicItem(ForestryItems.LIGHTER.get());
        basicItem(ForestryItems.MILK_BREAD.get());
        basicItem(ForestryItems.SUGAR_BEET.get());

        buttonItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_BUTTON, Cinnamon_Tree_Pack.CINNAMON_PLANKS);
        fenceItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE, Cinnamon_Tree_Pack.CINNAMON_PLANKS);
        wallItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_WALL, Cinnamon_Tree_Pack.CINNAMON_PLANKS);

        basicItem(Cinnamon_Tree_Pack.CINNAMON_PLANK_DOOR.asItem());

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory")).texture("texture",
                ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/" + baseBlock.getId().getPath()));
    }
    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory")).texture("texture",
                ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/" + baseBlock.getId().getPath()));
    }
    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory")).texture("wall",
                ResourceLocation.fromNamespaceAndPath(Forestry.MODID, "block/" + baseBlock.getId().getPath()));
    }
}
