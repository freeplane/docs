## AI integration troubleshooting

### Start here

If AI does not respond as expected, open AI Preferences (from the AI
panel burger menu) and check:

- the key for your provider (`AI OpenRouter key` or `AI Gemini key`),
- provider-specific options you use (for Ollama:
  `AI Ollama service address`, and if required
  `AI Ollama API key`),
- model selection.

### Messages you may see

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

### MCP not working

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

### Quick success checklist

Use this after changes or upgrades:

- `Chats` dialog can `Delete` selected recent entries.
- profile-based workflows run consistently for branch text tasks.
- note summarization works for long notes, including notes manually
  extracted from PDFs.
- decision drafting workflows are usable in daily map work.
