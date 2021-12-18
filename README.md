# EASYMED
Hospital management application.

# Description
EASYMED is a hospital management application where we can keep track of our staff, patients and rooms occupancy.

## Getting started!

### Backend
1. Install Open JDK
Make sure that the latest LTS (Long Term Support) at least Open Java Development Kit (JDK) is installed on your system.
Executing the java --version command in the shell shows at least the latest LTS version number.

2. Install an IDE that supports Maven and Java
This project was developed in IntelliJ IDEA Ultimate

3. Clone the repo to your local machine
You can do that by running the following command in your terminal, make sure you are in the right directory.
```git clone https://github.com/github_username/repo_name.git```

4. Create your own application.properies file in a new resources directory and write
   ```
   spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
   spring.jpa.hibernate.ddl-auto=create-drop
   spring.datasource.url=databaseURL
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword
   spring.jpa.show-sql=false
   ```

5. Run the application from the ```EHealthApplication``` file.

### Frontend 
1. Install NodeJS
If you're using Ubuntu open up your terminal and run this commands:
```
curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash -
sudo apt-get install -y nodejs
```

2. Install Visual Studio Code or other IDE's that support React.

3. Open the project and run "npm install" in the terminal to install all the node modules.

4. After the modules are installed run "npm start" in the terminal and the application will automatically open in your browser.

## Authors
- Sabrina Staicu (SabrinaStaicu)
- Andrei Penica (OvidiuAndrei98)
