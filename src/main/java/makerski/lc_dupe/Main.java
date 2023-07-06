package makerski.lc_dupe;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {
    @Override
    public void onEnable() {
        getCommand("dupe").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack heldItem = player.getInventory().getItemInMainHand();
            if (heldItem.getType() != Material.AIR) {
                player.sendTitle("§2Sukces", "§aPomyślnie skopiowano " + player.getItemInHand().getAmount() + "x " + player.getItemInHand().getType().toString().toLowerCase());
                player.playSound(player.getLocation(), Sound.BLOCK_SHULKER_BOX_OPEN, 1,1);
                player.getInventory().addItem(new ItemStack[] { player.getItemInHand() });


                return true;
            } else {
                player.sendTitle("", "§cNie trzymasz żadnego przedmiotu w ręce!");
            }
        } else {
            sender.sendMessage("Komenda dostępna tylko dla graczy!");
        }

        return false;
    }
}

