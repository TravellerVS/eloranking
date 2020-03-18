package com.vedransemenski.eloranking.cli;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

@Service
public class ArgsParser {

    public static final int MATCHER_FILE_PATH_INDEX = 0;
    public static final int NAMES_FILE_PATH_INDEX = 1;
    public static final int COMMAND_INDEX = 3;
    public static final int ADDITIONAL_PARAMETERS_INDEX = 4;
    private static final int OUTPUT_FILE_PATH_INDEX = 2;

    public static FilePaths extractInputFilePaths(String[] args) {
        validateArgsContainFilePaths(args);
        return new FilePaths()
                .withMatchesFilePath(args[MATCHER_FILE_PATH_INDEX])
                .withNamesFilePath(args[NAMES_FILE_PATH_INDEX]);
    }

    public static void validateArgsContainFilePaths(String[] args) {
        validateMinLength(args, 2, "No filePaths arguments found in provided arguments.");
        validateArgumentsNotNull(args);
    }

    public static CommandLineCommand extractCommand(String[] args) {
        validateArgsContainCommand(args);
        List<String> commandList = Arrays.asList(args);
        CommandLineCommand commandLineCommand = new CommandLineCommand()
                .withCommand(commandList.get(COMMAND_INDEX))
                .withOutputFile(commandList.get(OUTPUT_FILE_PATH_INDEX));
        if (commandList.size() >= ADDITIONAL_PARAMETERS_INDEX) {
            commandLineCommand.setAdditionalParameters(commandList.subList(ADDITIONAL_PARAMETERS_INDEX, commandList.size()));
        }
        return commandLineCommand;
    }

    public static void validateArgsContainCommand(String[] args) {
        validateMinLength(args, 4, "No command arguments found in provided arguments.");
        validateArgumentsNotNull(args);
    }

    private static void validateMinLength(String[] args, int minArguments, String errorMessage) {
        if (args == null || args.length < minArguments) {
            throw new CliArgumentsException(String.format("%s ArgsProvided: %s", errorMessage, Arrays.toString(args)));
        }
    }

    private static void validateArgumentsNotNull(String[] args) {
        for (String argument : args) {
            if (StringUtils.isEmpty(argument)) {
                throw new CliArgumentsException(String.format("None of the arguments provided should be null or empty. ArgsProvided: %s", Arrays.toString(args)));
            }
        }
    }
}
