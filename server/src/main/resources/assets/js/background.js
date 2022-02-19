window.onload = function () {
    const html = document.getElementsByTagName('html')[0].outerHTML;
    const canvas = document.getElementById('bg-canvas');
    canvas.height = document.body.scrollHeight;
    canvas.width = document.body.scrollWidth;
    const ctx = canvas.getContext('2d');
    ctx.font = "12px Arial";
    // ctx.textAlign = "center";
    ctx.fillStyle = "#AAA";
    let x, y = 0;
    let lineHeigth = 10;
    fillTextCenter(ctx, html, canvas.width, canvas.height)
}

function fillTextCenter(ctx, text, width, height) {
    ctx.textBaseline = 'middle';
    ctx.textAlign = "center";

    const lines = text.match(/[^\r\n]+/g);
    for (let i = 0; i < lines.length; i++) {
        let x = Math.round(Math.random() * (width - 50))
        let y = (height / (lines.length + 1)) * (i + 1)

        ctx.fillText(lines[i], x, y)
    }
}
