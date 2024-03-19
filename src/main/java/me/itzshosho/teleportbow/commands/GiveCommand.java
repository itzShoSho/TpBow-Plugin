package me.itzshosho.teleportbow.commands;

import me.itzshosho.teleportbow.utility.BowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player p) {
            if (p.hasPermission("TeleportBow.givebow")) {
                if (args.length == 0) {
                    //I can refer to the bow from an external class and that's what I did here
                    ItemStack bow = BowUtils.createTpBow();

                    p.getInventory().addItem(bow);
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));

                    p.sendMessage(ChatColor.BLUE + "You have given yourself a teleport bow");

                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if (target == null) {
                        p.sendMessage(ChatColor.RED + "Player is offline or not found. Try checking the name and try again.");

                        return true;
                    }

                    //here as well
                    ItemStack bow = BowUtils.createTpBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW, 1));

                    target.sendMessage(ChatColor.BLUE + "You have been given a teleport bow");

                }
            } else {
                p.sendMessage(ChatColor.RED + "You do not have the permission to run this command.");
            }
        } else if (sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                System.out.println("Provide a player to give the bow to...");

            } else {
                Player target = Bukkit.getPlayerExact(args[0]);

                if (target == null) {
                    System.out.println("Player is offline or not found. Try checking the name and try again.");

                    return true;
                }

                //here as well
                ItemStack bow = BowUtils.createTpBow();
                target.getInventory().addItem(bow);
                target.getInventory().addItem(new ItemStack(Material.ARROW, 1));

                target.sendMessage(ChatColor.BLUE + "You have been given a teleport bow");
            }
        }else {
            System.out.println("To run this command please use the console or from a player with perms.");
        }

        return true;
    }
}
