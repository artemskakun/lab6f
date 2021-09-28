package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Print elements of repository in descending order
 */
public class PrintDescendingCommand extends AbstractCommand {
    private final Repository repository;
    private String lastData;

    public PrintDescendingCommand(Repository repository) {
        super("print_descending", "Print elements of repository in descending order");
        this.repository = repository;
    }

    public String getLastData() {
        return lastData;
    }

    @Override
    public boolean execute(Request request) {  // response equals null by default
        if (repository.get().isEmpty())
            return false;

        Map<Integer, StudyGroup> sortedRepository =
                repository.get().entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder builder = new StringBuilder();
        sortedRepository.forEach((key, value) -> builder.append(value.toString()));

        lastData = builder.toString();

        return true;
    }
}
