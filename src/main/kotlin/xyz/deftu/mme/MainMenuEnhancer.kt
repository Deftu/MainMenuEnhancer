package xyz.deftu.mme

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@Mod(
    name = MainMenuEnhancer.NAME,
    version = MainMenuEnhancer.VERSION,
    modid = MainMenuEnhancer.ID,
    acceptedMinecraftVersions = "[1.8.9]",
    clientSideOnly = true,
    modLanguageAdapter = "gg.essential.api.utils.KotlinAdapter"
) object MainMenuEnhancer {
    const val NAME = "@MOD_NAME@"
    const val VERSION = "@MOD_VERSION@"
    const val ID = "@MOD_ID@"

    @Mod.EventHandler
    fun initialize(event: FMLInitializationEvent) {
        MainMenuEnhancerConfig.initialize()
        MainMenuEnhancerCommand.register()
    }
}
