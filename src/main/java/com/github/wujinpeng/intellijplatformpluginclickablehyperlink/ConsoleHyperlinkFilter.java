package com.github.wujinpeng.intellijplatformpluginclickablehyperlink;

import com.intellij.execution.filters.Filter;
import com.intellij.ide.browsers.OpenUrlHyperlinkInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleHyperlinkFilter implements Filter {
    public static final Pattern URL_PATTERN = Pattern.compile("(?<=GET )https?://.+(?= 200 OK)");

    @Override
    public @Nullable Result applyFilter(@NotNull String line, int entireLength) {
        int startPoint = entireLength - line.length();
        Matcher matcher = URL_PATTERN.matcher(line);
        if (matcher.find()) {
            return new Result(startPoint + matcher.start(), startPoint + matcher.end(), new OpenUrlHyperlinkInfo(matcher.group()));
        }
        return null;
    }
}
