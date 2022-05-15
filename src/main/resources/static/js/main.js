const modalWindow = document.querySelector('.modal');
let theEditor;

ClassicEditor.create(document.querySelector('#ckWrite'), {
    language: 'ko' //언어설정
}).then(editor => {
    theEditor = editor;
})
    .catch(error => {
        console.error(error);
    });

document.querySelectorAll('.x-mark').forEach((x) => {
    x.addEventListener('click', () => {

        modalWindow.style.display = 'none';
    });
});

document.querySelectorAll('.write-modal').forEach((x) => {
    x.addEventListener('click', () => {

        modalWindow.style.display = 'block';
    });
});

const picker = new Lightpick({
    field: document.getElementById('occurredDate'), onSelect: function (date) {
        document.getElementById('occurredDate').innerHTML = date.format('YYYY-MM-DD');
    }
});