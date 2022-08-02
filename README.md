# Freeplane docs

The site is served as GitHub Pages at https://docs.freeplane.org/.

The main content is located in the root directory.
There's a sub-directory called `attic`, which contains draft documents, segregated into 
* `old-mediawiki-content`– MediaWiki pages (pre-2022 wiki) migrated to Markdown for GitHub,
* `new-wiki-initiative`– pages created around 2021 and later as an attempt to start using GitHub and Markdown for documentation.

The vision is to clean up `attic`.
Some content in `attic`, especially in `old-mediawiki-content`, might be outdated, some unconverted, some media files missing.
Therefore, the outcome to be achieved is to have each page reviewed/completed before incorporating it to `docs root` and/or removing it from `attic` as no longer relevant.

When a page is incorporated to `docs root` and/or removed from `attic`, all existing `attic` pages linking to it should be updated.
Relative links should be used.

The site uses [docsify](https://docsify.js.org/#/?id=docsify) with the following options/plugins:
* [relativePath: true](https://docsify.js.org/#/configuration?id=relativepath)
* [nested sidebars](https://docsify.js.org/#/more-pages?id=nested-sidebars) with CSS in index.html
* [header and footer hook](https://docsify.js.org/#/write-a-plugin?id=example)
* [search plugin](https://docsify.js.org/#/plugins?id=full-text-search) with a dedicated namespace
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

Alternatively, once changes in your fork are committed and pushed, you can navigate to `README.md` in your fork on GitHub and click the button to run the python http server in GitPod.

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/from-referrer/)
