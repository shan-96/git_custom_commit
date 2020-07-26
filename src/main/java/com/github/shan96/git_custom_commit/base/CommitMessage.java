package com.github.shan96.git_custom_commit.base;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import org.apache.commons.lang.WordUtils;

class CommitMessage {
  private static final int MAX_LINE_LENGTH = 72; // https://stackoverflow.com/a/2120040/5138796
  private final String content;

  CommitMessage(
      ChangeType changeType,
      String changeScope,
      String shortDescription,
      String longDescription,
      String closedIssues,
      String breakingChanges) {
    this.content =
        buildContent(
            changeType,
            changeScope,
            shortDescription,
            longDescription,
            closedIssues,
            breakingChanges);
  }

  private static String buildContent(
      ChangeType changeType,
      String changeScope,
      String shortDescription,
      String longDescription,
      String closedIssues,
      String breakingChanges) {
    StringBuilder builder = new StringBuilder();
    if (isNotBlank(closedIssues)) {
      for (String closedIssue : closedIssues.split(",")) {
        builder.append(System.lineSeparator()).append("JIRA: ").append(closedIssue);
      }
      builder.append(System.lineSeparator());
    }
    builder
        .append(changeType.label())
        .append('(')
        .append(changeType.getDescription())
        .append("): ")
        .append(System.lineSeparator());
    builder
        .append(": ")
        .append(shortDescription)
        .append(System.lineSeparator())
        .append(WordUtils.wrap(longDescription, MAX_LINE_LENGTH));

    if (isNotBlank(changeScope)) {
      builder
          .append(System.lineSeparator())
          .append("Affected Fields: (")
          .append(changeScope)
          .append(')');
    }

    if (isNotBlank(breakingChanges)) {
      builder
          .append(System.lineSeparator())
          .append(WordUtils.wrap("DoD Followed: " + breakingChanges, MAX_LINE_LENGTH));
    }

    return builder.toString();
  }

  @Override
  public String toString() {
    return content;
  }
}
