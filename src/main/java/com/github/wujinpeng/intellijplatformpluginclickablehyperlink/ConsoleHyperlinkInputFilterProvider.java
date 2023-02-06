package com.github.wujinpeng.intellijplatformpluginclickablehyperlink;

import com.intellij.execution.filters.ConsoleInputFilterProvider;
import com.intellij.execution.filters.InputFilter;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class ConsoleHyperlinkInputFilterProvider implements ConsoleInputFilterProvider {
    @Override
    public InputFilter @NotNull [] getDefaultFilters(@NotNull Project project) {
        return new InputFilter[]{ new ConsoleHyperlinkInputFilter() };
    }
}
