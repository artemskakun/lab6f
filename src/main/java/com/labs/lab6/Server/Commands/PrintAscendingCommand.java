package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintAscendingCommand extends AbstractCommand {
    private final Repository repository;
    private String lastData;

    public PrintAscendingCommand(Repository repository) {
        super("print_ascending", "Print elements of repository in ascending order");
        this.repository = repository;
    }

    public String getLastData() {
        return lastData;
    }

    @Override
    public boolean execute(Request o) {
        if (repository.get().isEmpty())
            return false;

        Map<Integer, StudyGroup> sortedRepository =
                repository.get().entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder builder = new StringBuilder();
        sortedRepository.forEach((key, value) -> builder.append(value.toString()));

        lastData = builder.toString();

        return true;
    }

}
