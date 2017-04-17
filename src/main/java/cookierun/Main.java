package cookierun;

import java.util.HashMap;

import cn.nukkit.Server;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

public class Main extends PluginBase implements Listener {
	public static Main instance;
	public static final String[] color = { "§e", "§b", "§c", "§r", "§l" };

	@Override
	public void onEnable() {
		instance = this;
	}

	@EventHandler
	public void onChat(PlayerChatEvent ev) {
		if (ev.getMessage().contains("#")) {
			String message = ev.getMessage();
			String[] str = ev.getMessage().split("#");
			for (int i = 1; i < str.length; i++) {
				String name = str[i].split(" ", 1)[0];
				Server.getInstance().getPlayer(name);
				message.replace("#"+name, "§l§b"+Server.getInstance().getPlayer(name).getName()+"§r");
			}
		}
	}
}
