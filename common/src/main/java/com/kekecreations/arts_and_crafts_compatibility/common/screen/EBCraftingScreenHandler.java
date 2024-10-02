package com.kekecreations.arts_and_crafts_compatibility.common.screen;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.level.block.Block;

//Original file is from Excessive Building by Yirmiri
public class EBCraftingScreenHandler extends CraftingMenu {
    private final Block block;
    private final ContainerLevelAccess context;

    public EBCraftingScreenHandler(int syncId, Inventory playerInventory, Block block) {
        this(syncId, playerInventory, ContainerLevelAccess.NULL, block);
    }

    public EBCraftingScreenHandler(int syncId, Inventory playerInventory, ContainerLevelAccess context, Block block) {
        super(syncId, playerInventory, context);
        this.block = block;
        this.context = context;
    }

    public boolean stillValid(Player player) {
        return stillValid(this.context, player, this.block);
    }
}
