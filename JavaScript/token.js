const fs = require("fs");
const path = require("path");
// const crc32 = require("crc/crc32");
// const { format } = require("date-fns");
const template = require("./template");

const myArgs = process.argv.slice(2);


function generateToken(username) {
  const token = {
    ...template.exampleToken,
    username: username,
    created: new Date().toISOString(),
    expires: new Date(Date.now() + 24 * 60 * 60 * 1000).toISOString(),
  };
  
  const tokenDir = "./json";
  const tokenPath = path.join(tokenDir, "tokens.json");
  
  // Check if tokens.json exists and create if not
  if (!fs.existsSync(tokenPath)) {
      fs.writeFileSync(tokenPath, "[]");
    }

    // Add new token to file
    fs.readFile(tokenPath, "utf8", (err, data) => {
      if (err) {
        console.error("Error reading tokens file:", err);
        return;
      }
      let tokens = JSON.parse(data);
      tokens.push(token);
      fs.writeFile(tokenPath, JSON.stringify(tokens, null, 2), (err) => {
        if (err) {
          console.error("Error writing to tokens file:", err);
        } else {
          console.log("Token created successfully.");
        }
      });
    });
return token.token;
}

// Token counting
function tokenCount() {
  const tokensFilePath = path.join(__dirname, "json", "tokens.json");
  fs.readFile(tokensFilePath, (err, data) => {
    if (err) {
      console.error("Error reading tokens file:", err);
      return;
    }
    const tokens = JSON.parse(data);
    console.log(`Total tokens: ${tokens.length}`);
  });
}

// Update token
function updateToken(updateType, username, newValue) {
  const tokensFilePath = path.join(__dirname, "json", "tokens.json");
  fs.readFile(tokensFilePath, "utf8", (err, data) => {
    if (err) {
      console.error("Error reading tokens file:", err);
      return;
    }
    let tokens = JSON.parse(data);
    const userIndex = tokens.findIndex((token) => token.username === username);

    if (userIndex === -1) {
      console.log(`User ${username} not found.`);
      return;
    }

    if (updateType === "p") {
      tokens[userIndex].phone = newValue;
      console.log(`Phone number updated for ${username}.`);
    } else if (updateType === "e") {
      tokens[userIndex].email = newValue;
      console.log(`Email updated for ${username}.`);
    } else {
      console.log('Invalid update type. Use "p" for phone or "e" for email.');
      return;
    }

    fs.writeFile(tokensFilePath, JSON.stringify(tokens, null, 2), (err) => {
      if (err) {
        console.error("Error writing to tokens file:", err);
      } else {
        console.log(`User ${username}'s information updated successfully.`);
      }
    });
  });
}

// Function to search tokens by username(u) email(e) or phone(p)
function searchToken(searchType, searchValue) {
    const tokensFilePath = path.join(__dirname, "json", "tokens.json");
    fs.readFile(tokensFilePath, "utf8", (err, data) => {
        if (err) {
            console.error("Error reading tokens file:", err);
            return;
        }
        let tokens = JSON.parse(data);
        let searchResults = tokens.filter((token) => {
            switch (searchType) {
                case 'p':
                    return token.phone === searchValue;
                case 'e':
                    return token.email === searchValue;
                case 'u':
                    return token.username === searchValue;
                default:
                    return false; // Invalid search type
            }
        });
        if (searchResults.length === 0) {
            console.log(`No tokens found for ${searchType} '${searchValue}'.`);
        } else {
            console.log("Search results:");
            console.log(searchResults);
        }
    });
}


function tokenApp() {
  switch (myArgs[1]) {
    case "--count":
      tokenCount();
      break;
    case "--new":
      if (myArgs.length < 3) {
        console.log("invalid syntax. node myapp token --new [username]");
      } else {
        generateToken(myArgs[2]);
      }
      break;
    case "--upd":
      if (myArgs.length < 5) {
        console.log(
          "Invalid syntax. Use: node myapp token --upd p/e [username] [email] [phone]"
        );
      } else {
        updateToken(myArgs[2], myArgs[3], myArgs[4]);
      }
      break;
    case "--search":
        if (myArgs.length < 4) {
            console.log(
            "Invalid syntax. Use: node myapp token --search u/e/p [username/email/phone]");
        } else {
            let searchType = myArgs[2];
            let searchValue = myArgs[3];
            searchToken(searchType, searchValue);
        }
        break;
    case "--help":
    case "--h":
    default:
      fs.readFile(__dirname + "/usage.txt", (error, data) => {
        if (error) throw error;
        console.log(data.toString());
      });
  }
}

module.exports = {
  tokenApp,
};
