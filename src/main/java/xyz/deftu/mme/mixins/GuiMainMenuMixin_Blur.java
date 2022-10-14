package xyz.deftu.mme.mixins;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.deftu.mme.MainMenuEnhancerConfig;

@Mixin(value = GuiMainMenu.class)
public class GuiMainMenuMixin_Blur {
    @Inject(method = "rotateAndBlurSkybox", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;disableAlpha()V", shift = At.Shift.AFTER), cancellable = true)
    private void mme$cancelBlur(CallbackInfo ci) {
        if (MainMenuEnhancerConfig.getToggle() && !MainMenuEnhancerConfig.getBlur()) {
            ci.cancel();
            Tessellator.getInstance().draw();
            GlStateManager.enableAlpha();
            GlStateManager.colorMask(true, true, true, true);
        }
    }
}
