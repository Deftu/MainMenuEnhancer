package xyz.deftu.mme

import gg.essential.universal.ChatColor
import gg.essential.vigilance.Vigilant
import gg.essential.vigilance.data.Property
import gg.essential.vigilance.data.PropertyType
import net.minecraft.launchwrapper.Launch
import java.io.File

private val configFile by lazy {
    val configDir = File(Launch.minecraftHome, "config")
    if (!configDir.exists() || configDir.mkdirs())
        throw IllegalStateException("Could not create config dir - This shouldn't happen...")
    File(configDir, "@MOD_ID@.toml")
}

object MainMenuEnhancerConfig : Vigilant(
    file = configFile,
    guiTitle = "${ChatColor.GOLD}@MOD_NAME@"
) {
    @Property(
        type = PropertyType.SWITCH,
        name = "Toggle",
        category = "General"
    ) @JvmStatic var toggle = true
    @Property(
        type = PropertyType.SWITCH,
        name = "Blur",
        category = "General"
    ) @JvmStatic var blur = true
    @Property(
        type = PropertyType.SWITCH,
        name = "Gradient",
        category = "General"
    ) @JvmStatic var gradient = true
}
