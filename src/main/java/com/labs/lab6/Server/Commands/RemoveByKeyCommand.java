package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

/**
 * Remove element of repository by ID
 */
public class RemoveByKeyCommand extends AbstractCommand {
    private final Repository repository;
    private StudyGroup studyGroup;

    public RemoveByKeyCommand(Repository repository) {
        super("remove_by_key key", "Remove element from repository by key");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {
        int key = Integer.parseInt(request.getCommandStruct().getArgument());
        return repository.get().remove(key) != null;
    }
}
