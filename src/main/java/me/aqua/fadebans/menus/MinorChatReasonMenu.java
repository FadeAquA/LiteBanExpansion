package me.aqua.fadebans.menus;

import me.aqua.fadebans.utils.ItemBuilder;
import me.aqua.fadebans.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MinorChatReasonMenu extends PlayerMenu {

    public MinorChatReasonMenu(Player player) {
        super(player, null, 0, "Select Reason", 27);
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
        ItemStack spam = new ItemBuilder(Material.PAPER)
                .setName("&b&lSpam")
                .build();
        getInventory().setItem(9, spam);
        ItemStack harassment = new ItemBuilder(Material.PAPER)
                .setName("&b&lHarassment")
                .build();
        getInventory().setItem(11, harassment);
        ItemStack mildOffenseLanguage = new ItemBuilder(Material.PAPER)
                .setName("&b&lMild Offense Language")
                .build();
        getInventory().setItem(13, mildOffenseLanguage);
        ItemStack illegaldeals = new ItemBuilder(Material.PAPER)
                .setName("&b&Offering Illegal Trades")
                .build();
        getInventory().setItem(15, illegaldeals);
        ItemStack unintentionalads = new ItemBuilder(Material.PAPER)
                .setName("&b&lUnintentional Advertisments")
                .build();
        getInventory().setItem(17, unintentionalads);
    }
}
