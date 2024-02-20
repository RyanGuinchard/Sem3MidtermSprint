const fs = require("fs");
const path = require("path");
const template = require("./template");

function initializeApp(args) {
    console.log("Initializing the application...");
    console.log("Arguments:", args); // Print out the arguments for debugging
  
    // Check if any options are provided
    if (args && args.length > 1) {
      const option = args[1];
      switch (option) {
        case "--mk":
          createAllFolders();
          break;
        case "--cat":
          createAllFiles();
          break;
        case "--all":
          createAllFolders();
          createAllFiles();
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
    } else {
      // Create needed directories
      createNeededDirectories();
  
      // Add default configuration files
      addDefaultConfig();
    }
  }

function createNeededDirectories() {
  console.log("Creating needed directories...");

  // Define directory paths
  const directories = ["./config", "./logs"];

  // Create directories if they don't exist
  directories.forEach((directory) => {
    if (!fs.existsSync(directory)) {
      fs.mkdirSync(directory);
      console.log(`Created ${directory}`);
    } else {
      console.log(`${directory} already exists`);
    }
  });
}

function addDefaultConfig() {
  console.log("Adding default configuration...");

  // Write default config to file
  const configPath = "./config/config.json";
  fs.writeFileSync(configPath, JSON.stringify(template.configJson, null, 2));
  console.log(`Default configuration added to ${configPath}`);
}

function createAllFolders() {
  console.log("Creating all the application folders...");
  // Define directory paths
  const directories = ["./models", "./views", "./routes", "./logs", "./json"];

  // Create directories if they don't exist
  directories.forEach((directory) => {
    if (!fs.existsSync(directory)) {
      fs.mkdirSync(directory);
      console.log(`Created ${directory}`);
    } else {
      console.log(`${directory} already exists`);
    }
  });
}

function createAllFiles() {
  console.log("Creating all the application files...");

  // Define file paths and contents
    const files = [
        { path: "./models/model.js", content: "// Model goes here" },
        { path: "./views/index.html", content: "<!-- HTML goes here -->" },
        { path: "./routes/route.js", content: "// Route goes here" },
        { path: "./logs/log.txt", content: "" },
        { path: "./json/data.json", content: "[]" },
    ];

    // Create files if they don't exist
    files.forEach((file)=>{
        if (!fs.existsSync(file.path)) {
            fs.writeFileSync(file.path, file.content);
            console.log(`Created ${file.path}`);
        } else {
            console.log(`${file.path} already exists`);
        }
    })
}

module.exports = { initializeApp };
