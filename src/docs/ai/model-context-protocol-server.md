## Model Context Protocol server

Use this feature when you want another local AI app to work with your
Freeplane maps.

Typical example:
- You use Claude Desktop or Codex App and want it to read or modify
  map content through Freeplane tools.

By default, this feature is disabled. Enable it only when you need it.

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

If `MCP token` is empty, Freeplane generates a new token on the first
incoming client request. That first request is rejected by design. Copy
the generated token and retry from your client.

### Safety notes

- Keep the token secret.
- If it does not start, check the port value in Preferences.
- Disable the MCP server when not needed.
