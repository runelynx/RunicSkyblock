/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.runelynx.runicskyblock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;

import org.bukkit.Bukkit;

import static org.bukkit.Bukkit.getLogger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


/**
 *
 * @author Andrew
 */
public class Ranks {

	private Plugin instance = RunicSkyblock.getInstance();


	final int RUNNER_DAYS = 7;
	final int RUNNER_RUNICS = 2500;
	final String RUNNER_KILLS = "Zombie:15, Spider:5, Skeleton:10";
	final int SINGER_DAYS = 21;
	final int SINGER_RUNICS = 5000;
	final int SINGER_JOB_LEVEL = 5;
	final String SINGER_KILLS = "Zombie:100, Skeleton:100, Spider:50";
	final int BRAWLER_DAYS = 35;
	final int BRAWLER_RUNICS = 10000;
	final int BRAWLER_JOB_LEVEL = 15;
	final String BRAWLER_KILLS = "PigZombie:25, Enderman:15, Witch:2";
	final int KEEPER_DAYS = 49;
	final int KEEPER_RUNICS = 15000;
	final int KEEPER_MASTER_JOBS = 1;
	final String KEEPER_KILLS = "Zombie:200, Skeleton:200, Spider:100, Wither:1";
	final int GUARD_DAYS = 63;
	final int GUARD_RUNICS = 25000;
	final String GUARD_KILLS = "PigZombie:50, Enderman:30, Witch:5";
	final int HUNTER_DAYS = 77;
	final int HUNTER_RUNICS = 40000;
	final int HUNTER_MASTER_JOBS = 2;
	final String HUNTER_KILLS = "Zombie:300, Skeleton:300, Spider:150, Wither:2";
	final int SLAYER_DAYS = 98;
	final int SLAYER_RUNICS = 60000;
	final String SLAYER_KILLS = "PigZombie:100, Enderman:45, Witch:10";
	final int WARDER_DAYS = 17 * 7;
	final int WARDER_RUNICS = 80000;
	final int WARDER_MASTER_JOBS = 3;
	final String WARDER_KILLS = "Zombie:400, Skeleton:400, Spider:200, Wither:3";
	final int CHAMPION_DAYS = 20 * 7;
	final int CHAMPION_RUNICS = 100000;
	final String CHAMPION_KILLS = "PigZombie:150, Enderman:60, Witch:25";
	final int MASTER_DAYS = 23 * 7;
	final int MASTER_RUNICS = 125000;
	final int MASTER_MASTER_JOBS = 6;
	final String MASTER_KILLS = "TBD";

	final int EXPLORER_DAYS = 7;
	final int EXPLORER_RUNICS = 2500;
	final String EXPLORER_KILLS = "Zombie:15, Spider:5, Skeleton:10";
	final int BUILDER_DAYS = 21;
	final int BUILDER_RUNICS = 5000;
	final int BUILDER_JOB_LEVEL = 5;
	final String BUILDER_KILLS = "Zombie:100, Skeleton:50, Squid:20, Spider:25";
	final int ARCHITECT_DAYS = 42;
	final int ARCHITECT_RUNICS = 10000;
	final int ARCHITECT_JOB_LEVEL = 10;
	final String ARCHITECT_KILLS = "Blaze:15, PigZombie:50, Ghast:10, Zombie:200";
	final int WARDEN_DAYS = 60;
	final int WARDEN_RUNICS = 20000;
	final int WARDEN_JOB_LEVEL = 15;
	final String WARDEN_KILLS = "Skeleton:100, Witch:20, Creeper:20, Cavespider: 25, IronGolem: 3";
	final int PROTECTOR_DAYS = 90;
	final int PROTECTOR_RUNICS = 40000;
	final int PROTECTOR_JOB_LEVEL = 20;
	final String PROTECTOR_KILLS = "Wither:1, Ghast:25, Spider:50, Enderman:25, IronGolem: 10";
	final int GUARDIAN_DAYS = 120;
	final int GUARDIAN_RUNICS = 60000;
	final String GUARDIAN_KILLS = "Wither:2, Zombie:400, Witch:100, Creeper:50, Spider:100, Skeleton:300";

	public Ranks() {

	}

	public void congratsPromotion(String promoted, String newRank) {

		// RG.sendMessage(true, promoted, ChatColor.GOLD
		// + "[RunicRanks] Congratulations, " + promoted
		// + ", on promoting to " + newRank + "!");

		for (Player p : Bukkit.getOnlinePlayers()) {
		//	TitleAPI.sendTitle(p, 2, 3, 2,
		//			RunicParadise.rankColors.get(newRank) + "" + ChatColor.BOLD
		//					+ promoted, RunicParadise.rankColors.get(newRank)
		//					+ "has reached the rank of " + newRank);
		}

		
	}

	public void playerkillCounts(Player user) {
		Date now = new Date();

		MySQL MySQL = new MySQL(instance, instance.getConfig().getString(
				"dbHost"), instance.getConfig().getString("dbPort"), instance
				.getConfig().getString("dbDatabase"), instance.getConfig()
				.getString("dbUser"), instance.getConfig().getString(
				"dbPassword"));
		final Connection d = MySQL.openConnection();

		user.sendMessage(ChatColor.GRAY
				+ "[RunicRanks] Listing player kill counts...");

		for (Player p : Bukkit.getOnlinePlayers()) {
			try {
				Statement dStmt = d.createStatement();
				ResultSet playerData = dStmt
						.executeQuery("SELECT * FROM `rp_PlayerInfo` WHERE `PlayerName` = '"
								+ p.getName() + "' ORDER BY `id` ASC LIMIT 1;");
				playerData.next();
				int killZombie = playerData.getInt("KillZombie");
				int killSkeleton = playerData.getInt("KillSkeleton");
				int killWitch = playerData.getInt("KillWitch");
				int killWither = playerData.getInt("KillWither");
				int killSlime = playerData.getInt("KillSlime");
				int killMagmaCube = playerData.getInt("KillMagmaCube");
				int killSilverfish = playerData.getInt("KillSilverfish");
				int killGiant = playerData.getInt("KillGiant");
				int killBlaze = playerData.getInt("KillBlaze");
				int killCreeper = playerData.getInt("KillCreeper");
				int killEnderman = playerData.getInt("KillEnderman");
				int killSpider = playerData.getInt("KillSpider");
				int killCavespider = playerData.getInt("KillCaveSpider");
				int killSquid = playerData.getInt("KillSquid");
				int killEnderdragon = playerData.getInt("KillEnderDragon");
				int killPigzombie = playerData.getInt("KillPigZombie");
				int killGhast = playerData.getInt("KillGhast");

				user.sendMessage(ChatColor.GOLD + p.getName() + ": "
						+ ChatColor.GRAY + "Zom:" + killZombie + "," + "Ske:"
						+ killSkeleton + "," + "Wch:" + killWitch + ","
						+ "Wth:" + killWither + "," + "Sli:" + killSlime + ","
						+ "Mag:" + killMagmaCube + "," + "Slv:"
						+ killSilverfish + "," + "Gia:" + killGiant + ","
						+ "Blz:" + killBlaze + "," + "Crp:" + killCreeper + ","
						+ "EnM:" + killEnderman + "," + "EnD:"
						+ killEnderdragon + "," + "Spd:" + killSpider + ","
						+ "Cav:" + killCavespider + "," + "Sqd:" + killSquid
						+ "," + "PgZ:" + killPigzombie + "," + "Gha:"
						+ killGhast);
			} catch (SQLException e) {
				getLogger().log(
						Level.SEVERE,
						"Failed DB check for playerStats because: "
								+ e.getMessage());
			}
		}

		try {
			d.close();
		} catch (SQLException e) {
			getLogger().log(
					Level.SEVERE,
					"Failed DB close for playerStats because: "
							+ e.getMessage());
		}
	}

	public void playerStats(Player user) {
		Date now = new Date();

		MySQL MySQL = new MySQL(instance, instance.getConfig().getString(
				"dbHost"), instance.getConfig().getString("dbPort"), instance
				.getConfig().getString("dbDatabase"), instance.getConfig()
				.getString("dbUser"), instance.getConfig().getString(
				"dbPassword"));
		final Connection d = MySQL.openConnection();
		double daysPlayed = 0;
		int balance = 0;
		int isNominated = 0;

		user.sendMessage(ChatColor.GRAY
				+ "[RunicRanks] Listing player stats...");

		for (Player p : Bukkit.getOnlinePlayers()) {
			try {
				Statement dStmt = d.createStatement();
				ResultSet playerData = dStmt
						.executeQuery("SELECT `FirstSeen`, `IsNominated`, `Votes` FROM `rp_PlayerInfo` WHERE `PlayerName` = '"
								+ p.getName() + "' ORDER BY `id` ASC LIMIT 1;");
				playerData.next();

				balance = (int) RunicSkyblock.economy.getBalance(p);
				;
				long firstSeenTime = playerData.getLong("FirstSeen");
				isNominated = playerData.getInt("IsNominated");
				daysPlayed = ((now.getTime() - firstSeenTime) / 86400000);
				DecimalFormat df = new DecimalFormat("#,###.##");

				user.sendMessage(ChatColor.GRAY + p.getName() + ": "
						+ ChatColor.LIGHT_PURPLE + df.format(daysPlayed)
						+ " days, " + balance + " R, noms(" + isNominated
						+ "), votes(" + playerData.getInt("Votes") + ")");
			} catch (SQLException e) {
				getLogger().log(
						Level.SEVERE,
						"Failed DB check for playerStats because: "
								+ e.getMessage());
			}
		}

		try {
			d.close();
		} catch (SQLException e) {
			getLogger().log(
					Level.SEVERE,
					"Failed DB close for playerStats because: "
							+ e.getMessage());
		}
	}

	public void showRequirements(Player user) {
		int nomRedux;

		MySQL MySQL = new MySQL(instance, instance.getConfig().getString(
				"dbHost"), instance.getConfig().getString("dbPort"), instance
				.getConfig().getString("dbDatabase"), instance.getConfig()
				.getString("dbUser"), instance.getConfig().getString(
				"dbPassword"));
		final Connection d = MySQL.openConnection();
		int nominations = 0;

		try {
			Statement dStmt = d.createStatement();
			ResultSet playerData = dStmt
					.executeQuery("SELECT * FROM `rp_PlayerInfo` WHERE `PlayerName` = '"
							+ user.getName() + "' ORDER BY `id` ASC LIMIT 1;");
			// if this is true, there is a result!
			if (playerData.isBeforeFirst()) {
				playerData.next();
				nominations = playerData.getInt("IsNominated");
			}
			d.close();
		} catch (SQLException e) {
			getLogger().log(
					Level.SEVERE,
					"Failed DB check for showRequirements because: "
							+ e.getMessage());
		}

		if (nominations > 0) {
			nomRedux = 10;
		} else {
			nomRedux = 0;
		}

		user.sendMessage(ChatColor.GRAY
				+ "[RunicRanks] Listing promotion requirements...");
		user.sendMessage(ChatColor.DARK_GREEN + "Runner - " + ChatColor.GRAY
				+ RUNNER_DAYS + " days or 15 votes, " + RUNNER_RUNICS + " R.");
		user.sendMessage(ChatColor.GRAY + RUNNER_KILLS);
		user.sendMessage(ChatColor.YELLOW + "Singer - " + ChatColor.GRAY
				+ SINGER_DAYS + " days, " + SINGER_RUNICS
				+ " R, hedge maze, sun or moon faith >25.");
		user.sendMessage(ChatColor.GRAY + SINGER_KILLS);
		user.sendMessage(ChatColor.GOLD + "Brawler - " + ChatColor.GRAY
				+ BRAWLER_DAYS + " days, " + BRAWLER_RUNICS + " R, sky maze.");
		user.sendMessage(ChatColor.GRAY + BRAWLER_KILLS);
		user.sendMessage(ChatColor.AQUA + "Keeper - " + ChatColor.GRAY
				+ KEEPER_DAYS + " days, " + KEEPER_RUNICS + " R, "
				+ KEEPER_MASTER_JOBS
				+ " jobs mastered, ice maze, faith power level >100.");
		user.sendMessage(ChatColor.GRAY + KEEPER_KILLS);
		user.sendMessage(ChatColor.DARK_AQUA + "Guard - " + ChatColor.GRAY
				+ GUARD_DAYS + " days, " + GUARD_RUNICS + " R, jungle maze.");
		user.sendMessage(ChatColor.GRAY + GUARD_KILLS);
		user.sendMessage(ChatColor.BLUE + "Hunter - " + ChatColor.GRAY
				+ HUNTER_DAYS + " days, " + HUNTER_RUNICS + " R, "
				+ HUNTER_MASTER_JOBS
				+ " jobs mastered, frost maze, faith power level >150.");
		user.sendMessage(ChatColor.GRAY + HUNTER_KILLS);
		user.sendMessage(ChatColor.DARK_BLUE + "Slayer - " + ChatColor.GRAY
				+ SLAYER_DAYS + " days, " + SLAYER_RUNICS + " R.");
		user.sendMessage(ChatColor.GRAY + SLAYER_KILLS);
		user.sendMessage(ChatColor.LIGHT_PURPLE + "Warder - " + ChatColor.GRAY
				+ WARDER_DAYS + " days, " + WARDER_RUNICS + " R, "
				+ WARDER_MASTER_JOBS + " jobs mastered");
		user.sendMessage(ChatColor.GRAY + WARDER_KILLS);
		user.sendMessage(ChatColor.DARK_PURPLE + "Champion - " + ChatColor.GRAY
				+ CHAMPION_DAYS + " days, " + CHAMPION_RUNICS
				+ " R., faith power level 300.");
		user.sendMessage(ChatColor.GRAY + CHAMPION_KILLS);
		user.sendMessage(ChatColor.RED + "Master - " + ChatColor.GRAY
				+ MASTER_DAYS + " days, " + MASTER_RUNICS + " R, "
				+ MASTER_MASTER_JOBS + " jobs mastered, dungeon maze.");
		user.sendMessage(ChatColor.GRAY + MASTER_KILLS);

		/*
		 * user.sendMessage(ChatColor.DARK_GREEN + "Explorer - " +
		 * ChatColor.GRAY + EXPLORER_DAYS + " days or 20 votes, " +
		 * EXPLORER_RUNICS + " R."); user.sendMessage(ChatColor.GRAY +
		 * EXPLORER_KILLS); user.sendMessage(ChatColor.YELLOW + "Builder - " +
		 * ChatColor.GRAY + BUILDER_DAYS + " days, " + BUILDER_RUNICS +
		 * " R, joblevel " + BUILDER_JOB_LEVEL); user.sendMessage(ChatColor.GRAY
		 * + BUILDER_KILLS); user.sendMessage(ChatColor.GOLD + "Architect - " +
		 * ChatColor.GRAY + ARCHITECT_DAYS + " days, " + ARCHITECT_RUNICS +
		 * " R, joblevel " + ARCHITECT_JOB_LEVEL + ", hedge maze.");
		 * user.sendMessage(ChatColor.GRAY + ARCHITECT_KILLS);
		 * user.sendMessage(ChatColor.AQUA + "Warden - " + ChatColor.GRAY +
		 * (WARDEN_DAYS - nomRedux) + " days, " + WARDEN_RUNICS +
		 * " R, joblevel " + WARDEN_JOB_LEVEL + ", sky maze.");
		 * user.sendMessage(ChatColor.GRAY + WARDEN_KILLS);
		 * user.sendMessage(ChatColor.DARK_AQUA + "Protector - " +
		 * ChatColor.GRAY + (PROTECTOR_DAYS - nomRedux) + " days, " +
		 * PROTECTOR_RUNICS + " R, joblevel " + PROTECTOR_JOB_LEVEL);
		 * user.sendMessage(ChatColor.GRAY + PROTECTOR_KILLS);
		 * user.sendMessage(ChatColor.BLUE + "Guardian - " + ChatColor.GRAY +
		 * (GUARDIAN_DAYS - nomRedux) + " days, " + GUARDIAN_RUNICS + " R.");
		 * user.sendMessage(ChatColor.GRAY + GUARDIAN_KILLS);
		 * user.sendMessage(ChatColor.GOLD + "Type " + ChatColor.YELLOW +
		 * "/info ranks " + ChatColor.GOLD + "to learn what each rank can do.");
		 * if (nomRedux > 0) { user.sendMessage(ChatColor.AQUA +
		 * "You have a staff nomination! Your time requirements have been reduced."
		 * ); }
		 */
	}

	@SuppressWarnings("deprecation")
	public void convertRanks(final Player user) {
		String rank = RunicSkyblock.perms.getPrimaryGroup(user);
		boolean converted = false;
		String command = "";
		String command2 = "";
		String newRank = "";

		switch (rank) {
		case "Ghosts":
			command = "manuadd " + user.getName() + " Ghost";
			converted = true;
			break;
		case "Engineers":
		case "Adventurers":
		case "GameMasters":
		case "Farmers":
		case "Merchants":
		case "Citizens2":
		case "Miners":
		case "Architects":
		case "Citizens":
		case "Guides":
		case "Mayors":
		case "Mentors":
		case "Creators":
		case "Ambassadors":
		case "CityPlanners":
			command = "manuadd " + user.getName() + " Seeker";
			command2 = "faith enable " + user.getName() + " Sun";
			newRank = "Seeker";
			converted = true;
			break;
		case "Settler":
			if (user.hasPermission("rp.ascend")) {
				command = "manuadd " + user.getName() + " Seeker";
				converted = true;
				newRank = "Seeker";
			}
			break;
		case "Explorer":
		case "Builder":
			if (user.hasPermission("rp.ascend")) {
				command = "manuadd " + user.getName() + " Runner";
				converted = true;
				newRank = "Runner";
			}
			break;
		case "Architect":
		case "Warden":
		case "Protector":
			if (user.hasPermission("rp.ascend")) {
				command = "manuadd " + user.getName() + " Singer";
				converted = true;
				newRank = "Singer";
			}
			break;
		case "Guardian":
			if (user.hasPermission("rp.ascend")) {
				command = "manuadd " + user.getName() + " Brawler";
				newRank = "Brawler";
				converted = true;
			}
			break;

		default:
			break;
		}
		if (converted) {
			user.sendMessage(ChatColor.YELLOW + "[RunicRanks]" + ChatColor.GOLD
					+ " Welcome to the new ranks system!!");
			user.sendMessage(ChatColor.YELLOW + "[RunicRanks]" + ChatColor.GOLD
					+ " To learn how to get to the next rank, type /promote");
			user.sendMessage(ChatColor.YELLOW + "[RunicRanks]" + ChatColor.GOLD
					+ " To see what ranks we have, type /ranks");
			user.sendMessage(ChatColor.YELLOW
					+ "[RunicRanks]"
					+ ChatColor.GOLD
					+ " To learn about perks: http://www.runic-paradise.com/ranks.php");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sc Converting "
					+ user.getName() + " from " + rank + " to " + newRank);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
			Bukkit.getServer()
					.getScheduler()
					.scheduleAsyncDelayedTask(RunicSkyblock.getInstance(),
							new Runnable() {
								public void run() {
									Bukkit.dispatchCommand(
											Bukkit.getConsoleSender(),
											"faith enable " + user.getName()
													+ " Sun");
								}
							}, 60);

		}

	}

	public void nominatePlayer(Player sender, String nominee) {

		MySQL MySQL = new MySQL(instance, instance.getConfig().getString(
				"dbHost"), instance.getConfig().getString("dbPort"), instance
				.getConfig().getString("dbDatabase"), instance.getConfig()
				.getString("dbUser"), instance.getConfig().getString(
				"dbPassword"));
		final Connection d = MySQL.openConnection();
		int nominations = 0;
		boolean playerFound = false;
		try {
			Statement dStmt = d.createStatement();
			ResultSet playerData = dStmt
					.executeQuery("SELECT * FROM `rp_PlayerInfo` WHERE `PlayerName` = '"
							+ nominee + "' ORDER BY `id` ASC LIMIT 1;");
			// if this is true, there is a result!
			if (playerData.isBeforeFirst()) {
				playerData.next();
				nominations = playerData.getInt("IsNominated");
				playerFound = true;
			} else {
				sender.sendMessage(ChatColor.RED
						+ "[ERROR] Nomination failed. Could not find player named "
						+ nominee);
				d.close();
			}
		} catch (SQLException e) {
			getLogger().log(
					Level.SEVERE,
					"Failed DB check for nominatePlayer because: "
							+ e.getMessage());
		}

		if (playerFound) {
			try {
				Statement dStmt = d.createStatement();
				dStmt.executeUpdate("UPDATE `rp_PlayerInfo` SET IsNominated='"
						+ (nominations + 1) + "' WHERE PlayerName='" + nominee
						+ "';");
				d.close();
				sender.sendMessage(ChatColor.DARK_GREEN
						+ "[RunicRanks] Success! " + nominee + " now has "
						+ (nominations + 1) + " nominations");
				sender.getServer()
						.getPlayer(nominee)
						.sendMessage(
								ChatColor.DARK_GREEN
										+ "[RunicRanks] You have just been nominated for faster promotions by "
										+ sender.getDisplayName());
				sender.getServer()
						.getPlayer(nominee)
						.sendMessage(
								ChatColor.WHITE
										+ "Type /ranks to see your new requirements.");
				sender.getServer()
						.getPlayer(nominee)
						.sendMessage(
								ChatColor.WHITE
										+ "While multiple nominations are very nice, only the first one has an impact. :)");

			} catch (SQLException e) {
				getLogger().log(
						Level.SEVERE,
						"Failed DB update for nominatePlayer because: "
								+ e.getMessage());
			}
		}

	}

	public void checkPromotion(Player user, boolean execute) {
		Date now = new Date();

		MySQL MySQL = new MySQL(instance, instance.getConfig().getString(
				"dbHost"), instance.getConfig().getString("dbPort"), instance
				.getConfig().getString("dbDatabase"), instance.getConfig()
				.getString("dbUser"), instance.getConfig().getString(
				"dbPassword"));
		final Connection d = MySQL.openConnection();
		double daysPlayed = 0;
		DecimalFormat df = new DecimalFormat("#,###.##");
		String rank = "";
		int balance = (int) RunicSkyblock.economy.getBalance(user);
		int nomRedux = 0;
		boolean checkDays = false;
		boolean checkFaiths = false;
		boolean checkJob = false;
		boolean checkRunics = false;
		boolean checkKills = false;
		boolean checkMazes = false;
		boolean checkJobMasteries = false;
		boolean ineligible = false;
		ArrayList<String> failureResponse = new ArrayList<String>();
		int[] killsArray = new int[13];

		// ZOM,SPI,SKE,SQU,BLA,PGZ,GHA,WTH,WCH,ENM,CRE

		// Check how many days played; report days played and current rank to
		// user
		try {
			Statement dStmt = d.createStatement();
			ResultSet playerData = dStmt
					.executeQuery("SELECT * FROM `rp_PlayerInfo` WHERE `PlayerName` = '"
							+ user.getName() + "' ORDER BY `id` ASC LIMIT 1;");
			playerData.next();

			long firstSeenTime = playerData.getLong("FirstSeen");
			if (playerData.getInt("IsNominated") > 0) {
				nomRedux = 10;
			}
			daysPlayed = ((now.getTime() - firstSeenTime) / 86400000);

			rank = RunicSkyblock.perms.getPrimaryGroup(user);
			killsArray[0] = playerData.getInt("KillZombie");
			killsArray[1] = playerData.getInt("KillSpider");
			killsArray[2] = playerData.getInt("KillSkeleton");
			killsArray[3] = playerData.getInt("KillSquid");
			killsArray[4] = playerData.getInt("KillBlaze");
			killsArray[5] = playerData.getInt("KillPigZombie");
			killsArray[6] = playerData.getInt("KillGhast");
			killsArray[7] = playerData.getInt("KillWither");
			killsArray[8] = playerData.getInt("KillWitch");
			killsArray[9] = playerData.getInt("KillEnderman");
			killsArray[10] = playerData.getInt("KillCreeper");
			killsArray[11] = playerData.getInt("KillCaveSpider");
			killsArray[12] = playerData.getInt("KillIronGolem");
			// if you add more here, increase the array definition up above!!!

			user.sendMessage(ChatColor.DARK_GREEN
					+ "You first joined Runic Paradise " + daysPlayed
					+ " days ago. Your current rank is " + rank + ".");
		} catch (SQLException e) {
			getLogger().log(
					Level.SEVERE,
					"Failed DB check for checkPromotion because: "
							+ e.getMessage());
		}

		switch (rank) {
		case "Champion":
			// if player has been on the server long enough for promotion
			if ((daysPlayed - (double) MASTER_DAYS) > -0.4) {
				checkDays = true;
				failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
						+ ChatColor.GRAY + "Days on the server: "
						+ df.format(daysPlayed) + "; Required: " + MASTER_DAYS);
			} else {
				failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
						+ ChatColor.GRAY + "Days on the server: "
						+ df.format(daysPlayed) + "; Required: " + MASTER_DAYS);
			}
			if (balance >= MASTER_RUNICS) {
				checkRunics = true;
				failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
						+ ChatColor.GRAY + "Your runics: " + balance
						+ "; Promotion cost: " + MASTER_RUNICS);
			} else {
				failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
						+ ChatColor.GRAY + "Your runics: " + balance
						+ "; Promotion cost: " + MASTER_RUNICS);
			}

			if (killsArray[0] >= 400 && killsArray[1] >= 200
					&& killsArray[2] >= 400 && killsArray[7] >= 3) {
				checkKills = true;
				failureResponse
						.add(ChatColor.DARK_GREEN
								+ "[✔ OK] "
								+ ChatColor.GRAY
								+ "You have killed enough monsters for this promotion.");
			} else {
				if (killsArray[0] > 400) {
					failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
							+ ChatColor.GRAY + "Your ZOMBIE kills: "
							+ killsArray[0] + "; Required: 400");
				} else {
					failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
							+ ChatColor.GRAY + "Your ZOMBIE kills: "
							+ killsArray[0] + "; Required: 400");
				}
				if (killsArray[1] >= 200) {
					failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
							+ ChatColor.GRAY + "Your SPIDER kills: "
							+ killsArray[1] + "; Required: 200");
				} else {
					failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
							+ ChatColor.GRAY + "Your SPIDER kills: "
							+ killsArray[1] + "; Required: 200");
				}
				if (killsArray[2] >= 400) {
					failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
							+ ChatColor.GRAY + "Your SKELETON kills: "
							+ killsArray[2] + "; Required: 400");
				} else {
					failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
							+ ChatColor.GRAY + "Your SKELETON kills: "
							+ killsArray[2] + "; Required: 400");
				}
				if (killsArray[7] >= 3) {
					failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
							+ ChatColor.GRAY + "Your WITHER kills: "
							+ killsArray[7] + "; Required: 3");
				} else {
					failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
							+ ChatColor.GRAY + "Your WITHER kills: "
							+ killsArray[7] + "; Required: 3");
				}
			}
		
		

			if (checkDays && checkRunics && checkKills && checkJobMasteries
					&& checkMazes) {
				if (execute == false) {
					// just checking... we're not executing the promotion!!
					user.sendMessage(ChatColor.DARK_GREEN
							+ "[RunicRanks] Congratulations! You qualify for a promotion!");
					user.sendMessage(ChatColor.DARK_GREEN
							+ "Promotion to Master costs " + MASTER_RUNICS
							+ " Runics.");
					user.sendMessage(ChatColor.DARK_GREEN + "Type "
							+ ChatColor.AQUA + "/promote me"
							+ ChatColor.DARK_GREEN
							+ " to accept the promotion.");
				} else {
					// ok now we're executing the promotion.
					RunicSkyblock.economy.withdrawPlayer(user.getName(), MASTER_RUNICS);
					RunicSkyblock.perms.playerAddGroup(user, "Master");
					RunicSkyblock.perms.playerRemoveGroup(user, "Champion");
					user.sendMessage(ChatColor.DARK_GREEN
							+ "[RunicRanks] Congratulations! You have been promoted!");
					Ranks tempRank = new Ranks();
					tempRank.congratsPromotion(user.getName(), "Master");
					logPromotion(user.getName(), "Master", new Date().getTime());
				}
			} else {
				ineligible = true;
			}

			break;
		
		case "Builder":
			if ((daysPlayed - (double) ARCHITECT_DAYS) > -0.4) {
				checkDays = true;
				failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
						+ ChatColor.GRAY + "Days on the server: "
						+ df.format(daysPlayed) + "; Required: "
						+ ARCHITECT_DAYS);
			} else {
				failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
						+ ChatColor.GRAY + "Days on the server: "
						+ df.format(daysPlayed) + "; Required: "
						+ ARCHITECT_DAYS);
			}
			if (balance >= ARCHITECT_RUNICS) {
				checkRunics = true;
				failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
						+ ChatColor.GRAY + "Your runics: " + balance
						+ "; Promotion cost: " + ARCHITECT_RUNICS);
			} else {
				failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
						+ ChatColor.GRAY + "Your runics: " + balance
						+ "; Promotion cost: " + ARCHITECT_RUNICS);
			}
			if (killsArray[0] >= 200 && killsArray[4] >= 15
					&& killsArray[5] >= 50 && killsArray[6] >= 10) {
				checkKills = true;
				failureResponse
						.add(ChatColor.DARK_GREEN
								+ "[✔ OK] "
								+ ChatColor.GRAY
								+ "You have killed enough monsters for this promotion.");
			} else {
				if (killsArray[0] >= 200) {
					failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
							+ ChatColor.GRAY + "Your ZOMBIE kills: "
							+ killsArray[0] + "; Required: 200");
				} else {
					failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
							+ ChatColor.GRAY + "Your ZOMBIE kills: "
							+ killsArray[0] + "; Required: 200");
				}
				if (killsArray[4] >= 15) {
					failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
							+ ChatColor.GRAY + "Your BLAZE kills: "
							+ killsArray[4] + "; Required: 15");
				} else {
					failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
							+ ChatColor.GRAY + "Your BLAZE kills: "
							+ killsArray[4] + "; Required: 15");
				}
				if (killsArray[5] >= 50) {
					failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
							+ ChatColor.GRAY + "Your PIGZOMBIE kills: "
							+ killsArray[5] + "; Required: 50");
				} else {
					failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
							+ ChatColor.GRAY + "Your PIGZOMBIE kills: "
							+ killsArray[5] + "; Required: 50");
				}
				if (killsArray[6] >= 10) {
					failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
							+ ChatColor.GRAY + "Your GHAST kills: "
							+ killsArray[6] + "; Required: 10");
				} else {
					failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
							+ ChatColor.GRAY + "Your GHAST kills: "
							+ killsArray[6] + "; Required: 10");
				}

			}
			if (user.hasPermission("rp.level" + ARCHITECT_JOB_LEVEL)
					|| user.hasPermission("rp.level.master")) {
				checkJob = true;
				failureResponse.add(ChatColor.DARK_GREEN + "[✔ OK] "
						+ ChatColor.GRAY
						+ "You have obtained at least job level "
						+ ARCHITECT_JOB_LEVEL);
			} else {
				failureResponse.add(ChatColor.DARK_RED + "[✘ FAIL] "
						+ ChatColor.GRAY + "You need at least job level "
						+ ARCHITECT_JOB_LEVEL);
			}

		

			if (checkDays && checkRunics && checkKills && checkJob
					&& checkMazes) {
				if (execute == false) {
					// just checking... we're not executing the promotion!!
					user.sendMessage(ChatColor.DARK_GREEN
							+ "[RunicRanks] Congratulations! You qualify for a promotion!");
					user.sendMessage(ChatColor.DARK_GREEN
							+ "Promotion to ARCHITECT costs "
							+ ARCHITECT_RUNICS + " Runics.");
					user.sendMessage(ChatColor.DARK_GREEN + "Type "
							+ ChatColor.AQUA + "/promote me"
							+ ChatColor.DARK_GREEN
							+ " to accept the promotion.");
				} else {
					// ok now we're executing the promotion.
					RunicSkyblock.economy.withdrawPlayer(user.getName(), ARCHITECT_RUNICS);
					RunicSkyblock.perms.playerAddGroup(user, "Architect");
					RunicSkyblock.perms.playerRemoveGroup(user, "Builder");
					user.sendMessage(ChatColor.DARK_GREEN
							+ "[RunicRanks] Congratulations! You have been promoted!");
					Ranks tempRank = new Ranks();
					tempRank.congratsPromotion(user.getName(), "Architect");
					logPromotion(user.getName(), "Architect",
							new Date().getTime());
				}
			} else {
				ineligible = true;
			}

			break;
		default:
			user.sendMessage(ChatColor.RED
					+ "[RunicRanks] There are no more promotions at your rank!");
			break;
		}

		// if player isnt eligible, give them all the stored responses to tell
		// them why
		if (ineligible == true) {
			user.sendMessage(ChatColor.RED
					+ "[RunicRanks] You do not qualify for a promotion yet...");
			String[] itemArray = new String[failureResponse.size()];
			String[] returnedArray = failureResponse.toArray(itemArray);

			user.sendMessage(returnedArray);
		}

		// Close the connection
		try {
			d.close();
		} catch (SQLException e) {
			getLogger().log(
					Level.SEVERE,
					"Cant close mysql conn after checkpromotion: "
							+ e.getMessage());
		}

	}

	public static void logPromotion(String playerName, String newRank,
			Long timestamp) {
		final Plugin instance = RunicSkyblock.getInstance();
		MySQL MySQL = new MySQL(instance, instance.getConfig().getString(
				"dbHost"), instance.getConfig().getString("dbPort"), instance
				.getConfig().getString("dbDatabase"), instance.getConfig()
				.getString("dbUser"), instance.getConfig().getString(
				"dbPassword"));
		try {

			final Connection d = MySQL.openConnection();
			Statement dStmt = d.createStatement();
			int tempD = dStmt
					.executeUpdate("INSERT INTO rp_PlayerPromotions (`PlayerName`, `NewRank`, `TimeStamp`) VALUES "
							+ "('"
							+ playerName
							+ "', '"
							+ newRank
							+ "', "
							+ timestamp + ");");
			d.close();

		} catch (SQLException z) {
			getLogger().log(Level.SEVERE,
					"Failed DB check for logPromotion cuz " + z.getMessage());
		}
	}
	


}
