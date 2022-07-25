# Freeplane docs

The site is served as GitHub Pages at https://docs.freeplane.org/.

The main site is `Docs`, with `Attic` as a sub-directory.

`Attic` contains MediaWiki pages (pre-2022 wiki) migrated to Markdown for GitHub.
The vision is to bring all MediaWiki content from `Attic` to `Docs`.
Some content in `Attic` might be outdated, some unconverted, some media files missing.
Each `attic` page needs to be reviewed/completed before incorporating it to `Docs`.

When a page is incorporated to `Docs` and removed from `Attic`, all existing `Attic` pages linking to it should be updated.
Relative links should be used.

The site uses [docsify](https://docsify.js.org/#/?id=docsify) with the following options/plugins:
* [relativePath: true](https://docsify.js.org/#/configuration?id=relativepath)
* [nested sidebars](https://docsify.js.org/#/more-pages?id=nested-sidebars) with CSS in index.html
* [header and footer hook](https://docsify.js.org/#/write-a-plugin?id=example)
* [search plugin](https://docsify.js.org/#/plugins?id=full-text-search) with a dedicated namespace for each site
* [image zoom plugin](https://docsify.js.org/#/plugins?id=zoom-image)
* [Groovy language syntax highlight](https://docsify.js.org/#/language-highlight)
* [Bash/Shell syntax highlight](https://docsify.js.org/#/language-highlight)
* [Darklight theme](https://docsify-darklight-theme.boopathikumar.me/#/)

## How to run docsify locally 

* Install python, if not already available → https://www.python.org/downloads/
* Clone the repository, e.g. `git clone https://github.com/freeplane/docs.git`
* Change directory to docs `cd docs` and run python http server: `python -m http.server 3000` → [Manually preview your site](https://docsify.js.org/#/quickstart?id=manually-preview-your-site)
* Browse the site at http://127.0.0.1:3000/

## Edit on-line

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/from-referrer/)
