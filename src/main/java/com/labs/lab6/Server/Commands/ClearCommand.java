package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Request;

/**
 * Clear repository
 */
public class ClearCommand extends AbstractCommand {
    Repository repository;

    public ClearCommand(Repository repository) {
        super("clear", "Clear repository");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {   // response equals null by default
        if (repository.get().isEmpty())
            return false;
        repository.get().clear();
        return true;
    }
}
