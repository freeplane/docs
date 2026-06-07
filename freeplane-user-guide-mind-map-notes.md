# Freeplane user guide mind map: structure and editing notes

Observed on 2026-06-07.

## Scope

This document records general structure and editing constraints for the
Freeplane user-guide mind map.

Primary target file:

- `/Users/dimitry/git-repo/freeplane/freeplane/freeplane/doc/freeplaneUserGuide.mm`

Sibling source repo used for related code and shipped-document checks:

- `/Users/dimitry/git-repo/freeplane/freeplane`

## Key rule for future edits

Use one write path only.

- Direct `.mm` / XML inspection is useful for analysis.
- Actual content changes should use Freeplane MCP only.
- Do not mix raw XML edits and Freeplane MCP writes in the same change.

Reason:

- MCP preserves Freeplane-level semantics.
- MCP avoids brittle raw-XML editing.
- Raw XML remains useful because MCP does not expose every structural
  property directly.

## Evidence sources used here

Read-only analysis used both:

1. Freeplane MCP reads against the currently open map.
2. Direct XML inspection of `freeplaneUserGuide.mm`.
3. Source search in the sibling Freeplane repo.

## Identity of the open map

The open Freeplane map and the target file match at least by content and
node IDs.

Observed matches:

- root node ID: `ID_1723255651`
- root text: `Tutorial / Freeplane 1.7`
- top-level chapter order matches
- top-level chapter IDs match

That is enough to treat the current open map content as the target map
for planning purposes.

## Where this map is used

This map is an application-shipped document, not part of this mdBook
site.

Observed references:

- `freeplane/src/viewer/resources/freeplane.properties`
  - `docu_map=doc/freeplaneUserGuide.mm`
  - `latest_features_map=doc/latestFreeplaneFeatures.mm`
- other shipped `.mm` files link into specific node IDs inside
  `freeplaneUserGuide.mm`

Important consequence:

- preserve existing node IDs when editing existing referenced content
- do not delete and recreate existing referenced nodes unless you also
  repair all inbound links

## Current high-level structure

Observed from the saved file and from MCP:

- total nodes: 1,511
- top-level nodes: 21
- most top-level content is on the main side as folded, numbered
  chapters
- `Latest features` is a special linked node on the opposite side of
  the root

Important consequence:

- treat normal chapter additions differently from the special
  `Latest features` linked node
- re-read the current top-level order live when exact placement matters

## Content model actually used in this map

Observed counts from direct XML inspection:

- total nodes: 1,511
- nodes with plain `TEXT` attribute: 1,311
- nodes with `richcontent TYPE="NODE"`: 200
- nodes with details: 116
- nodes with hidden details: 62
- nodes with notes: 0
- nodes with attributes: 3
- total attributes: 8
- nodes with icons: 79
- total icons: 82
- nodes with links: 58
- details blocks containing `<img>`: 33
- node-core blocks containing `<img>`: 6
- nodes with `ExternalObject` hooks: 5

### Practical meaning

For this map, the dominant patterns are:

- short text in node core
- longer explanation in details
- HTML details for formatted paragraphs and screenshots
- almost no notes
- very little attribute usage outside example or template material

For similar future edits, default to:

- node core text for labels
- details for multi-paragraph explanation
- no notes unless there is a strong reason to introduce a new pattern

## Details and notes behavior

Observed:

- `DETAILS` are used heavily
- `NOTE` is not used at all in this map
- many details blocks are hidden by default

Example stored pattern:

```xml
<node TEXT="Environment preferences" ID="ID_908072469">
  <richcontent TYPE="DETAILS">
    <html>...</html>
  </richcontent>
</node>
```

Example hidden-details pattern:

```xml
<node TEXT="screenshot (without annotations)" ID="ID_1712284942">
  <richcontent TYPE="DETAILS" HIDDEN="true">
    <html>...</html>
  </richcontent>
</node>
```

Important consequence:

- hidden details are a real existing convention here
- Freeplane MCP structured node tools do not expose the hidden-details
  flag directly
- if hidden details matter for a future change, use a Freeplane API
  script through MCP rather than raw XML editing

## Node core formats

This map uses both plain node text and HTML node core content.

Example plain node:

```xml
<node TEXT="Introduction" STYLE_REF="Introduction" FOLDED="true"
      ID="ID_86446891" NUMBERED="true">
```

Example HTML node core:

```xml
<node ID="ID_131498432">
  <richcontent TYPE="NODE">
    <html>...</html>
  </richcontent>
</node>
```

Important consequence:

- do not assume existing node core text is plain text
- before editing existing text or details through MCP, fetch the node
  and preserve the original content type
- otherwise it is easy to flatten HTML content accidentally

## MCP formatting visibility limits

Through the normal structured MCP node tools, formatting visibility is
limited.

What those tools do expose:

- `mainStyle`
- `activeStyles`
- content and content type for text/details/note
- icons, tags, attributes, hyperlink

What they do not expose:

- per-property formatting values such as width, colors, borders, edge
  properties, numbering, or hidden-details state
- per-property provenance such as "comes from style" vs "stored on the
  node"
- a direct audit of redundant local formatting that merely repeats a
  style value

Practical consequence:

- if style-vs-local formatting matters, structured MCP tools alone are
  not enough to prove it
- for read-only analysis, XML is still the stronger source for exact
  stored node attributes
- for MCP-only writing, the safe default is to assign styles and avoid
  local formatting overrides

## HTML authoring rules

User clarification for future rich-text edits:

- do not apply HTML formatting at whole-body level
- use HTML mainly for structure and element-level formatting
- baseline support is HTML 3.2
- `span` elements with `style` are additionally supported

Practical consequence:

- use tags such as `p`, `ul`, and `li` for structure
- if emphasis is needed, apply it to specific elements or words, not to
  the whole body
- prefer style-driven node formatting over content-level visual styling

## Images and screenshots

Observed image usage patterns:

1. HTML `<img>` inside details
2. HTML `<img>` inside node core
3. `ExternalObject` hooks

Example details image pattern:

```xml
<richcontent TYPE="DETAILS" HIDDEN="true">
  <html>
    <body>
      <p>
        <img src="Images/other/workspace/Freeplane%20workspace.png"
             width="1000" height="544">
      </p>
    </body>
  </html>
</richcontent>
```

Observed image directories already in use:

- `freeplane/doc/Images/doc`
- `freeplane/doc/Images/mouse`
- `freeplane/doc/Images/other`
- `freeplane/doc/Images/other/workspace`

Important consequence:

- if future documentation adds screenshots, the image files must also
  be added under `freeplane/doc/Images/...`
- if the goal is a low-risk first increment, keep it text-only

## Links and link patterns

Observed link breakdown:

- internal `#ID_...` links: 38
- HTTP/HTTPS links: 10
- `menuitem:` links: 4
- bare `ID_...` links: 2
- image-file links: 2
- `mailto:` links: 1
- `.mm` file links: 1

Example internal link:

```xml
<node TEXT="Unfold all" LINK="#ID_86446891" .../>
```

Example file link:

```xml
<node TEXT="Latest features" LINK="latestFreeplaneFeatures.mm" .../>
```

Important consequence:

- normal internal map cross-links use `#ID_...`
- there are also less obvious legacy or special-case link values in this
  map, so do not assume every non-HTTP link is external or broken
- if future documentation needs in-map cross-links, prefer the existing
  `#ID_...` convention

## Styles and structural conventions

### Styles returned by Freeplane MCP

`freeplane_listMapStyles` returned these style names:

- `Default`
- `Floating node`
- `Introduction`
- `Beginner`
- `Advanced`
- `Professional`
- `TitlesContent`
- `Example`
- `Revision`
- `Purpose`
- `Actions`
- `Notes and explanations`
- `Tips and tricks`
- `Old documentation`
- `MyTemplate`
- `MainWidth`
- `SubWidth`
- `Method`
- `Root`
- `Level 1`
- `Level 2`
- `Level 3`
- `Level 4`

### Styles observed in actual node use

Actual nodes also use style names such as:

- `Title`
- `BeginnerTopic`
- `AdvancedTopic`
- `ProfessionalTopic`
- `ConsumerTopic`
- `image in details`
- `Bible`
- conditional references such as `MenuTitle` and `MainMenu`

Important consequence:

- `freeplane_listMapStyles` was not exhaustive for this map
- actual node styles must be verified from real nodes or XML when style
  accuracy matters
- do not assume the style list tool gives the full set of usable style
  names in this map

### High-value style conventions

Observed from map styles and from `Best practices / The making of this
mind map`:

- top-level chapters use `Introduction`, `Beginner`, `Advanced`, or
  `Professional`
- top-level chapters are folded
- top-level chapters are numbered
- `TitlesContent` is used for supporting text below a title and usually
  hides the edge
- `Purpose`, `Actions`, `Notes and explanations`, and `Tips and tricks`
  are reusable instructional styles
- `Example` adds an eye-like icon
- `Revision` marks revision-related content

Important consequence:

- new chapter-like content should follow the existing chapter-style
  model
- a summary paragraph under a title can reuse `TitlesContent`
- new content does not need a new style unless existing styles are
  clearly insufficient

## Numbering behavior

Displayed chapter numbers are not part of the raw node text.

Observed pattern:

```xml
<node TEXT="Calculations" STYLE_REF="Professional" NUMBERED="true" ...>
```

MCP plain-text reads render that as `14 Calculations`, but raw XML text
remains just `Calculations`.

Important consequence:

- numbering is a node style property, not text content
- do not hardcode chapter numbers into new node text
- if a new chapter must display a chapter number, it needs numbering
  enabled on the node

Source inspection found script API support for numbering here:

- `freeplane_plugin_script/src/main/java/org/freeplane/plugin/script/proxy/NodeStyleProxy.java`
  - `setNumberingEnabled(boolean)`
  - `setNumbering(Boolean)`

This was observed in source only. It was not executed yet in this
session.

## Detail-hiding behavior

Source inspection found script API support here:

- `freeplane_plugin_script/src/main/java/org/freeplane/plugin/script/proxy/NodeProxy.java`
  - `setHideDetails(boolean)`

This matters because MCP structured node creation/editing does not
expose hidden details directly.

This was observed in source only. It was not executed yet in this
session.

## Useful existing chapter patterns

### `Calculations`

Observed pattern:

- top-level `Professional` chapter, numbered and folded
- second-level `Professional` subsections
- short, summary-level teaching content
- links out to wiki for deeper coverage

### `Fine tuning Freeplane`

Observed pattern:

- mixed subsection styles under one top-level chapter
- some sections use a lead summary node followed by folded detail nodes
- details are common for long text

### `Best practices / The making of this mind map`

This branch is a direct explanation of map conventions.

Useful takeaways already encoded there:

- top-level numbered chapter pattern
- `TitlesContent` as the content-under-title pattern
- meaning of `Example` and `Revision`
- user-defined style intent

## Recommended MCP workflow for future map edits

1. Use MCP reads first.
   - `freeplane_readNodesWithDescendantsAsPlainText` for quick topology
   - `freeplane_searchNodes` to find anchors
   - `freeplane_fetchNodesForEditing` before changing existing text or
     details
2. Prefer structured node creation/editing.
   - create nodes with text, details, icons, hyperlink, folding state,
     and main style where possible
3. Preserve content types.
   - existing HTML node core or HTML details should stay HTML unless the
     change deliberately removes formatting
4. Use internal links by node ID.
   - follow the existing `#ID_...` convention
5. Use a small Freeplane API script through MCP only for gaps.
   - numbering
   - hidden details
   - possibly other node properties not exposed by structured tools
6. Avoid recreating existing nodes that other maps link to.

## Things not yet verified

These remain unverified and should be treated as open until tested:

- whether `freeplane_listMapStyles` omission is a tool limitation, a map
  quirk, or a distinction between style categories
- whether MCP structured creation can assign style names such as
  `Title` or `image in details` even though they were not returned by
  `freeplane_listMapStyles`
- exact save diff behavior after an MCP-driven write to this map
- whether numbering and hidden-details changes through an MCP-run script
  need any additional refresh or save handling

## Bottom line

For this map:

- use core text plus details
- do not introduce notes unless necessary
- preserve HTML content types when editing existing nodes
- preserve existing node IDs
- use MCP as the only write path
- use direct XML only as a read-only analysis tool
- treat `Latest features` as a special linked side node, not the normal
  template for chapter placement
