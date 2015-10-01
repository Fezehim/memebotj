package me.krickl.memebotj.InternalCommands;

import me.krickl.memebotj.BuildInfo;
import me.krickl.memebotj.ChannelHandler;
import me.krickl.memebotj.CommandHandler;
import me.krickl.memebotj.Memebot;
import me.krickl.memebotj.UserHandler;

public class AboutCommand extends CommandHandler {

	public AboutCommand(String channel, String command, String dbprefix) {
		super(channel, command, dbprefix);
		this.setHelptext("");
	}

	@Override
	public void commandScript(UserHandler sender, ChannelHandler channelHandler, String[] data) {
		channelHandler.sendMessage("memebot-j version " + BuildInfo.version + " build " + BuildInfo.buildNumber
				+ ". Developed by " + BuildInfo.dev, this.getChannelOrigin());
		channelHandler.sendMessage(
				"Licence: https://github.com/unlink2/memebotj/blob/master/license.md || Fork me RitzMitz : https://github.com/unlink2/memebotj",
				this.getChannelOrigin());
	}
}
