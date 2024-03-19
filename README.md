Teleportation Bow Minecraft Plugin
This plugin adds a Teleportation Bow to Minecraft, allowing players to teleport to the location they shoot an arrow at.

Features
1) Shoot an arrow to teleport to the arrow's landing location
2) Permission node to control who can use the Teleportation Bow (configurable in source code or plugin.yml)
3) Cooldown timer after each teleport (configurable)

# Installation
1) Download the plugin file and place it in your server's plugins folder.
2) Restart your server or do (/reload).

# Configuration
The plugin configuration file is located at TeleportBow\src\main\resources\config.yml (or a similar filename). You can edit this file to:
1) Change the cooldown timer after each teleport
2) Change the bow's name
3) Change the message that pops up when you teleport
4) Change the bow's description
5) Decide whether to give a bow to the player on join (bool type)

# Permission node
permission: 
  TeleportBow.givebow:
    description: A permission to get the teleport bow
    default: op

# Commands
  /tpbow

Support
If you have any issues with the plugin, please create an issue on the plugin's GitHub repository.
