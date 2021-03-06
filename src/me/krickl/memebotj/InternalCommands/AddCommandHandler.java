package me.krickl.memebotj.InternalCommands;

import me.krickl.memebotj.ChannelHandler;
import me.krickl.memebotj.CommandHandler;
import me.krickl.memebotj.UserHandler;

@Deprecated
public class AddCommandHandler extends CommandHandler {

	public AddCommandHandler(String channel, String command, String dbprefix) {
		super(channel, command, dbprefix);
		this.setAccess("moderators");
		this.setNeededCommandPower(25);
		this.setHelptext("Syntax: !addcommand <command> <output>");
	}

	@Override
	public void commandScript(UserHandler sender, ChannelHandler channelHandler, String[] data) {
		try {
			CommandHandler newCommand = new CommandHandler(this.getChannelOrigin(), "null", null);
			if (channelHandler.findCommand(data[0]) == -1) {
				newCommand.editCommand("name", data[0], new UserHandler("#internal#", "#internal#"),
						channelHandler.getUserList());
				newCommand.editCommand("access", "viewers", new UserHandler("#internal#", "#internal#"),
						channelHandler.getUserList());
				String output = data[1];

				for (int i = 2; i < data.length; i++) {
					output = output + " " + data[i];
				}

				newCommand.editCommand("output", output, new UserHandler("#internal#", "#internal#"),
						channelHandler.getUserList());
				channelHandler.sendMessage("Command " + newCommand.getCommand() + " created.", this.getChannelOrigin());

				channelHandler.getChannelCommands().add(newCommand);
			} else {
				channelHandler.sendMessage("This command already exists", this.getChannelOrigin());
			}
			channelHandler.sendMessage("This command is deprecated! Use !command instead.", this.getChannelOrigin());
		} catch (ArrayIndexOutOfBoundsException e) {
			channelHandler.sendMessage(channelHandler.getBuiltInStrings().get("ADDCOM_SYNTAX").replace("{param1}",
					"!meaddcom <command> <text>"), this.getChannelOrigin());
		}
	}

}
