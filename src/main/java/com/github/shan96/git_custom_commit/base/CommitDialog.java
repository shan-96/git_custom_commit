package com.github.shan96.git_custom_commit.base;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import javax.swing.*;
import org.jetbrains.annotations.Nullable;

public class CommitDialog extends DialogWrapper {

  private final CommitPanel panel;

  CommitDialog(@Nullable Project project) {
    super(project);
    panel = new CommitPanel(project);
    super.setTitle("Commit");
    setOKButtonText("OK");
    super.init();
  }

  @Nullable
  @Override
  protected JComponent createCenterPanel() {
    return panel.getMainPanel();
  }

  CommitMessage getCommitMessage() {
    return panel.getCommitMessage();
  }
}
