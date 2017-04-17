package cookierun;

import java.util.HashMap;

import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;
import player.Stat;

public class Main extends PluginBase implements Listener {
	public static Main instance;
	public static final String[] color = { "§e", "§b", "§c", "§r", "§l" };

	@Override
	public void onEnable() {
		instance = this;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		new Stat(e.getPlayer(), 100, 2, 3, 2);
	}
}
