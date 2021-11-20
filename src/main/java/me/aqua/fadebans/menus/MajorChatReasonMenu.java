package me.aqua.fadebans.menus;

import me.aqua.fadebans.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MajorChatReasonMenu extends PlayerMenu {

    public MajorChatReasonMenu(Player player) {
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
        ItemStack harshoffensivelanguage = new ItemBuilder(Material.PAPER)
                .setName("&b&lHarsh Offensive Language")
                .build();
        getInventory().setItem(12, harshoffensivelanguage);

        ItemStack threats = new ItemBuilder(Material.PAPER)
                .setName("&b&lThreats")
                .build();
        getInventory().setItem(14, threats);

        ItemStack back = new ItemBuilder(Material.SPECTRAL_ARROW)
                .setName("&c&lBack")
                .addLoreLine("&eClick to view the punish categories")
                .build();
        getInventory().setItem(18, back);
    }
}
