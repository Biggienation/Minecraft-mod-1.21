package net.biggienation.forestry.datagen;

import net.biggienation.forestry.Forestry;
import net.biggienation.forestry.block.ForestryBlocks;
import net.biggienation.forestry.block.Cinnamon_Tree_Pack;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ForestryRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ForestryRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ForestryBlocks.STONE_OVEN.get())
                .pattern("CCC")
                .pattern("CFC")
                .pattern("III")
                .define('C', ItemTags.STONE_CRAFTING_MATERIALS)
                .define('F', Items.FURNACE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_furnace", has(Items.FURNACE)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Cinnamon_Tree_Pack.CINNAMON_PLANKS.get(), 4)
                .requires(Cinnamon_Tree_Pack.CINNAMON_LOG)
                .unlockedBy("has_cinnamon_log", has(Cinnamon_Tree_Pack.CINNAMON_LOG)).save(recipeOutput);

        stairBuilder(Cinnamon_Tree_Pack.CINNAMON_PLANK_STAIRS, Ingredient.of(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).group("Cinnamon")
                .unlockedBy("has_cinnamon_planks", has(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Cinnamon_Tree_Pack.CINNAMON_PLANK_SLAB.get(), Cinnamon_Tree_Pack.CINNAMON_PLANKS.get());

        buttonBuilder(Cinnamon_Tree_Pack.CINNAMON_PLANK_BUTTON, Ingredient.of(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).group("Cinnamon")
                .unlockedBy("has_cinnamon_planks", has(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, Cinnamon_Tree_Pack.CINNAMON_PLANK_PRESSURE_PLATE.get(), Cinnamon_Tree_Pack.CINNAMON_PLANKS.get());

        fenceBuilder(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE, Ingredient.of(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).group("Cinnamon")
                .unlockedBy("has_cinnamon_planks", has(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).save(recipeOutput);
        fenceGateBuilder(Cinnamon_Tree_Pack.CINNAMON_PLANK_FENCE_GATE, Ingredient.of(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).group("Cinnamon")
                .unlockedBy("has_cinnamon_planks", has(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, Cinnamon_Tree_Pack.CINNAMON_PLANK_WALL.get(), Cinnamon_Tree_Pack.CINNAMON_PLANKS.get());

        doorBuilder(Cinnamon_Tree_Pack.CINNAMON_PLANK_DOOR, Ingredient.of(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).group("Cinnamon")
                .unlockedBy("has_cinnamon_planks", has(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).save(recipeOutput);
        trapdoorBuilder(Cinnamon_Tree_Pack.CINNAMON_PLANK_TRAP_DOOR, Ingredient.of(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).group("Cinnamon")
                .unlockedBy("has_cinnamon_planks", has(Cinnamon_Tree_Pack.CINNAMON_PLANKS)).save(recipeOutput);
    }

//    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
//                                      float pExperience, int pCookingTIme, String pGroup) {
//        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
//                pExperience, pCookingTIme, pGroup, "_from_smelting");
//    }
//
//    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
//                                      float pExperience, int pCookingTime, String pGroup) {
//        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
//                pExperience, pCookingTime, pGroup, "_from_blasting");
//    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Forestry.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
