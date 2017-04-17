package player;

import java.util.ArrayList;

import cn.nukkit.Server;

public abstract class Cookie{
	public static ArrayList<Cookie> cookies = new ArrayList<>();
	
	String name;
	int cookie;


	public Cookie(String name, int cookie, int speed, int jump, int size) {
		this.name = name;
		this.cookie = cookie;
	}
	public Cookie getCookie(String name){
		return cookies.stream().filter(c->c.name.equalsIgnoreCase(name)).findFirst().get();
	}
	public void addCookie(int count) {
		this.cookie += count;
	}

	public boolean reduceCookie(int count) {
		if (this.cookie < count) {
			return false;
		}
		this.cookie -= count;
		return true;
	}
	
	
}
