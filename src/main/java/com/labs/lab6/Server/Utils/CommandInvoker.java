package com.labs.lab6.Server.Utils;

import com.labs.lab6.Server.Commands.*;
import com.labs.lab6.common.Request;

/**
 * Class calls execute methods on command objects
 */
public class CommandInvoker {

    private final Command insertCommand;
    private final Command updateCommand;
    private final Command removeByKeyCommand;
    private final Command removeLowerKeyCommand;
    private final Command clearCommand;
    private final Command infoCommand;
    private final Command showCommand;
    private final Command removeLowerCommand;
    private final Command removeAnyBySemesterCommand;
    private final Command replaceIfGreaterCommand;
    private final Command printAscendingCommand;
    private final Command printDescendingCommand;
    private final Command executeScript;
    private final Command saveCommand;
    private final Command exitCommand;
    private final Command containsCommand;
    private final Command containsKeyCommand;
    private final Command helpCommand;


    public RemoveAnyBySemesterCommand getRemoveAnyBySemesterCommand() {
        return (RemoveAnyBySemesterCommand) removeAnyBySemesterCommand;
    }

    public UpdateCommand getUpdateCommand() {
        return (UpdateCommand) updateCommand;
    }

    public RemoveLowerKeyCommand getRemoveLowerKeyCommand() {
        return (RemoveLowerKeyCommand) removeLowerKeyCommand;
    }

    public ClearCommand getClearCommand() {
        return (ClearCommand) clearCommand;
    }

    public InfoCommand getInfoCommand() {
        return (InfoCommand) infoCommand;
    }

    public ShowCommand getShowCommand() {
        return (ShowCommand) showCommand;
    }

    public RemoveByKeyCommand getRemoveByKeyCommand() {
        return (RemoveByKeyCommand) removeByKeyCommand;
    }

    public PrintAscendingCommand getPrintAscending() {
        return (PrintAscendingCommand) printAscendingCommand;
    }

    public RemoveLowerCommand getRemoveLower() {
        return (RemoveLowerCommand) removeLowerCommand;
    }

    public PrintDescendingCommand getPrintDescending() {
        return (PrintDescendingCommand) printDescendingCommand;
    }

    public ExecuteScriptCommand getExecuteScript() {
        return (ExecuteScriptCommand) executeScript;
    }

    public SaveCommand getSaveCommand() {
        return (SaveCommand) saveCommand;
    }

    public ContainsCommand getContainsCommand() {
        return (ContainsCommand) containsCommand;
    }

    public ExitCommand getExitCommand() {
        return (ExitCommand) exitCommand;
    }

    public HelpCommand getHelpCommand() {
        return (HelpCommand) helpCommand;
    }

    public CommandInvoker(Command insertCommand, Command updateCommand, Command removeByKeyCommand, Command removeLowerKeyCommand,
                          Command clearCommand, Command infoCommand, Command showCommand, Command removeLowerCommand,
                          Command removeAnyBySemesterCommand, Command replaceIfGreaterCommand, Command printAscending,
                          Command printDescending, Command executeScript, Command exitCommand, Command saveCommand,
                          Command containsCommand, Command containsKeyCommand, Command helpCommand) {

        this.insertCommand = insertCommand;
        this.updateCommand = updateCommand;
        this.removeByKeyCommand = removeByKeyCommand;
        this.removeLowerKeyCommand = removeLowerKeyCommand;
        this.clearCommand = clearCommand;
        this.infoCommand = infoCommand;
        this.showCommand = showCommand;
        this.removeLowerCommand = removeLowerCommand;
        this.removeAnyBySemesterCommand = removeAnyBySemesterCommand;
        this.replaceIfGreaterCommand = replaceIfGreaterCommand;
        this.printAscendingCommand = printAscending;
        this.printDescendingCommand = printDescending;
        this.executeScript = executeScript;
        this.saveCommand = saveCommand;
        this.exitCommand = exitCommand;
        this.containsCommand = containsCommand;
        this.containsKeyCommand = containsKeyCommand;
        this.helpCommand = helpCommand;
    }


    public boolean insert(Request o) {
        return insertCommand.execute(o);
    }

    public boolean update(Request o) {
        return updateCommand.execute(o);
    }

    public boolean removeByKey(Request o) {
        return removeByKeyCommand.execute(o);
    }

    public boolean removeLowerKey(Request o) {
        return removeLowerKeyCommand.execute(o);
    }

    public boolean clear() {
        return clearCommand.execute(null);
    }

    public boolean info() {
        return infoCommand.execute(null);
    }

    public boolean show() {
        return showCommand.execute(null);
    }

    public boolean removeLower(Request o) {
        return removeLowerCommand.execute(o);
    }

    public boolean removeAnyBySemester(Request o) {
        return removeAnyBySemesterCommand.execute(o);
    }

    public boolean replaceIfGreater(Request o) {
        return replaceIfGreaterCommand.execute(o);
    }

    public boolean printDescending() {
        return printDescendingCommand.execute(null);
    }

    public boolean printAscending() {
        return printAscendingCommand.execute(null);
    }

    public boolean executeScript() {
        return executeScript.execute(null);
    }

    public boolean save() {
        return saveCommand.execute(null);
    }

    public boolean exit() {
        return exitCommand.execute(null);
    }

    public boolean contains(Request o) {
        return containsCommand.execute(o);
    }

    public boolean containsKey(Request o) {
        return containsKeyCommand.execute(o);
    }

    public boolean help() {
        return helpCommand.execute(new Request(null, this));
    }
}
