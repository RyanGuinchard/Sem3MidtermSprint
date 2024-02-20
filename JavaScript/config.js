const fs = require('fs');
const path = require('path');
const template = require('./template');

const myArgs = process.argv.slice(2);

function resetConfig() {
    const filePath = "./config/config.json";
    fs.writeFileSync(filePath, JSON.stringify(template.configJson, null, 2));
    console.log(`Configuration reset: ${filePath}`);
}


function viewConfig() {
    const filePath = path.join(__dirname, 'config', 'config.json');
    fs.readFile(filePath, 'utf-8', (error, data) => {
        if (error) {
            console.error('Error reading config file:', error);
            console.log('If the problem persists, refresh the directory by running the init command.');
        } else {
            console.log('Current Configuration:');
            console.log(JSON.parse(data));
        }
    });
}

function setConfig() {
    const filePath = path.join(__dirname, 'config', 'config.json');
    const key = process.argv[4];
    const value = process.argv[5];
    if (!key || !value) {
        console.error('Usage: node yourScript.js --set <key> <value>')
        return;
    }
    try {
        const config = JSON.parse(fs.readFileSync(filePath, 'utf-8'))
        config[key] = value
        fs.writeFileSync(filePath, JSON.stringify(config, null, 2))
        console.log(`Configuration updated: ${filePath}`);
    } catch (error) {
        console.error('Error updating config:', error);
    }
    
}

function config() {
    switch (myArgs[1]) {
        case '--show':
            viewConfig();
            break;
        case '--reset':
            resetConfig();
            break;
        case '--set':
            setConfig();
            break;
        case '--help':
        case '--h':
        default:
            fs.readFile(__dirname + "/usage.txt", (error, data) => {
                if (error) throw error;              
                console.log(data.toString());
            });
            break;
    }
}

module.exports = { config };
