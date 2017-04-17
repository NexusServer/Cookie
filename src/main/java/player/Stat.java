package player;

import java.util.ArrayList;

import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.potion.Effect;
import cn.nukkit.scheduler.PluginTask;
import cn.nukkit.scheduler.Task;
import cn.nukkit.scheduler.TaskHandler;
import cookierun.Main;

public class Stat extends Cookie implements Update {
	public static final int ID = 1;

	public static final int SPEED = 1;
	public static final int JUMP = 2;
	public static final int SIZE = 3;

	final int period = 20;
	Player player;

	int speed;
	int jump;
	int size;

	long bar;
	int hp;
	final int hps = 1;
	TaskHandler task;
	TaskHandler hpUpdate;

	int maxSpeed = speedLevel.length;
	int maxJump = jumpLevel.length;
	int maxSize = sizes.length;

	static int[] speedLevel = { 0, 10, 20, 40, 80, 150, 300, 800, 900, 1100, 1500 };
	static int[] jumpLevel = { 0, 100, 500, 600, 800, 1500 };
	static int[] sizeLevel = { 0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };

	static float[] sizes = { 1.0f, 1.5f, 1.75f, 2.0f, 2.25f, 2.5f, 2.75f, 2.90f, 3.0f };

	public Stat(Player player, int cookie, int speed, int jump, int size) {
		super(player.getName(), cookie, speed, jump, size);

		this.player = player;
		this.speed = speed;
		this.jump = jump;
		this.size = size;

		this.bar = player.createBossBar("§l§c남은 체력", hp);

		Server.getInstance().getScheduler().scheduleRepeatingTask(new PluginTask<Main>(Main.instance) {
			@Override
			public void onRun(int currentTick) {
				update(player);
			}
		}, period);
		Server.getInstance().getScheduler().scheduleRepeatingTask(new Task() {
			@Override
			public void onRun(int currentTick) {
				hp -= hps;
				player.updateBossBar("§l§c남은 체력", hp, bar);
			}
		}, 20);
		Cookie.cookies.add(this);

	}

	public void quit() {

	}

	@Override
	public void addCookie(int count) {
		super.addCookie(count);
		this.player.sendMessage("§e쿠키 §l§6" + count + "개§r§e를 획득하였습니다");
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
