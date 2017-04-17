package player;

import java.util.ArrayList;
import java.util.HashMap;

import cn.nukkit.Player;
import cn.nukkit.Server;

public abstract class Cookie {
	public static HashMap<String, Cookie> inGameCookie = new HashMap<>();
	public static HashMap<String, ArrayList<Cookie>> cookies = new HashMap<>();
	public static HashMap<String, ArrayList<Integer>> mycookie = new HashMap<>();
	public static HashMap<String, Integer> money = new HashMap<>();

	public static Class[] list;

	public static final String COOKIENAME = "쿠키";
	public static final int ID = 0;

	public static final int SPEED = 1;
	public static final int JUMP = 2;
	public static final int SIZE = 3;
	public static final int SHLED = 4;

	public boolean isSpeed = false;
	public boolean isJump = false;
	public boolean isSize = false;
	public boolean isShled = false;

	public boolean isOnline = false;

	String name;
	Player player;

	int speed;
	int jump;
	int size;

	int maxSpeed = speedLevel.length;
	int maxJump = jumpLevel.length;
	int maxSize = sizes.length;

	static int[] speedLevel = { 0, 10, 20, 40, 80, 150, 300, 800, 900, 1100, 1500 };
	static int[] jumpLevel = { 0, 100, 500, 600, 800, 1500 };
	static int[] sizeLevel = { 0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

	static float[] sizes = { 1.0f, 1.5f, 1.75f, 2.0f, 2.25f, 2.5f, 2.75f, 2.90f, 3.0f };

	long bar;
	int hp;
	final int hps = 1;

	public static void init() {
		list[Stat.ID] = Stat.class;
		
	}

	public Cookie(int id, String name) {
		if (mycookie.get(name.toLowerCase()).contains(id)) {
			
		}
	}

	public void addMoney(int point) {
		if (isOnline) {
			player.sendMessage("쿠키를 추가하였습니다");
		}
		money.put(name, money.get(name) + point);
	}

}
