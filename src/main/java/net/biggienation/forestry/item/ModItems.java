package net.biggienation.forestry.item;

import net.biggienation.forestry.Forestry;

import net.biggienation.forestry.item.custom.LighterItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    //makes a deferred register that will be called when needed to add our mod items
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Forestry.MODID);

    public static final DeferredItem<Item> FLOUR = ITEMS.registerSimpleItem("flour");
    public static final DeferredItem<Item> DOUGH = ITEMS.registerSimpleItem("dough");
    public static final DeferredItem<Item> MILK_BREAD = ITEMS.registerSimpleItem("milk_bread", new Item.Properties()
            .food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(2f).build()));
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
