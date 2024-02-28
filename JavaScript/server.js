const http = require('http');
const fs = require('fs');
const path = require('path');
const { tokenApp } = require('./token.js');


const server = http.createServer((req, res) => {
  if (req.method === 'GET') {
    // Serve HTML file for the form
    if (req.url === '/') {
      const htmlPath = path.join(__dirname, 'index.html');
      fs.readFile(htmlPath, 'utf8', (err, data) => {
        if (err) {
          res.writeHead(500, { 'Content-Type': 'text/plain' });
          res.end('Internal Server Error');
        } else {
          res.writeHead(200, { 'Content-Type': 'text/html' });
          res.end(data);
        }
      });
    }
  } else if (req.method === 'POST' && req.url === '/generate-token') {
    // Handle form submission and generate token
    let data = '';
    req.on('data', chunk => {
      data += chunk;
    });
    req.on('end', () => {
      const username = JSON.parse(data).username;
      const generatedToken = tokenApp(username);
      res.writeHead(200, { 'Content-Type': 'application/json' });
      res.end(JSON.stringify({ token: generatedToken }));
    });
  } else {
    res.writeHead(404, { 'Content-Type': 'text/plain' });
    res.end('Not Found');
  }
});

const PORT = 3000;
server.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
