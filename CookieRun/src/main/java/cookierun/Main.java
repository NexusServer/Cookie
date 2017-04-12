package cookierun;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase implements Listener{

	@Override
	public void onEnable(){
		this.getLogger().notice("플러그인이 활성화 되었습니다");
	}
}
