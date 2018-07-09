**Tools used**
--------------
TestNg -> Unit Testing Frmework
Maven -> Build Tool
ReportNG -> For HTML Report Generations
TestNGListeners -> To handle TestNG events
WebEvent Listeners -> To Handle Web driver events
File utils- > To read Data from
Log4j -> logging for Java
Config -> to read data from maven profiles
Frame Work Model -> Page Factory Pattern
Git -> Source control
Headless -> scripts will run in chrome headless mode also

**How to Execute**
----------------
Download the Framework from GIT

Intellij -> View Tool Windows -> Maven -> Select Desired profile (prod-local-chrome)

prod -> Environment (stag, qa, prod)
local -> Execution type (local, grid, saucelabs, browser stack)
chrome -> Browser type

We can update the profile length with as many values as we can

*Terminal*
install mvn from Terminal
navigate to project path from Terminal
Type "mvn clean install -Denv=prod-chrome-local"  (without quotes) and press enter

Reports
----------
Reports will be genrated under test-output folder after execution


Doc
-----
Can view the project doc under doc -> index.html

