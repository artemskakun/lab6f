package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

/**
 * Add new space marine to repository
 */
public class InsertCommand extends AbstractCommand {
    private final Repository repository;
    private StudyGroup studyGroup;

    public InsertCommand(Repository repository) {
        super("insert key {element}", "Insert new element to repository");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {  // Object o equals null by default
        int key = Integer.parseInt(request.getCommandStruct().getArgument());
        studyGroup = (StudyGroup) request.getCommandArg();
        return repository.get().put(key, studyGroup) == null;
    }
}
