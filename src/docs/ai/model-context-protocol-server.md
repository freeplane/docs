## Model Context Protocol server

This page describes the current MCP behavior in Freeplane `1.13.3` and
later.

Use this feature when you want another local AI app to work with your
Freeplane maps.

Typical example:
- You use Claude Desktop or Codex App and want it to read or modify
  map content through Freeplane.

By default, this feature is disabled. Enable it only when you need it.

## Benefits and risks

Benefits:

- another local AI app can work with your Freeplane maps,
- Freeplane still remains the place where map actions actually happen.

Risks:

- any local software that can reach the local port and has the token can
  try to call the server,
- an MCP client may itself send map content or results to external AI
  services,
- model mistakes and prompt injection through map content or scripts
  still cannot be fully excluded.

### Why you would enable it

- To use Freeplane from another local AI tool.
- To keep Freeplane as the place where map actions actually happen.
- To switch it off when not needed.

### Where to enable it

Open AI Preferences (from the AI panel burger menu), then use:

- `AI MCP server enabled`
- `AI MCP server port`
- `MCP token`

### Quick setup

1. Enable `AI MCP server enabled`.
2. Set `AI MCP server port` (default is `6298`).
3. Set or regenerate `MCP token`.
4. In your local AI app (for example Claude Desktop or Codex App),
   connect to the Freeplane MCP server using that port and token.
   Supported authentication headers are:
   - `Authorization: Bearer <MCP token>` (preferred)
   - `X-Freeplane-MCP-Token: <MCP token>` (legacy, still supported)

If your client sends both headers, they must contain the same token
value.

If `MCP token` is empty, Freeplane generates a new token on the first
incoming client request. That first request is rejected by design. Copy
the generated token and retry from your client.

### MCP behavior and AI settings

Some MCP-assisted editing features depend on the current AI settings.
This is especially important for features that go beyond simple reading,
for example formula-related editing.

If you expect an MCP client to perform AI-assisted editing, check the
same relevant settings you would check for internal AI use, including:

- `AI tool availability`
- `AI may edit formulas`

### MCP activity in AI chat

If `AI chat shows tool calls` is enabled, MCP activity can also be
surfaced in the AI chat UI.

This makes it easier to review what happened, even when the action was
started from another local AI app.

### Safety notes

- Freeplane listens on `127.0.0.1` only. It is not remotely reachable
  by default.
- It becomes externally reachable only if separate forwarding or proxy
  software exposes that local port.
- Keep the token secret.
- If it does not start, check the port value in Preferences.
- Disable the MCP server when not needed.
