package player;

import java.util.ArrayList;
import java.util.HashMap;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.potion.Effect;
import cn.nukkit.scheduler.PluginTask;
import cn.nukkit.scheduler.Task;
import cn.nukkit.scheduler.TaskHandler;
import cookierun.Main;

public class Stat extends Cookie implements Update {
	public static final int ID = 1;
	public static final String COOKIENAME = "진화쿠키";

	final int period = 20;

	TaskHandler task;
	TaskHandler hpUpdate;

	public Stat(Player player, int cookie, int speed, int jump, int size) {
		super(ID, player.getName());
		this.name = player.getName().toLowerCase();

		cookies.get(player.getName().toLowerCase()).add(this);

		if (player.isOnline()) {
			this.isOnline = true;
		}

		this.player = player;
		this.speed = speed;
		this.jump = jump;
		this.size = size;

		this.bar = player.createBossBar("§l§c남은 체력", hp);

		Server.getInstance().getScheduler().scheduleRepeatingTask(new PluginTask<Main>(Main.instance) {
			@Override
			public void onRun(int currentTick) {
				if (inGameCookie.containsValue(get())) {
					update(player);
				}

			}
		}, period);
		Server.getInstance().getScheduler().scheduleRepeatingTask(new Task() {
			@Override
			public void onRun(int currentTick) {
				if (inGameCookie.containsValue(get())) {

					hp -= hps;
					player.updateBossBar("§l§c남은 체력", hp, bar);
				}
			}
		}, 20);

	}

	public void quit() {

	}

	public Cookie get() {
		return this;
	}

	public void speedUpdate(Player player) {
		player.getEffect(Effect.SPEED).setAmplifier(speed).setDuration(20 * 10).add(player, true);
	}

	public void jumpUpdate(Player player) {
		player.getEffect(Effect.JUMP).setAmplifier(jump).setDuration(20 * 10).add(player, true);
	}

	public void sizeUpdate(Player player) {
		player.setScale(sizes[size]);
	}

	public void update(Player player) {
		speedUpdate(player);
		jumpUpdate(player);
		sizeUpdate(player);
	}

	public boolean levelUp(Player player, int exp, int type) {
		switch (type) {
		case SPEED:
			if (speed >= maxSpeed) {
				player.sendMessage("§e당신은 이미 §b§lSPEED§r§f레벨이 최대치 입니다.");
				return false;
			} else if (speedLevel[speed] < exp) {
				player.sendMessage("§e§l쿠키§r§e가 충분하지 않습니다!");
				return false;
			}
			speed += 1;
			player.sendMessage("§e성공적으로 §b§lSPEED§r§e레벨을 상승시켰습니다.  §l§b현재 레벨 : " + speed);
			return true;

		case JUMP:
			if (jump >= maxJump) {
				player.sendMessage("§e당신은 이미 §a§lJUMP§r§f레벨이 최대치 입니다.");
				return false;
			} else if (jumpLevel[jump] < exp) {
				player.sendMessage("§e§l쿠키§r§e가 충분하지 않습니다!");
				return false;
			}
			jump += 1;
			player.sendMessage("§e성공적으로 §a§lJUMP§r§e레벨을 상승시켰습니다.  §l§b현재 레벨 : " + jump);
			return true;

		case SIZE:
			if (size >= maxSize) {
				player.sendMessage("§e당신은 이미 §d§lSIZE§r§f레벨이 최대치 입니다.");
				return false;
			} else if (sizeLevel[size] < exp) {
				player.sendMessage("§e§l쿠키§r§e가 충분하지 않습니다!");
				return false;
			}
			size += 1;
			player.sendMessage("§e성공적으로 §d§lSIZE§r§e레벨을 상승시켰습니다.  §l§b현재 레벨 : " + size);
			return true;
		}
		return false;
	}

}
