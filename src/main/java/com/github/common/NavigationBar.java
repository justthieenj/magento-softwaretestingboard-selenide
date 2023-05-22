package com.github.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NavigationBar {
    CODE("Code", 0, "code"),
    ISSUES("Issues", 1, ""),
    PULL_REQUESTS("Pull requests", 2, ""),
    ACTIONS("Actions", 3, "play"),
    PROJECTS("Projects", 4, ""),
    WIKI("Wiki", 5, ""),
    SECURITY("Security", 6, ""),
    INSIGHT("Insight", 7, ""),
    SETTINGS("Settings", 8, "gear");

    private final String value;
    private final int index;
    private final String icon;
}
