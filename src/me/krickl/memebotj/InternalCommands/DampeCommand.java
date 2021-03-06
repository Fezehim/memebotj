package me.krickl.memebotj.InternalCommands;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

import me.krickl.memebotj.ChannelHandler;
import me.krickl.memebotj.CommandHandler;
import me.krickl.memebotj.UserHandler;

public class DampeCommand extends CommandHandler {

	public DampeCommand(String channel, String command, String dbprefix) {
		super(channel, command, dbprefix);
		this.setHelptext("Let dampe hate you for only all of your points");
		this.setCmdtype("list");
		this.setListContent(new ArrayList<String>());
		this.getListContent().add("Dampé slowly walks towards a grave...");
		this.getListContent().add("Dampé stops in the middle of the graveyard, but after half an hour he decides to dig a hole...");
		this.getListContent().add("Dampé is busy staring at what appears to be nothing...");
		this.setPointCost(100);
		this.setUserCooldownLen(200);
	}

	@Override
	public void commandScript(UserHandler sender, ChannelHandler channelHandler, String[] data) {
		try {
			//happy now luigitus?
			SecureRandom ran = new SecureRandom();
			int outcome = ran.nextInt(1000);
			Thread.sleep(100);
			if(outcome <= 1) {
				channelHandler.sendMessage("Dampé found " + Double.toString(10000) + " " + channelHandler.getBuiltInStrings().get("CURRENCY_EMOTE") + "! You lucky bastard!", this.getChannelOrigin());
				sender.setPoints(sender.getPoints() + 10000);
			}
			else if(outcome <= 10) {
				channelHandler.sendMessage("Dampé found " + Double.toString(1000) + " " + channelHandler.getBuiltInStrings().get("CURRENCY_EMOTE") + "! You lucky bastard!", this.getChannelOrigin());
				sender.setPoints(sender.getPoints() + 1000);
			} else if(outcome <= 100) {
				channelHandler.sendMessage("Dampé found " + Double.toString(200) + " " + channelHandler.getBuiltInStrings().get("CURRENCY_EMOTE") + "! Pretty good!", this.getChannelOrigin());
				sender.setPoints(sender.getPoints() + 200);
			} else if(outcome <= 600) {
				channelHandler.sendMessage("Dampé is being a dick and returned half of your " + channelHandler.getBuiltInStrings().get("CURRENCY_EMOTE") + "!", this.getChannelOrigin());
				sender.setPoints(sender.getPoints() + 50);
			}
			else {
				channelHandler.sendMessage("Dampé spent your " + channelHandler.getBuiltInStrings().get("CURRENCY_EMOTE") + " on hookers, booze and crack!", this.getChannelOrigin());
			}
		} catch(ArrayIndexOutOfBoundsException e) {
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
