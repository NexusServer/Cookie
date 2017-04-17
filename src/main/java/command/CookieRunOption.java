package command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class CookieRunOption extends Command {
	public CookieRunOption() {
		super("쿠키런관리", "쿠키런을 관리합니다", "/쿠키런 관리 <월드추가,시작지,도착지,도착보상>");
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if (!sender.isOp()) {
			sender.sendMessage("당신은 해당 명령어를 사용할 권한이 없습니다");
		}
		switch (args[0]) {
		case value:
			
			break;

		default:
			break;
		}
		return false;
	}

}
