package net.biggienation.forestry.util;

import net.biggienation.forestry.Forestry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForestryTags {
    public static class Blocks {
        private static TagKey<Block> blockTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Forestry.MODID, name));
        }
    }

    public static class Items {
        public static TagKey<Item> ItemTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Forestry.MODID, name));
        }
    }
}
