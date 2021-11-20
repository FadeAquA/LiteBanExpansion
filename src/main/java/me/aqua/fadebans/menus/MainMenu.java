package me.aqua.fadebans.menus;

import me.aqua.fadebans.utils.ItemBuilder;
import me.aqua.fadebans.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class MainMenu extends PlayerMenu {

    private final Map<Integer, String> slots;

    public MainMenu(Player player) {
        super(player, null, 0, "Select Punish Category", 27);
        slots = new HashMap<>();
    }

    @Override
    public void addItems() {
        for (int i = 0; i < getInventory().getSize(); ++i) {
            ItemStack filler_item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta itemmeta = filler_item.getItemMeta();
            itemmeta.setDisplayName(" ");
            filler_item.setItemMeta(itemmeta);
            getInventory().setItem(i, filler_item);
        }
        ItemBuilder itemBuilder = new ItemBuilder(Material.PAPER);
        itemBuilder.setName("&b&lMinor Offense");
        itemBuilder.addLoreLine("&7- &fSpam", "&7- &fHarassment", "&7- &fMild Offensive Language", "&7- &fOffering Illegal Trades", "&7- &fUnintentional Advertisements");
        getInventory().setItem(12, itemBuilder.build());
        slots.put(12, "minoroffenses");

        ItemStack itemBuilder1 = new ItemBuilder(Material.PAPER)
                .setName("&b&lMajor Offense")
                .addLoreLine("&7- &fHarsh Offensive Language", "&7- &fThreats")
                .build();
        getInventory().setItem(14, itemBuilder1);
        slots.put(14, "majoroffenses");

    }

    public String getItemName(int slot) {
        return slots.getOrDefault(slot, null);
    }
}
