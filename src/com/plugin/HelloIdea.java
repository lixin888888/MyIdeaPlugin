package com.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.NotNull;


import java.awt.*;
import java.security.MessageDigest;

public class HelloIdea extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        Editor editor = anActionEvent.getData(PlatformDataKeys.EDITOR);
        if (editor == null) return;
        String selectedText = editor.getSelectionModel().getSelectedText();
        String translation = getTranslation(selectedText);
        showTip(translation,editor);
    }

    private void showTip(String translation, Editor editor) {
        ApplicationManager.getApplication().invokeLater(() -> JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(translation, Messages.getInformationIcon(),
                        new JBColor(new Color(214, 241, 255), new Color(0, 200, 250)), null)
                .setFadeoutTime(20000)
                .setHideOnAction(true)
                .createBalloon()
                .show(JBPopupFactory.getInstance()
                        .guessBestPopupLocation(editor), Balloon.Position.below));
    }


    private String getTranslation(String selectedText) {
        return "你好 世界";
    }
}
