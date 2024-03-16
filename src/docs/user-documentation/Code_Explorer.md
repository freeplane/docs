
<!-- toc -->

# Freeplane Code Explorer Mode Documentation

## Introduction

The Code Explorer mode in Freeplane is designed for analyzing the structure and dependencies of code compiled to JVM class files.

![Code map](../images/codemap.png)

## Accessing Code Explorer Mode

1. Launch Freeplane version 1.11.12 or later.
2. Navigate to the menu bar at the top of the application.
3. Click on `Maps`.
4. Select `Modes`.
5. Choose `Code Explorer` to enter the code explorer mode.

## Video Tutorials

Video tutorials are available to help users familiarize themselves with the Code Explorer mode. To access the tutorial, navigate to the Help menu within Freeplane and select Help -> Code Explorer Introduction Video.

## Configurations Panel

### Configurations Tab

The Configurations tab allows users to manage their configurations and consists of three parts: configurations, locations, and rules.

#### Configurations

- **Add Configuration**: Click this button to create a new configuration.
- **Delete Configuration**: Use this button to remove the currently selected configuration.
- **Run Analysis**: Initiates the analysis process, loading and importing class files.
- **Apply Changes**: Attempts to apply only rule changes without reloading class files, if there are no location changes.
- **Cancel**: Allows users to cancel an analysis that has started but not yet finished.

#### Locations

- **Add JARs and Folders**: This button allows you to add new JAR files or folders to your configuration.
- **Remove Selected Locations**: This button will remove the currently selected locations from your configuration.
- **Ordering Buttons**: Adjust the priority order of locations, affecting which classes are imported when duplicates exist.

#### Rules

Rules in the Code Explorer mode are used to specify allowed and forbidden dependencies, among other settings. Rules are defined in the following formats:

```
[command] [originPattern] [direction] [targetPattern]
classpath [path]
ignore class [classPattern]
import interface [classPattern]
import annotation [classPattern].[methodName]()
group [classPattern]
group [classPattern] as [group name]
ignore group [classPattern]
```

- **Revert**: Undoes the last change made to the rule configuration.
- **Help**: Provides documentation related to creating and managing rules.

## Analysis Results

After running an analysis with the "Run Analysis" button, the result is represented as an interactive mind map that visualizes all packages and classes.

### Mind Map Structure

- **Packages and Classes**: Displayed in a hierarchical format, with packages expanding to reveal classes contained within them.
- **Dependencies**: Represented as connectors between nodes on the mind map.
- **Forbidden Dependencies**: Illustrated with red lines, these dependencies are configured in the rules to be disallowed.

### Dependencies Tab

![Dependencies](../images/dependencies.png)

The Dependencies tab dynamically updates with information as the selection within the mind map changes. It provides a detailed list of dependencies including verdict, origin, target, and the specific details about the nature of the dependency.

#### Filtering Dependencies

- The filter input field allows users to filter the list of dependencies by entering keywords or by specifying a column for searching using the format `column:keyword`.

## Special Filters and Exploration Tools

### Toolbar Filters

The toolbar provides a set of actions for quick application of special filters related to dependency analysis. They can be used in combinations with the general filter toolbar and filter menu.

### Explore Menu Options

The "Explore" menu encompasses all the actions available on the toolbar for filtering dependencies, as well as additional actions for more advanced analysis. 
