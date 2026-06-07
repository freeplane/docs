## AI chat workflows

This page focuses on practical ways to get useful results from AI in
everyday map work.

## Benefits and risks

Benefits:

- workflow patterns can make repeated map tasks faster and more
  consistent,
- profiles and prompts reduce repeated setup work.

Risks:

- AI suggestions can still be wrong,
- hidden prompt runs reduce visibility,
- tool-call summaries help review what happened, but they do not prove
  that the result is correct or safe.

## Use profiles and prompts for repeatable work

- Use `Manage profiles` when you want reusable chat behavior across many
  requests. Select the profile in the `AI profile` control before
  sending your request.
- Use prompts when you want saved actions you can launch directly from
  menus, for example to rewrite the selected node, summarize a branch,
  draft a decision, or run a hidden background request.
- Unlike normal chat, prompts do not use the current assistant profile,
  and hidden prompts can run without replacing the currently visible
  chat.

For details, see [AI prompts and profiles](ai-prompts-and-profiles.md).

## Workflow example: branch spelling correction

Goal: improve text quality while keeping original content visible.

One practical workflow:

1. Select a branch.
2. Ask AI to inspect spelling across selected nodes.
3. For nodes that need changes, create a child node with suggested
   corrected text.

This makes review easy because suggestions are separated from source
text.

## Workflow example: summarize extracted notes

Goal: turn long notes into short, useful summaries.

This also works for notes that were manually extracted from PDF
documents by the user.

1. Add or select nodes with note text.
2. Ask AI to summarize by section or action items.
3. Store concise summaries in nearby nodes.

## Workflow example: draft decisions

Goal: produce decision drafts from map context.

1. Provide context nodes (problem, options, constraints).
2. Request a structured decision draft.
3. Iterate with follow-up prompts to refine wording and scope.

## Visible tool-call summaries

If `AI chat shows tool calls` is enabled, Freeplane can show tool
activity in chat.

This can help when you want to understand:

- what the AI just inspected,
- which edit step happened,
- whether MCP-driven activity was surfaced into chat.

## Manage recent chat entries

Use `Chats` to manage recent conversations. From there you can:

- `Open` a selected chat.
- `Delete` selected chat or transcript entries.
- keep only active, relevant recent conversations.

## Turn navigation

Undo and redo are available in chat turn flow:

- `Undo` rewinds one sent turn and restores the user message to input.
- `Redo` reapplies a rewound turn.

Keyboard shortcuts:

- `Command/Ctrl + ArrowUp` for Undo.
- `Command/Ctrl + ArrowDown` for Redo.
