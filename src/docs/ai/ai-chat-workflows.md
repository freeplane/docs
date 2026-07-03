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

- Use `Edit profiles...` when you want reusable chat behavior across
  many requests. Select the profile in the `AI profile` control before
  sending your request.
- Use prompts when you want saved actions you can launch directly from
  menus, for example to rewrite the selected node, summarize a branch,
  draft a decision, or run a hidden background request.
- Unlike normal chat, prompts do not use the current assistant profile,
  and hidden prompts can run without replacing the currently visible
  chat.

For details, see [AI prompts and profiles](ai-prompts-and-profiles.md).

## Reuse prompts inside normal chat

To reuse a saved prompt without launching it from a menu, start the chat
input with `/` and the prompt name.

Example:

```text
/Summarize branch for release notes
```

If the leading `/Summarize branch` text matches a saved prompt,
Freeplane keeps that prompt reference visible in the chat but sends the
saved prompt text to the model, followed by the remaining text. If no
saved prompt matches, the message is sent as ordinary chat text.

Prompt references use only the saved prompt text. They do not apply the
prompt's saved visibility, model, temperature, thinking-effort, or tool
settings.

## Choose model parameters for interactive chat

The AI panel top bar contains the model selector and the thinking-effort
selector. The panel menu contains the `Temperature` submenu.

- Model selection chooses the provider/model used for ordinary chat.
- Thinking effort uses Freeplane's provider-independent levels: `Max`,
  `Extra high`, `High`, `Medium`, `Low`, `Minimal`, and `None`.
- Temperature can be `Model default`, one of the numeric presets, or a
  custom numeric value.

Providers and models do not all support the same thinking controls. When
needed, Freeplane maps the selected thinking effort to the closest
available provider behavior, or the provider may ignore it.

## Review chat instructions

The AI chat options menu has two independent instruction controls:

- `Show instruction history` shows the committed system and profile
  instruction blocks stored with the chat. This is useful when you want
  to inspect which instructions were active for earlier visible chat
  requests.
- `Preview next request instructions` shows a non-persistent preview of
  the system and profile instructions that would be used by the next
  visible request.

The preview appears below the `AI profile` selector and above the input
area. It updates when relevant request inputs change, for example the
selected profile, tool availability, system instruction state, or a
leading slash prompt reference in the input.

The preview is not part of the chat transcript. It is not copied with
chat history, saved as a committed chat message, counted as a chat turn,
or sent as a separate user message. It is a display of the next request's
instruction state.

If the selected profile differs from the profile currently active in the
chat, the preview applies that pending profile change first. The preview
then shows the composed system instruction followed by the effective
profile instruction. If the draft starts with a resolved slash prompt
reference, the preview also includes the saved prompt text that would be
substituted into the request.

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
