package net.biggienation.forestry.item;

import net.minecraft.world.food.FoodProperties;

public class ForestryFoodProperties {

    public static FoodProperties MILK_BREAD = new FoodProperties.Builder().nutrition(5).saturationModifier(0.6F).fast().build();
    public static FoodProperties SUGAR_BEET = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25F).fast().build();


    //add Effect through .effect(() -> new MobEffectInstance(MobEffets._____, XXX (duration)), XX (probability))
    // Drinks need a costume class that overrides the useAnim method.
}
