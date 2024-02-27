const fs = require("fs");
const { initializeApp } = require("./init");
const { config } = require("./config");
const { tokenApp } = require("./token");

// Main function to handle command-line arguments
function main() {
  // Get the command-line arguments
  const args = process.argv.slice(2);

  // Check if there are any arguments
  if (args.length === 0) {
    console.log("No arguments provided");
  } else {
    // Determine the command
    const command = args[0];
    // Logs command:
    const sanitizedTimestamp = new Date().toLocaleDateString().replace(/\//g, '-');
    const logFileName = `logs/${sanitizedTimestamp}.log`;
    if (!fs.existsSync('logs')) {
      fs.mkdirSync('logs');
    }
    fs.appendFile(logFileName, `Command executed: ${command} - Timestamp: ${new Date().toLocaleString()}\n`, (err) => {
      if (err) throw err;
    });
    
    switch (command) {
      case "init":
        initializeApp(args);
        break;
      case "config":
        config();
        break;
      case "token":
        tokenApp();
        break;
      case "--help":
      case "--h":
      default:
        fs.readFile(__dirname + "/usage.txt", (error, data) => {
          if (error) throw error;
          console.log(data.toString());
        });
        break;
    }

  }
}

main();
