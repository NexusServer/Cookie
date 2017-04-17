package player;

import cn.nukkit.scheduler.TaskHandler;

public interface Update {
	int period = 20 * 1;
	TaskHandler task = null;
	TaskHandler hpUpdate = null;
	boolean run = false;
}
