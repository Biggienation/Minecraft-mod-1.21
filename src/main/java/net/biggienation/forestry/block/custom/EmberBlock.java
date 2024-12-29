package net.biggienation.forestry.block.custom;

import net.biggienation.forestry.item.ForestryItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class EmberBlock extends Block {

    public static final BooleanProperty ON_OFF = BooleanProperty.create("on_off");

    public EmberBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.defaultBlockState().setValue(ON_OFF, false));
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide && stack.getItem().equals(ForestryItems.LIGHTER.asItem())) {
            boolean lit = state.getValue(ON_OFF);
            level.setBlockAndUpdate(pos, state.setValue(ON_OFF, !lit));
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ON_OFF);
    }

}
