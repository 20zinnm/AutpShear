package autoshear;

import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Colorable;

public class AutoShearListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Sheep) {
			e.setCancelled(true);
			Entity sheep = e.getRightClicked();
			DyeColor color = ((Colorable) sheep).getColor();
			@SuppressWarnings("deprecation")
			byte colorS = color.getWoolData();
			Location loc = sheep.getLocation();
			sheep.remove();
			Player p = e.getPlayer();
			Entity newSheep = loc.getWorld().spawnEntity(loc, EntityType.SHEEP);
			((Sheep)newSheep).setColor(color);
			p.getInventory().addItem(new ItemStack(Material.WOOL, 1, (short) colorS));
		}
	}
}