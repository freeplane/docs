function freeplaneDocsAddHeader(hook, vm) {
    hook.beforeEach(function(html) {
        let atticBanner;
        if (/\/attic\//.test(vm.route.path)) {
            atticBanner = `
<div style="opacity: 0.7; border: 1px solid #0074d9; padding: 5px; margin-top: 40px;">
  ℹ️ <b>old-mediawiki-content</b> contains MediaWiki pages (pre-2022 wiki) migrated to Markdown for GitHub.
  Some content might be outdated, some unconverted, some media files missing.
  Each <b>attic</b> page needs to be reviewed/completed before incorporating it to <b>docs root</b>.
</div>`
    } else {
        atticBanner = '';
    }
    const questionMarkAll = /\?.*/;
    const lastSegmentAkaPageName = vm.route.path.replace(questionMarkAll, '').split('/').pop();
    let tocId;
    if (freeplaneDocsTocBlacklist.includes(lastSegmentAkaPageName)) { // _toc-blacklist.js
        tocId = 'ignore-toc';
    } else {
        tocId = 'toc';
    }
    let header = `
<div id="${tocId}"></div>
<script>freeplaneDocsMain();</script>\n\n`;

    return (
        atticBanner +
        header +
        html
    );
  });
}

function freeplaneDocsMain() {
    const questionMarkAll = /\?.*/;
    const fourZeroFour = document.querySelector('div#four-zero-four');
    if (fourZeroFour) {
        const isAttic = /\/attic\//.test(location.href);
        if (!isAttic) {
            const locationShort = location.href.replace(location.origin, '');
            const atticHref = locationShort.split('/#/')[0] + '/#/attic/old-mediawiki-content/';
            const lastSegment = location.href.replace(questionMarkAll, '').split('/').pop();
            const targetHref = atticHref + lastSegment;
            fourZeroFour.innerHTML = `Try the Attic: <a href="${targetHref}">${targetHref}</a>`;
        }
    } else {
        const toc = document.querySelector('div#toc');
        if (toc) {
            const lst = document.querySelector('section.content').querySelectorAll('h1,h2,h3,h4,h5,h6');
            if (lst.length > 0) {
                let topH = 'H6';
                for (let h of lst) {
                    topH = h.tagName < topH ? h.tagName : topH;
                }
                const blockquote = document.createElement('blockquote');
                toc.insertAdjacentElement('afterBegin', blockquote);
                const details = document.createElement('details');
                details.onclick = function() {
                    localStorage.setItem('keepTocClosed', details.open);
                };
                const keepTocClosed = localStorage.getItem('keepTocClosed') == 'true';
                if (!keepTocClosed) {
                    details.open = true;
                }
                blockquote.insertAdjacentElement('afterBegin', details);
                details.insertAdjacentHTML('afterBegin', '<summary style="font-weight: 600;">Contents</summary>');
                const ul = document.createElement('ul');
                details.insertAdjacentElement('beforeEnd', ul);
                for (let h of lst) {
                    const li = document.createElement('li');
                    ul.insertAdjacentElement('beforeEnd', li);
                    li.style.marginLeft = `${h.tagName[1]-topH[1]}em`;
                    const a = document.createElement('a');
                    li.insertAdjacentElement('beforeEnd', a);
                    a.href = `${location.hash.replace(questionMarkAll, '')}?id=${h.id}`;
                    a.textContent = h.textContent;
                }
            }
        }
    }
}
