## AI integration troubleshooting

### Start here

If AI does not respond as expected, open AI Preferences (from the AI
panel burger menu) and check:

- the key for your provider (`AI OpenRouter key` or `AI Gemini key`),
- provider-specific options you use (`AI use Ollama`, service address),
- model selection.

### Messages you may see

- `No AI provider is configured.`
  - Required provider settings are missing.
- `Missing AI model selection.`
  - No model is selected yet.
- `Missing OpenRouter key setting.`
  - OpenRouter is selected but the key is empty.
- `Ollama usage is disabled.`
  - Turn on `AI use Ollama` if you want to use Ollama.
- `Unknown AI provider selection.`
  - Re-check provider settings in Preferences.

### MCP not working

If another local AI app cannot use Freeplane through MCP:

- enable `AI MCP server enabled`,
- check `AI MCP server port`,
- check `MCP token`,
- ensure your client sends the token in header
  `X-Freeplane-MCP-Token`.

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
