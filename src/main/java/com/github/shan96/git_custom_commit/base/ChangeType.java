package com.github.shan96.git_custom_commit.base;

public enum ChangeType {
  FE_P("FE - Planned", "A new feature from product roadmap"),
  FE_S("FE - Sponsored", "A new feature from sponsored development"),
  FE_G("FE - Gap", "A new feature identified from CI/Recon/IA as gap"),
  FIX_CI("Bug Fixes - CI", "A bug fix from CI"),
  FIX_R("Bug Fixes - Recon", "A bug fix from Recon"),
  DOCS("Documentation", "Documentation only changes"),
  STYLE(
      "Styles",
      "Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)"),
  REFACTOR("Code Refactoring", "A code change that neither fixes a bug nor adds a feature"),
  PERF("Performance Improvements", "A code change that improves performance"),
  TEST("Tests", "Adding missing tests (ATC / Unit) or correcting existing tests"),
  BUILD(
      "Builds",
      "Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)"),
  CI(
      "Continuous Integrations",
      "Changes to our CI configuration files and scripts (example scopes: Jenkins, Ant, YAML etc)"),
  CHORE("Chores", "Other changes that don't modify src or test files"),
  REVERT("Reverts", "Reverts a previous commit");

  public final String title;
  public final String description;

  ChangeType(String title, String description) {
    this.title = title;
    this.description = description;
  }

  public String label() {
    return this.name();
  }

  public String getDescription() {
    return this.description;
  }

  @Override
  public String toString() {
    return String.format("%s - %s", this.label(), this.description);
  }
}
