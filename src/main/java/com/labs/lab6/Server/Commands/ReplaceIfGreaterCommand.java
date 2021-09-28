package com.labs.lab6.Server.Commands;

import com.labs.lab6.Server.Utils.Repository;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

public class ReplaceIfGreaterCommand extends AbstractCommand {

    private final Repository repository;

    public ReplaceIfGreaterCommand(Repository repository) {
        super("replace_if_greater key {element}", "Replace element by key if it's greater than given");
        this.repository = repository;
    }

    @Override
    public boolean execute(Request request) {
        int key = Integer.parseInt(request.getCommandStruct().getArgument());
        StudyGroup newStudyGroup = (StudyGroup) request.getCommandArg();
        StudyGroup studyGroup = repository.get().get(key);

        if (studyGroup.compareTo(newStudyGroup) < 0) {
            newStudyGroup.setKey(studyGroup.getKey());
            newStudyGroup.setId(studyGroup.getId());
            repository.get().put(key, newStudyGroup);
            return true;
        }
        return false;
    }
}
