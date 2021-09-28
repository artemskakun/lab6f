package com.labs.lab6.Server.Utils;

import com.labs.lab6.Server.Commands.*;
import com.labs.lab6.common.Data.StudyGroup;
import com.labs.lab6.common.Request;

public class CommandHandler {

    private final CommandInvoker commandInvoker;

    public CommandHandler(Repository repository) {

        HelpCommand helpCommand = new HelpCommand();
        SaveCommand saveCommand = new SaveCommand(repository);
        ContainsCommand containsCommand = new ContainsCommand(repository);
        ContainsKeyCommand containsKeyCommand = new ContainsKeyCommand(repository);

        helpCommand.addToBlockingList(saveCommand);
        helpCommand.addToBlockingList(containsCommand);
        helpCommand.addToBlockingList(containsKeyCommand);

        this.commandInvoker = new CommandInvoker(
                new InsertCommand(repository),
                new UpdateCommand(repository),
                new RemoveByKeyCommand(repository),
                new RemoveLowerKeyCommand(repository),
                new ClearCommand(repository),
                new InfoCommand(repository),
                new ShowCommand(repository),
                new RemoveLowerCommand(repository),
                new RemoveAnyBySemesterCommand(repository),
                new ReplaceIfGreaterCommand(repository),
                new PrintAscendingCommand(repository),
                new PrintDescendingCommand(repository),
                new ExecuteScriptCommand(),
                new ExitCommand(saveCommand),
                saveCommand,
                containsCommand,
                containsKeyCommand,
                helpCommand
        );
    }

    public void executeCommand(Request request) {
        String commandName = request.getCommandStruct().getCommand();
        String msg;

        switch (commandName) {
            case "init":
                RepliesSendler.sendReply(String.valueOf(StudyGroup.getCounter()));
                break;

            case "save":
                if (commandInvoker.save())
                    System.out.println("Repository saved");
                break;

            case "exit":
                if (commandInvoker.exit())
                    RepliesSendler.sendReply("Repository saved. Shutting-in client...");
                else {
                    RepliesSendler.sendReply("false");
                }
                break;

            case "contains":
                RepliesSendler.sendReply(Boolean.toString(commandInvoker.contains(request)));
                break;

            case "contains_key":
                RepliesSendler.sendReply(Boolean.toString(commandInvoker.containsKey(request)));
                break;

            case "insert":
                if (commandInvoker.insert(request))
                    RepliesSendler.sendReply("Item added");
                else
                    RepliesSendler.sendReply("Item overwritten");
                break;

            case "info":
                if (commandInvoker.info()) {
                    msg = commandInvoker.getInfoCommand().getLastData();
                    RepliesSendler.sendReply(msg);
                } else RepliesSendler.sendReply("Something wrong...");
                break;

            case "show":
                if (commandInvoker.show()) {
                    msg = commandInvoker.getShowCommand().getLastData();
                    RepliesSendler.sendReply(msg);
                } else RepliesSendler.sendReply("Repository is empty");
                break;

            case "help":
                if (commandInvoker.help()) {
                    msg = commandInvoker.getHelpCommand().getLastData();
                    RepliesSendler.sendReply(msg);
                } else RepliesSendler.sendReply("Something wrong...");
                break;

            case "clear":
                if (commandInvoker.clear())
                    RepliesSendler.sendReply("Repository is cleaned up");
                else
                    RepliesSendler.sendReply("Repository is empty");
                break;

            case "print_ascending":
                if (commandInvoker.printAscending()) {
                    msg = commandInvoker.getPrintAscending().getLastData();
                    RepliesSendler.sendReply(msg);
                } else RepliesSendler.sendReply("Repository is empty");
                break;

            case "print_descending":
                if (commandInvoker.printDescending()) {
                    msg = commandInvoker.getPrintDescending().getLastData();
                    RepliesSendler.sendReply(msg);
                } else RepliesSendler.sendReply("Repository is empty");
                break;

            case "remove_lower":
                if (commandInvoker.removeLower(request))
                    RepliesSendler.sendReply("Item removed");
                else
                    RepliesSendler.sendReply("There is no such elements");
                break;

            case "remove_lower_key":
                if (commandInvoker.removeLowerKey(request))
                    RepliesSendler.sendReply("Item removed");
                else
                    RepliesSendler.sendReply("There is no such elements");
                break;

            case "remove_any_by_semester":
                if (commandInvoker.removeAnyBySemester(request))
                    RepliesSendler.sendReply("Item removed");
                else
                    RepliesSendler.sendReply("There is no such elements");
                break;

            case "replace_if_greater":
                if (commandInvoker.replaceIfGreater(request))
                    RepliesSendler.sendReply("Item updated");
                else
                    RepliesSendler.sendReply("Element lower than given");
                break;

            case "update":
                if (commandInvoker.update(request))
                    RepliesSendler.sendReply("Item updated");
                else
                    RepliesSendler.sendReply("No element with this ID");
                break;

            case "remove_by_key":
                if (commandInvoker.removeByKey(request))
                    RepliesSendler.sendReply("Item removed");
                else
                    RepliesSendler.sendReply("No element with this key");
                break;

        }

    }
}
