package net.biggienation.forestry.item;

import net.biggienation.forestry.Forestry;

import net.biggienation.forestry.item.custom.LighterItem;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ForestryItems {
    //makes a deferred register that will be called when needed to add our mod items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Forestry.MODID);

    public static final DeferredItem<Item> FLOUR = ITEMS.registerSimpleItem("flour");
    public static final DeferredItem<Item> DOUGH = ITEMS.registerSimpleItem("dough");
    public static final DeferredItem<Item> BUTTER = ITEMS.registerSimpleItem("butter");
    public static final DeferredItem<Item> CHEESE = ITEMS.registerSimpleItem("cheese");

    //Food Items
    public static final DeferredItem<Item> MILK_BREAD = ITEMS.register("milk_bread",() -> new Item( new Item.Properties()
            .food(ForestryFoodProperties.MILK_BREAD)){
        @Override
        public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
            if(Screen.hasShiftDown()){
                tooltipComponents.add(Component.translatable("tooltip.forestry.milk_bread"));
            }else {
                tooltipComponents.add(Component.translatable("tooltip.forestry.press_shift"));
            }

            super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        }
    });
    public static final DeferredItem<Item> SUGAR_BEET = ITEMS.registerSimpleItem("sugar_beet", new Item.Properties().food(ForestryFoodProperties.SUGAR_BEET));

    //Special Items
    public static final DeferredItem<Item> LIGHTER = ITEMS.register("lighter", () -> new LighterItem(new Item.Properties().stacksTo(1).fireResistant()));

    //registers the items to the game
    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    /* This is another way to build an item
    public static final DeferredItem<Item> DOUGH = ITEMS.register("dough",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(1).saturationModifier(2f).alwaysEdible().build()
                    )
            )
    );*/

}
