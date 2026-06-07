# Preview: AI prompts, formulas, scripts, and MCP updates in Freeplane 1.13.3

We have a preview build of Freeplane `1.13.3` with a broader set of AI
features and updated documentation.

Highlights in this preview:

- reusable AI prompts and assistant profiles,
- prompt-specific optional model and tool settings,
- AI attachment for the Formula Editor and Script Editor,
- optional AI repair after formula execution failure,
- a separate `AI may edit formulas` permission,
- a separate explanation of AI-owned script execution and its risks,
- a clearer `AI-owned script execution policy`,
- improved MCP behavior and MCP visibility in AI chat,
- Groovy scripts that can ask AI asynchronously,
- the `Block formula map edits` safeguard.

The documentation now covers these areas in more detail, including the
permissions each feature needs and the risks and benefits of enabling
it.

Important risk notes:

- AI output can be wrong.
- Prompt injection through mind map content or scripts cannot be fully
  excluded.
- AI-generated formulas and especially AI-generated scripts should be
  reviewed carefully.
- Allowing AI to run scripts without user review is materially riskier
  than shown-mode review.
- Freeplane's MCP server listens only on `127.0.0.1` by default, so it
  is not remotely reachable by itself. It becomes externally reachable
  only if separate forwarding or proxy software exposes that local
  port.
- Even then, connected MCP clients may themselves send map content or
  results to external AI services.

If you test this preview, feedback on both usability and safety wording
would be especially useful.
