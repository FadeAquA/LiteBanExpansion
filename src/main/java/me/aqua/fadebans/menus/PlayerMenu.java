package me.aqua.fadebans.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class PlayerMenu implements InventoryHolder {

    private String reason;
    private int time;
    private final Inventory inventory;
    private final Player offensePlayer;

    public PlayerMenu(Player offensePlayer, String reason, int time, String title, int size) {
        this.offensePlayer = offensePlayer;
        this.reason = reason;
        this.time = time;
        this.inventory = Bukkit.createInventory(this, size, title);
        addItems();
    }

    public Player getOffensePlayer() {
        return offensePlayer;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public abstract void addItems();

    public void open(Player player) {
        player.openInventory(inventory);
    }


    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
