package ol.ui.dialogs;

import arc.Core;
import arc.scene.actions.Actions;
import arc.scene.ui.Dialog;
import arc.scene.ui.TextButton;
import arc.util.Align;
import mindustry.ui.dialogs.BaseDialog;

import static arc.Core.settings;

public class OlDisclaimer extends BaseDialog {
    public OlDisclaimer(){
        super("@mod.ol.disclaimer.title");
        cont.add("@mod.ol.disclaimer.text").width(500f).wrap().pad(4f).get().setAlignment(Align.center, Align.center);
        buttons.defaults().size(200f, 54f).pad(2f);
        setFillParent(false);

        TextButton b = buttons.button("@mod.ol.ok", this::hide).get();

        if(shouldSkip()) return;

        b.setDisabled(() -> b.color.a < 1);
        b.actions(
                Actions.alpha(0), Actions.moveBy(0f, 0f),
                Actions.delay(1.5f),
                Actions.fadeIn(1f),
                Actions.delay(1f)
        );
        b.getStyle().disabledFontColor = b.getStyle().fontColor;
        b.getStyle().disabled = b.getStyle().up;

        TextButton s = buttons.button("@mod.ol.doNotShowItAgain", () -> {
            hide();
            settings.put("mod.ol.show", true);
        }).get();

        s.setDisabled(() -> s.color.a < 1);
        s.actions(
                Actions.alpha(0), Actions.moveBy(0f, 0f),
                Actions.delay(1.5f),
                Actions.fadeIn(1f),
                Actions.delay(1f)
        );
        s.getStyle().disabledFontColor = b.getStyle().fontColor;
        s.getStyle().disabled = s.getStyle().up;
    }
    boolean shouldSkip(){
        return Core.settings.getBool("mod.ol.show", false);
    }
}