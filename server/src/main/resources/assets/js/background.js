window.onload = function () {
    const html = document.getElementsByTagName('html')[0].outerHTML;
    const canvas = document.getElementById('bg-canvas');
    canvas.height = document.body.scrollHeight;
    canvas.width = document.body.scrollWidth;
    const ctx = canvas.getContext('2d');
    ctx.font = "12px Monospace";
    ctx.fillStyle = "#cee7ee";
    fillTextCenter(ctx, html, canvas.width, canvas.height)
}

function fillTextCenter(ctx, text, width, height) {
    ctx.textBaseline = 'middle';
    ctx.textAlign = "center";

    const lines = text
        .match(/[^\r\n]+/g)
        .map(line => line.trim());
    const fps = 50;
    const positions = []
    setInterval(() => {
        ctx.save();
        ctx.setTransform(1, 0, 0, 1, 0, 0);
        ctx.clearRect(0, 0, width, height);
        ctx.restore();
        for (let i = 0; i < lines.length; i++) {
            if (!positions[i]) {
                const x = Math.round(Math.random() * (width - 50));
                const y = (height / (lines.length + 1)) * (i + 1);
                const speed = Math.random() + 0.1;
                const direction = Math.random() > 0.5 ? 'r' : 'l';
                positions[i] = {x, y, speed, direction};
            } else {
                switch (positions[i].direction) {
                    case 'r':
                        positions[i].x += positions[i].speed;
                        break;
                    case 'l':
                        positions[i].x -= positions[i].speed;
                        break;
                }
            }

            ctx.fillText(lines[i], positions[i].x, positions[i].y);
            if (positions[i].x < 0) {
                positions[i].x = width + lines[i].length + 50;
            }
        }
    }, 1000 / fps);
}
