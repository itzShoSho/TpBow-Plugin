Teleportation Bow Minecraft Plugin
This plugin adds a Teleportation Bow to Minecraft, allowing players to teleport to the location they shoot an arrow at.

Features
1) Shoot an arrow to teleport to the arrow's landing location
2) Permission node to control who can use the Teleportation Bow (configurable in source code or plugin.yml)

# Installation
Download the plugin file and place it in your server's plugins folder.
Restart your server or do (/reload).

# Configuration
The plugin configuration file is located at TeleportBow\src\main\resources\config.yml (or a similar filename). You can edit this file to:

# Cooldown timer in seconds
cooldown: 10

# Permission node
permission: 
  TeleportBow.givebow:
    description: A permission to get the teleport bow
    default: op

# Commands
  /tpbow

Support
If you have any issues with the plugin, please create an issue on the plugin's GitHub repository.
