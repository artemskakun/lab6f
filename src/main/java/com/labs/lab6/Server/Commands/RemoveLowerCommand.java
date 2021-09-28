package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

/**
 * Remove all elements with less health than given
 */
public class RemoveLowerCommand extends AbstractCommand {
    Repository repository;

    public RemoveLowerCommand(Repository repository) {
        super("remove_lower {element}", "Remove all elements lower than given");
        this.repository = repository;

    }

    @Override
    public boolean execute(Request request) {
        StudyGroup studyGroup = (StudyGroup) request.getCommandArg();
        return repository.get().entrySet().removeIf(
                entries -> entries.getValue().compareTo(studyGroup) < 0);
    }
}
