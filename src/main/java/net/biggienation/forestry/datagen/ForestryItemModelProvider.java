package net.biggienation.forestry.datagen;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.item.ForestryItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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

    }
}
