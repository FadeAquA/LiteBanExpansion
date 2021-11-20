package me.aqua.fadebans.listeners;

import me.aqua.fadebans.menus.MainMenu;
import me.aqua.fadebans.menus.MajorChatReasonMenu;
import me.aqua.fadebans.menus.MinorChatReasonMenu;
import me.aqua.fadebans.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListeners implements Listener {

    @EventHandler
    public void onMainMenuEvent(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        System.out.println(event.getView().getTopInventory().getHolder());
        if (event.getView().getTopInventory().getHolder() instanceof MainMenu) {
            event.setCancelled(true);
            MainMenu menu = (MainMenu) event.getView().getTopInventory().getHolder();

            String itemClicked = menu.getItemName(event.getSlot());
            if (itemClicked == null) return;
            switch (itemClicked) {
                case "minoroffenses": {
                    MinorChatReasonMenu gui = new MinorChatReasonMenu(player);
                    gui.open(player);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                    break;
                }
                case "majoroffenses": {
                    MajorChatReasonMenu gui = new MajorChatReasonMenu(player);
                    gui.open(player);
                    player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                    break;
                }
            }
        }
    }

    @EventHandler
    public void onMinorChatOffenseMenu(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase("Select Reason")) {
            event.setCancelled(false);
            if (event.getCurrentItem() == null) return;

            if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Utils.color("&c&lBack"))) {
                MainMenu gui = new MainMenu(player);
                gui.open(player);
            }
        }
    }
}
