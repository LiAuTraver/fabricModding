package net.ancillarycat.fabricfirststeps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class ChangeableBlock extends Block {
    public ChangeableBlock(Settings settings) {
        super(settings);
        // we can set multiple properties by chaining `with()`
        setDefaultState(getDefaultState().with(CHARGED, false));
    }

    public static final BooleanProperty CHARGED = BooleanProperty.of("charged");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHARGED);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        player.playSound(SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, 1, 1);
        world.setBlockState(pos, state.with(CHARGED, true));
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (world.getBlockState(pos).get(CHARGED)) {
            LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(world);
            // intellij suggest me to use `assert` to prevent Null Pointer Exception
            assert lightningEntity != null;
            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(lightningEntity);
        }
        world.setBlockState(pos, state.with(CHARGED, false));
        if (entity instanceof PlayerEntity)
            entity.sendMessage(Text.literal("You stepped on a charged block!\nSuccessfully applied onSteppedOn function"));
        // why should I call super.onSteppedOn?
        // I could not understand.
        // in this case it is not necessary to call super.onSteppedOn, I've tried to remove it and it works fine.
        super.onSteppedOn(world, pos, state, entity);
    }
}
