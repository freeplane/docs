function populateToc() {
    const toc = document.querySelector('div#toc');
    if (toc) {
        const lst = document.querySelector('section.content').querySelectorAll('h1,h2,h3,h4,h5,h6');
        let topH = 'H6';
        for (let h of lst) {
            topH = h.tagName < topH ? h.tagName : topH;
        }
        toc.insertAdjacentHTML('afterBegin', '<span>Contents</span><br>');
        const ul = document.createElement('ul');
        toc.insertAdjacentElement('beforeEnd', ul);
        for (let h of lst) {
            const li = document.createElement('li');
            ul.insertAdjacentElement('beforeEnd', li);
            li.style.marginLeft = `${h.tagName[1]-topH[1]}em`;
            const a = document.createElement('a');
            li.insertAdjacentElement('beforeEnd', a);
            a.href = `${location.hash}?id=${h.id}`;
            a.textContent = h.textContent;
        }
        toc.insertAdjacentHTML('afterEnd', '<hr>');
    }
}
