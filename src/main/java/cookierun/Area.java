package cookierun;

import java.util.ArrayList;
import java.util.LinkedList;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import cn.nukkit.math.AxisAlignedBB;
import cn.nukkit.math.Vector3;
import player.Cookie;

public class Area {

	public static ArrayList<Cookie> inCookie = new ArrayList<>();

	Level stage;
	Vector3 start;
	Vector3 finsh;
	int cookie;

	public Area(Level stage, Vector3 start, Vector3 finsh, int cookie) {
	}

	public void start(Cookie cookie) {
	}

	public void finshed(Cookie cookie) {
	}
}
