## AI integration troubleshooting

## Start here

If AI does not respond as expected, open AI Preferences (from the AI
panel burger menu) and check:

- the key for your provider (`AI OpenRouter key` or `AI Gemini key`),
- provider-specific options you use (for Ollama:
  `AI Ollama service address`, and if required
  `AI Ollama API key`),
- model selection,
- model parameters if you use them (`AI thinking effort`,
  `AI temperature`),
- `AI tool availability`.

For prompts, editor attachment, AI-owned script review, and formula
editing features, use Freeplane `1.13.3` or later.

## Benefits and risks

Benefits:

- this page helps you diagnose configuration and permission problems,
- it can help you avoid enabling stronger AI features by guesswork.

Risks:

- some fixes involve enabling stronger permissions,
- when a fix requires editing, formula authoring, script execution, or
  MCP, re-read the corresponding feature page before enabling it.

## Messages you may see

- `No AI provider is configured.`
  - Required provider settings are missing.
- `Missing AI model selection.`
  - No model is selected yet.
- `Missing OpenRouter key setting.`
  - OpenRouter is selected but the key is empty.
- `No AI provider is configured.`
  - For Ollama, ensure `AI Ollama service address` is set.
- Ollama model list/chat request fails with unauthorized or forbidden.
  - Check `AI Ollama API key` and verify it is valid for your endpoint.
- Ollama model list/chat request fails with connection errors.
  - Verify `AI Ollama service address` is reachable and correctly
    formatted, including protocol and port.
- `Unknown AI provider selection.`
  - Re-check provider settings in Preferences.

## Prompts and profiles

If you cannot find saved prompts or assistant profiles:

1. Open `Tools > Open user directory`.
2. Check these files:
   - `ai-prompts.json`
   - `ai-assistant-profiles.json`

If prompts do not behave like normal chat, that may be expected:

- prompts are separate from assistant profiles,
- shown prompts open their own chat,
- hidden prompts do not stay as visible saved chats,
- leading slash prompt references in normal chat substitute only the
  saved prompt text and ignore the prompt's saved visibility, model,
  thinking-effort, temperature, and tool settings.

## Formula editing is missing or not offered

If AI does not offer formula editing:

- check `AI tool availability`,
- enable `AI may edit formulas`.

Formula editing is gated separately from ordinary AI editing.

## AI-owned script review behaves differently than expected

If an AI-owned script waits for you instead of running immediately,
check `AI-owned script execution policy`.
For the full behavior and risk model, see
[AI-owned script execution](ai-owned-script-execution.md).

- `Shown, user must press Run`
  - opens the review dialog and waits for your decision.
- `Hidden, AI may run directly`
  - allows direct execution.

If you see a popup with a script result, that popup may have been
created by the script itself rather than by the AI-owned review dialog.
Prefer `return` or `println` in scripts when you do not want UI popups.

## Formula execution fails while editing

If formula execution fails with a message about blocked execute calls,
check the formula-plugin setting `Block formula map edits`.

When enabled, formulas that try to apply map edits during evaluation or
validation can fail by design.

This is especially relevant if a formula tries to create nodes or make
other map changes.

## Editor attachment and AI repair

If the `AI` button in `Formula Editor` or `Edit script` does not behave
as expected:

- check that you are using Freeplane `1.13.3` or later,
- check `Attached editor chat mode`,
- if formula or attached-script repair is offered after a failure,
  remember that the repair request is optional and starts only if you
  choose it.

## MCP not working

If another local AI app cannot use Freeplane through MCP:

- enable `AI MCP server enabled`,
- check `AI MCP server port`,
- check `MCP token`,
- ensure your client sends the token using one supported header:
  `Authorization: Bearer <MCP token>` (preferred) or
  `X-Freeplane-MCP-Token: <MCP token>` (legacy).
- if your client sends both headers, ensure both token values are
  identical.

If port is in use, choose another port and restart the server.

Important: if `MCP token` was empty, the first client request can fail
because Freeplane generates a token at that moment. Copy the generated
token and try again.

Also remember that some MCP-assisted editing features depend on the
current AI settings. If formula-related editing is missing, re-check
`AI tool availability` and `AI may edit formulas`.

## Scripts asking AI

If you are troubleshooting Groovy scripts that call AI, see
[Asking AI from scripts](../scripting/Asking_AI_from_scripts.md).

For asynchronous callbacks, `println` output is routed back to the
originating script output target when one exists. Non-editor script runs
without a durable output target do not create a new script editor window
only to display callback output.

## Quick success checklist

Use this after changes or upgrades:

- `Chats` dialog can `Delete` selected recent entries.
- profile-based workflows run consistently for branch text tasks.
- prompt runs work in the expected shown or hidden mode.
- note summarization works for long notes, including notes manually
  extracted from PDFs.
- decision drafting workflows are usable in daily map work.
- formula editing appears only when the relevant settings allow it.
