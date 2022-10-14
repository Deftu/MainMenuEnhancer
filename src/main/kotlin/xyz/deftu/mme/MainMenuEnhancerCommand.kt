package xyz.deftu.mme

import gg.essential.api.EssentialAPI
import gg.essential.api.commands.Command
import gg.essential.api.commands.DefaultHandler

object MainMenuEnhancerCommand : Command(MainMenuEnhancer.ID) {
    @DefaultHandler
    fun execute() {
        EssentialAPI.getGuiUtil().openScreen(MainMenuEnhancerConfig.gui())
    }
}
