FOR /r . %%d IN (.idea target node_modules .angular dist) DO @IF EXIST "%%d" rd /s /q "%%d"
FOR /r . %%d IN (*.zip package-lock.json) DO @IF EXIST "%%d" del /s /q "%%d"