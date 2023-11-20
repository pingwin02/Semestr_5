FOR /d /r . %%d IN (.idea target) DO @IF EXIST "%%d" rd /s /q "%%d"
pause