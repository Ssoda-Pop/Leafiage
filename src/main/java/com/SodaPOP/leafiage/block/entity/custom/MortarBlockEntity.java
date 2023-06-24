package com.SodaPOP.leafiage.block.entity.custom;

import com.SodaPOP.leafiage.block.entity.LeafBlockEntities;

import com.SodaPOP.leafiage.recipe.MortarRecipe;
import com.SodaPOP.leafiage.screen.MortarMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;



public class MortarBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    protected final ContainerData data;
    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public MortarBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(LeafBlockEntities.MORTAR_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return 0;
            }

            @Override
            public void set(int pIndex, int pValue) {

            }

            @Override
            public int getCount() {
                return 0;
            }
        };
    }
    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new MortarMenu(pContainerId, pPlayerInventory, this, this.data);
    }
    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, MortarBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity) && hasNotReachedStackLimit(pBlockEntity)) {
            craftItem(pBlockEntity);
        }
    }

    private static void craftItem(MortarBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i =0; i<entity.itemHandler.getSlots();i++){
            inventory.setItem(i,entity.itemHandler.getStackInSlot(i));
        }
        Optional<MortarRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(MortarRecipe.Type.INSTANCE, inventory, level);

    if(hasRecipe(entity)){
        entity.itemHandler.extractItem(1,1,false);
        entity.itemHandler.setStackInSlot(4,new ItemStack(recipe.get().getResultItem(null).getItem(),
                entity.itemHandler.getStackInSlot(4).getCount() + 1));
    }
    }

    private static boolean hasRecipe(MortarBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i =0; i<entity.itemHandler.getSlots();i++){
            inventory.setItem(i,entity.itemHandler.getStackInSlot(i));
        }
        Optional<MortarRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(MortarRecipe.Type.INSTANCE, inventory, level);
        return recipe.isPresent() && canInsertAmountInOutputSlot(inventory)
                && canInsertItemInOutputSlot(inventory, recipe.get().getResultItem(null));
    }

    private static boolean canInsertAmountInOutputSlot(SimpleContainer inventory) {

        return inventory.getItem(4).getMaxStackSize()> inventory.getItem(4).getCount();
    }
    private static boolean canInsertItemInOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(4).getItem() == stack.getItem() || inventory.getItem(4).isEmpty();
    }
    private static boolean hasNotReachedStackLimit(MortarBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(4).getCount() < entity.itemHandler.getStackInSlot(4).getMaxStackSize();
    }


    @Override
    public Component getDisplayName() {
        return Component.literal("Mortar");
    }
}


