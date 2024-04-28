# How to set up this Project

### 1. Download Scene Builder for JDK 21

<a href="https://gluonhq.com/products/scene-builder/">Link to Download</a>  (make sure to pick the right OS system)

![Step 1](https://github.com/RyanTren/SWE3313-Automation-Project/blob/fmxl-test/javafx/instructionPics/downloadSceneBuilder.png?raw=true)


### 2. Open the project in InteliJ

If you're using Intellij & having trouble opening the git version of the project:
Assuming you have the following folder structure (note the 2 .idea hidden folders)
.
├── .git
│   ├── hooks
│   ├── info
│   ├── logs
│   ├── objects
│   └── refs
├── .idea <======
│   └── dataSources
├── .vscode
├── Project Plan
├── Team Assignment
├── Team Resumes
├── db_scripts
└── javafx
    ├── .idea <=======
    ├── .mvn
    ├── instructionPics
    ├── src
    └── target
 - If open, close the project in Intellij
 - On the Welcome Screen, right click & remove the project from list
 - Exit Intellij completely
 - Go to the project folder in the terminal (if on windows, open a powershell terminal)
 - List folder content (mac/linux: ls -la  , win: ls) 
 - If there's a .idea folder, delete it (rm -fr .idea, win: rm -Force -Recurse .idea)
 - cd into javafx folder. Repeat step #5
 - Open Intellij.
 - Click Open on the Welcome screen & open the root project folder (the one with everything as shown above)
 - do not open just the javafx folder

   ### 3. Download Docker Desktop & Run Docker in Terminal

   <a href="https://www.docker.com/products/docker-desktop/">Link to Download</a>

   After Installing, run these commands in you IDE's terminal: docker compose up -d (creates & starts the container contianing the mySQL DB), docker compose down --volumes (stops & removes the container contianing the mySQL DB)

   ### 4. Run App.java

   Make sure you set your SDK to Oracle 22, that is the version our project is currently running.

   ![Image](https://github.com/RyanTren/SWE3313-Automation-Project/blob/fmxl-test/javafx/instructionPics/pic.PNG)
