package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.util.ExceptionMessage;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static Line findLineBy(String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NO_SUCH_LINE_NAME.getMessage()));
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
