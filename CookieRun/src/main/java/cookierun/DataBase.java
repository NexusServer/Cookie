package cookierun;

import com.google.gson.internal.LinkedHashTreeMap;

import cn.nukkit.Server;
import cn.nukkit.utils.Config;

public class DataBase {
	LinkedHashTreeMap<String, Double> cookie = new LinkedHashTreeMap<String, Double>();

	@SuppressWarnings("unchecked")
	public DataBase(Main main) {
		main.getDataFolder().mkdirs();
		Config data = new Config(main.getDataFolder() + "/cookie.json");
		cookie = (LinkedHashTreeMap) data.getAll();
	}

	public double addCookie(String user, Double count) {
		cookie.put(user.toLowerCase(), this.getCookie(user) + count);
		if (Server.getInstance().getPlayer(user).getName().equals(user)) {
			Server.getInstance().getPlayerExact(user).sendMessage("��6��Ű�� ��f"+count+"��r��6�� ���޵Ǿ����ϴ�.");
		}
		return this.getCookie(user);
	}

	public double reduceCookie(String user, Double count) {
		cookie.put(user.toLowerCase(), this.getCookie(user) - count);
		if (Server.getInstance().getPlayer(user).getName().equals(user)) {
			Server.getInstance().getPlayerExact(user).sendMessage("��6��Ű�� ��f"+count+"��r��6�� �����Ǿ����ϴ�.");
		}
		return this.getCookie(user);
	}

	public double getCookie(String user) {
		return cookie.get(user.toLowerCase());
	}
}
