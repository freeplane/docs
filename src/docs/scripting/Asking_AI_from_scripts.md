<!-- toc -->

# Asking AI from scripts

The AI scripting API described on this page is available in Freeplane
`1.13.3` and later.

This page is for script authors who want Groovy scripts to send AI
requests asynchronously and handle the result in a callback.

## Benefits and risks

Benefits:

- scripts can reuse AI and saved prompts without blocking the UI,
- callbacks, cancellation, and explicit model configuration/tool
  settings give script authors control over the request flow.

Risks:

- AI output must be treated as untrusted input,
- hidden request modes reduce visibility,
- scripts that act on AI output or generated code can become dangerous.

## What scripts can do

From Groovy scripts you can:

- send raw prompt text to AI,
- run a saved AI prompt by name,
- choose whether the request starts a new visible chat, appends to the
  current visible chat, or runs hidden,
- choose current or explicit model configuration and tool settings,
- provide request-scoped system and profile messages,
- cancel a running request,
- receive the terminal result in a callback.

The main entry points are:

- `c.askAi(...)`
- `c.runAiPrompt(...)`

## Raw prompt requests

Use `c.askAi(...)` when the script provides the prompt text directly.

```groovy
import java.time.Duration
import org.freeplane.api.ai.AiRequestMode
import org.freeplane.api.ai.AiRequestOptions

c.askAi(
    "Summarize the selected node in 3 bullet points.",
    AiRequestOptions.builder()
        .timeout(Duration.ofSeconds(30))
        .mode(AiRequestMode.HIDDEN_WITH_CANCEL_DIALOG)
        .build()
) { result ->
    println "Status: ${result.status}"
    if (result.response) {
        println result.response
    }
    if (result.detail) {
        println "Detail: ${result.detail}"
    }
}
```

For `c.askAi(...)`, `timeout` is required and `mode` must be set.

## Running a saved AI prompt

Use `c.runAiPrompt(...)` when the script should run one of the prompts
managed in the regular prompt UI.

```groovy
import java.time.Duration

c.runAiPrompt("Summarize branch", Duration.ofSeconds(30)) { result ->
    println "Status: ${result.status}"
    if (result.response) {
        println result.response
    }
}
```

The `Duration` overload uses the saved prompt's default visibility,
model configuration, and tool settings.

You can also override those defaults with `AiRequestOptions`.

## Request modes

The available request modes are:

- `SHOW_IN_NEW_CHAT`
  - always opens a new visible AI chat for the request.
- `ADD_TO_CHAT`
  - sends into the current visible chat when one exists,
    otherwise creates a new visible chat.
- `HIDDEN_WITH_CANCEL_DIALOG`
  - runs without opening a visible chat but shows the progress/cancel
    dialog.
- `HIDDEN`
  - runs hidden without that dialog.

Example with a visible chat launch:

```groovy
import java.time.Duration
import org.freeplane.api.ai.AiRequestMode
import org.freeplane.api.ai.AiRequestOptions
import org.freeplane.api.ai.AiToolAvailability

c.askAi(
    "Rewrite the selected node for clarity.",
    AiRequestOptions.builder()
        .timeout(Duration.ofSeconds(30))
        .mode(AiRequestMode.SHOW_IN_NEW_CHAT)
        .toolAvailability(AiToolAvailability.EDITING)
        .build()
) { result ->
    println result.status
}
```

## Model configuration and tool selection

`AiRequestOptions` can request:

- inherited/current model configuration,
- an explicit provider/model,
- an explicit default model for a saved-prompt request,
- provider-independent thinking effort,
- temperature,
- current tools or an explicit tool level.

Tool levels are:

- `CURRENT`
- `DISABLED`
- `READING`
- `EDITING`
- `SCRIPT_EXECUTION`

Thinking-effort values are:

- `MAX`
- `XHIGH`
- `HIGH`
- `MEDIUM`
- `LOW`
- `MINIMAL`
- `NONE`

For temperature:

- leaving the field unset inherits the surrounding configuration,
- `AiTemperature.modelDefault()` explicitly asks the selected model to
  use its own default temperature,
- `AiTemperature.of(value)` sends a numeric temperature value.

For `askAi(...)`, unset model-configuration fields inherit the current
model defaults. For `runAiPrompt(...)`, unset fields inherit the saved
prompt configuration where that prompt has a value.

Explicit model-configuration example:

```groovy
import java.time.Duration
import org.freeplane.api.ai.AiModelConfiguration
import org.freeplane.api.ai.AiModelSelection
import org.freeplane.api.ai.AiRequestMode
import org.freeplane.api.ai.AiRequestOptions
import org.freeplane.api.ai.AiTemperature
import org.freeplane.api.ai.AiThinkingEffort

c.askAi(
    "Draft a short decision note from the selected branch.",
    AiRequestOptions.builder()
        .timeout(Duration.ofSeconds(45))
        .mode(AiRequestMode.SHOW_IN_NEW_CHAT)
        .modelConfiguration(
            AiModelConfiguration.builder()
                .modelSelection(AiModelSelection.explicit("gemini", "gemini-2.5-flash"))
                .thinkingEffort(AiThinkingEffort.LOW)
                .temperature(AiTemperature.modelDefault())
                .build())
        .build()
) { result ->
    println result.status
}
```

## Request-scoped system and profile messages

`AiRequestOptions` can provide instruction text for a single request:

- `systemMessage(text)` sets the request's base system instruction text.
- `exactSystemMessage(text)` sets the complete system instruction text
  for the request and suppresses Freeplane-composed system additions.
- `profile(name)` resolves a saved assistant profile by name.
- `profile(name, message)` uses the given profile message text directly.

Example:

```groovy
import java.time.Duration
import org.freeplane.api.ai.AiRequestMode
import org.freeplane.api.ai.AiRequestOptions
import org.freeplane.api.ai.AiToolAvailability

c.askAi(
    "Review the selected branch and list risks.",
    AiRequestOptions.builder()
        .timeout(Duration.ofSeconds(60))
        .mode(AiRequestMode.ADD_TO_CHAT)
        .toolAvailability(AiToolAvailability.READING)
        .systemMessage("Use risk-review terminology. Be concise.")
        .profile("Careful reviewer", """Now you have the profile Careful reviewer.
Profile definition: Check claims conservatively and say when evidence is missing.""")
        .build()
) { result ->
    println result.status
}
```

The system message supplied by a script is base instruction text. It
does not disable Freeplane's own request guidance. Freeplane still adds
applicable guidance for tool use, visible versus hidden execution, code
or formula editing state, and profile-control behavior.

For visible chats, Freeplane stores the base system message with the
chat and stores profile message snapshots as profile events. If
`ADD_TO_CHAT` is used with a request system message that differs from
the current visible chat's captured base system message, Freeplane starts
a new visible chat instead of mixing incompatible system instructions.

Hidden requests also use the request system text as base text and still
receive applicable Freeplane guidance. They do not add a visible chat
history entry, and hidden requests omit visible-chat Markdown response
guidance.

Use `exactSystemMessage(text)` only when the script supplies the whole
system instruction itself. Exact system text is trimmed and sent without
Freeplane-composed additions such as tool-use guidance, map-selection
guidance, profile-control guidance, Markdown guidance, or code-host
guidance. Tool exposure is still controlled by `AiToolAvailability`.

## Selection override

Advanced scripts can override the selection structure injected into the
first AI prompt message.

This uses `AiSelectionOverride`. It changes the prepared prompt context
for that request, but it does **not** replace later live tool results.
Those still reflect the real current state.

## Callback results

Accepted requests finish through the callback with an `AiRequestResult`.
The callback runs asynchronously on Freeplane's main/UI thread.

If a callback uses `println`, Freeplane routes that output back to the
originating script output target when such a target exists. For an
attached script-editor run, that target is the script editor output
window. For other script runs, it is the run's output stream when one is
available. Freeplane does not create a script editor window only to show
callback output.

Useful fields:

- `result.status`
- `result.response`
- `result.detail`

`response` is typically the assistant text for successful requests.
`detail` is mainly useful for failures.

Common statuses:

- `SUCCEEDED`
- `CANCELLED`
- `TIMED_OUT`
- `CONFIGURATION_ERROR`
- `AUTHENTICATION_ERROR`
- `MODEL_UNAVAILABLE`
- `PROVIDER_ERROR`
- `PERMISSION_DENIED`
- `REJECTED_BUSY`
- `PROMPT_NOT_FOUND`
- `FAILED`

## Non-blocking handle

Each accepted request returns an `AiRequestHandle`.

It can be used to:

- `cancel()` a running request,
- check `isDone()`,
- check `isCancelled()`,
- inspect `getStatus()`.

Example:

```groovy
import java.time.Duration
import org.freeplane.api.ai.AiRequestMode
import org.freeplane.api.ai.AiRequestOptions


def handle = c.askAi(
    "List the main risks in the selected branch.",
    AiRequestOptions.builder()
        .timeout(Duration.ofSeconds(60))
        .mode(AiRequestMode.HIDDEN)
        .build()
) { result ->
    println result.status
}

// later, if needed
// handle.cancel()
```

## Rejections before a request starts

Some failures happen before the request is accepted.
Those are reported immediately by throwing
`AiRequestRejectedException` instead of going through the callback.

Examples include:

- missing saved prompt name,
- permission denial,
- invalid request arguments.

## Relationship to regular AI prompts

Scripts can reuse the same saved prompts that users manage in the AI
prompt UI.

This is useful when you want:

- users to refine a prompt in the UI,
- scripts to launch the same prompt automatically,
- one place to control the saved prompt text and its defaults.

For end-user prompt management, see
[AI prompts and profiles](../ai/ai-prompts-and-profiles.md).
