## AI chat workflows

This page focuses on practical ways to get useful results from AI in
everyday map work.

### Build repeatable behavior with profiles

Use `Manage profiles` to save reusable instructions.
A profile helps you get consistent results without rewriting the same
guidance each time.

A profile can define:

- role and point of view (for example reviewer, analyst, coach),
- output language and tone,
- formatting and structure expectations,
- task-specific rules and decision criteria,
- map interaction preferences (for example how to propose edits,
  where to place results, how to summarize branches).

Profiles guide behavior through instructions.
They do not change tool availability per profile.

Typical setup:

1. Open `Manage profiles`.
2. Create or edit a profile prompt.
3. Select that profile in the `AI profile` control.
4. Send your task request.

### Workflow example: branch spelling correction

Goal: improve text quality while keeping original content visible.

One practical workflow:

1. Select a branch.
2. Ask AI to inspect spelling across selected nodes.
3. For nodes that need changes, create a child node with suggested
   corrected text.

This makes review easy because suggestions are separated from source
text.

### Workflow example: summarize extracted notes

Goal: turn long notes into short, useful summaries.

This also works for notes that were manually extracted from PDF
documents by the user.

1. Add or select nodes with note text.
2. Ask AI to summarize by section or action items.
3. Store concise summaries in nearby nodes.

### Workflow example: draft decisions

Goal: produce decision drafts from map context.

1. Provide context nodes (problem, options, constraints).
2. Request a structured decision draft.
3. Iterate with follow-up prompts to refine wording and scope.

### Manage recent chat entries

Use `Chats` to manage recent conversations. From there you can:

- `Open` a selected chat.
- `Delete` selected chat or transcript entries.
- keep only active, relevant recent conversations.

### Turn navigation

Undo and redo are available in chat turn flow:

- `Undo` rewinds one sent turn and restores the user message to input.
- `Redo` reapplies a rewound turn.

Keyboard shortcuts:

- `Command/Ctrl + ArrowUp` for Undo.
- `Command/Ctrl + ArrowDown` for Redo.
