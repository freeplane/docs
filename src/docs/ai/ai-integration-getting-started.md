## AI integration: getting started

AI integration is available starting with Freeplane version `1.13.1`.

### Configure AI in Preferences

Open AI Preferences from the AI panel toolbar burger menu, then
configure the AI options.

Required user input:
  
- For OpenRouter:
  - `AI OpenRouter key`
- For Gemini:
  - `AI Gemini key`
- For Ollama:
  - enable `AI use Ollama` when you want Ollama as provider.

If configuration is missing, chat shows:
`No AI provider is configured.`

### Send your first AI chat message

1. Open the `AI` panel.
2. Type a request in the input area.
3. Use `Send` or press `Command/Ctrl + Enter` to start the request.
4. Use `Cancel` to stop an active request.

Helpful chat controls:

- `New chat`: start a clean live chat.
- `Chats`: open the chat list dialog.
- `Manage profiles`: open profile management.
- `AI profile`: shows or selects the active profile.

### Next steps

- Continue with workflow patterns in
  [AI chat workflows](ai-chat-workflows.md).
- For remote tool access, see
  [Model Context Protocol server](model-context-protocol-server.md).
  MCP is disabled by default and should be enabled only when needed,
  for example when using Freeplane from local MCP-capable tools such as
  Claude Desktop or Codex App.
- For diagnosis, see
  [AI integration troubleshooting](ai-integration-troubleshooting.md).
