// Array of folders to be created
const folders = ['config', 'logs', 'json'];

// Default configuration object
const configJson = {
  name: 'MyApp',
  version: '1.0.0',
  description: 'Command Line Interface (CLI) for MyApp',
  main: 'myapp.js',
  superuser: 'admin',
  database: 'exampledb'
};

// Example token data
const exampleToken = {
  created: 'YYYY-MM-DD HH:MM:SS',
  username: 'example_user',
  email: 'user@example.com',
  phone: '1234567890',
  token: 'example_token',
  expires: 'YYYY-MM-DD HH:MM:SS',
  confirmed: 'false' 
};

module.exports = {
  folders,
  configJson,
  exampleToken
};
