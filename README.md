# Freeplane docs

The site is served as GitHub Pages at https://docs.freeplane.org/.

The site uses [mdbook](https://rust-lang.github.io/mdBook/) with the following preprocessors:
* [mdbook-toc](https://github.com/badboy/mdbook-toc)
* [mdbook-open-on-gh](https://github.com/badboy/mdbook-open-on-gh)

Mdbook generates static html pages from the markdown sources. 
Is includes only pages listed in the table of content file `src/docs/SUMMARY.md`.

The main content is located in the `src/docs` directory.
There's a sub-directory called `attic`, which contains draft documents, separated into

* `old-mediawiki-content`– MediaWiki pages (pre-2022 wiki) migrated to Markdown for GitHub,
* `new-wiki-initiative`– pages created around 2021 and later as an attempt to start using GitHub and Markdown for documentation.

The vision is to clean up `attic`.
Some content in `attic`, especially in `old-mediawiki-content`, might be outdated, some unconverted, some media files missing.
Therefore, the outcome to be achieved is to have each page reviewed/completed before incorporating it to `docs root` and/or removing it from `attic` as no longer relevant.

When a page is incorporated to `docs root` and/or removed from `attic`, all existing `attic` pages linking to it should be updated.
Relative links should be used.

## How to run the site locally

* Install mdbook and the preprocessors
* Clone the repository, e.g. `git clone https://github.com/freeplane/docs.git`
* Change directory to docs `cd docs`
* Run `mdbook serve src --dest-dir ../build/gh-pages -p 3000`
* Browse the site at http://localhost:3000/
* When you edit the pages, the changes are applied automatically

## Edit on-line

You can edit and preview the documentation in an online IDE Gitpod. It contains an embedded python HTTP server which starts automatically and shows all changes as you introduce them. To run it with your forked repository, you can navigate to README.md in your fork on GitHub and click the `Open in Gitpod` button below.

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/from-referrer/) 

Alternatively, can get this repo running instantly with Codeanywhere by clicking the button below.

[![Open in Codeanywhere](https://codeanywhere.com/img/open-in-codeanywhere-btn.svg)](https://app.codeanywhere.com/#https://github.com/daytonaio/devcontainer-generator)




