package com.SodaPOP.leafiage.screen;

import com.SodaPOP.leafiage.block.LeafBlocks;
import com.SodaPOP.leafiage.block.entity.custom.MortarBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class MortarMenu extends AbstractContainerMenu {
    public final MortarBlockEntity blockEntity;
    public final Level level;
    public final ContainerData data;
    public MortarMenu(int id, Inventory inv, FriendlyByteBuf eData) {
        this(id, inv, inv.player.level().getBlockEntity(eData.readBlockPos()), new SimpleContainerData(4));
    }
    public MortarMenu(int id, Inventory inv, BlockEntity entity, ContainerData data){
        super(LeafMenuTypes.MORTAR_MENU.get(), id);
        checkContainerSize(inv, 4);
        blockEntity = (MortarBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;
        addPlayerInventory(inv);
        addHotbar(inv);
        this.blockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            this.addSlot(new SlotItemHandler(iItemHandler,0,42,16));
                    this.addSlot(new SlotItemHandler(iItemHandler,1,42,54));
                    this.addSlot(new SlotItemHandler(iItemHandler,2,23,35));
                    this.addSlot(new SlotItemHandler(iItemHandler,3,61,35));
                    this.addSlot(new SlotItemHandler(iItemHandler,4,121,35));
        });
        }

    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 4;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, LeafBlocks.MORTAR.get());
    }
    private void addPlayerInventory(Inventory pInventory){
        for(int i = 0; i< 3; ++i){
            for(int l = 0; l< 9 ; ++l){
                this.addSlot(new Slot(pInventory, l+i*9+9, 8+l*18, 86+i*18));
            }
        }
    }
    private void addHotbar(Inventory pInventory){
        for( int i=0; i<9; ++i){
            this.addSlot((new Slot(pInventory, i,8+i*18,144)));
        }
    }
}
