package xyz.deftu.mme.mixins;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import xyz.deftu.mme.MainMenuEnhancerConfig;

@Mixin(value = GuiMainMenu.class)
public class GuiMainMenuMixin_Gradient extends Gui {
    @Redirect(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiMainMenu;drawGradientRect(IIIIII)V", ordinal = 0))
    private void mme$maybeCancelGradientOne(GuiMainMenu instance, int left, int top, int width, int height, int startColor, int endColor) {
        maybeDrawGradient(left, top, width, height, startColor, endColor);
    }

    @Unique
    private void maybeDrawGradient(int left, int top, int width, int height, int startColor, int endColor) {
        if (!MainMenuEnhancerConfig.getToggle() || !MainMenuEnhancerConfig.getGradient())
            return;

        drawGradientRect(left, top, width, height, startColor, endColor);
    }
}
