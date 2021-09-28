package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Request;

/**
 * Show information about elements of repository
 */
public class ShowCommand extends AbstractCommand {
    private final Repository repository;
    private String lastData;

    public ShowCommand(Repository repository) {
        super("show", "Show information about elements of repository");
        this.repository = repository;
    }

    public String getLastData() {
        return lastData;
    }

    @Override
    public boolean execute(Request request) {  // response equals null by default
        StringBuilder description = new StringBuilder();

        if (repository.get().isEmpty())
            return false;

        repository.get().forEach((key, value) -> description.append(value.toString()));
        lastData = description.toString();

        return true;
    }
}
