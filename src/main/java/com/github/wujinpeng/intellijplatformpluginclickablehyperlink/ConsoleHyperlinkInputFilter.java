package com.github.wujinpeng.intellijplatformpluginclickablehyperlink;

import com.intellij.execution.filters.InputFilter;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;

import static com.github.wujinpeng.intellijplatformpluginclickablehyperlink.ConsoleHyperlinkFilter.URL_PATTERN;

public class ConsoleHyperlinkInputFilter implements InputFilter {
    @Override
    public @Nullable List<Pair<String, ConsoleViewContentType>> applyFilter(@NotNull String text, @NotNull ConsoleViewContentType contentType) {
        Matcher matcher = URL_PATTERN.matcher(text);
        if (matcher.find()) {
            String url = matcher.group();
            String decodedUrl = URLDecoder.decode(url, StandardCharsets.UTF_8);

            return List.of(new Pair<>(text.replace(url, decodedUrl), contentType));
        }
        return null;
    }
}
