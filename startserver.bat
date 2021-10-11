@echo off
chcp 65001>nul

"C:\Program Files (x86)\Minecraft Launcher\runtime\jre-x64\bin\java.exe" -Xms512M -Xmx2560M -jar paper_server-1.16.5-788.jar nogui
cls
color 4
echo.
echo.
echo Die Eingabeaufforderung wird automatisch geschlossen, nachdem (k)ein Backup der Weltdateien erstellt wurde
timeout /t 1 /nobreak >nul

:question
echo Soll ein Backup erstellt werden? (y / n)
set /p choice=
for %%A in (Y N) do if /i "%choice%" == "%%A" goto choice%%A
echo Nur (y / n) sind verfügbar & goto question
:choiceN
goto exit

:choiceY
echo Backup wird erstellt...
echo.
rem world
if exist "\\192.168.178.62\Fin\Zu2weit\world" (
color c
echo \\192.168.178.62\Fin\Zu2weit\world wird gelöscht...
rd "\\192.168.178.62\Fin\Zu2weit\world" /s /q
echo \\192.168.178.62\Fin\Zu2weit\world gelöscht
color a
color c
mkdir "\\192.168.178.62\Fin\Zu2weit\world"
echo \\192.168.178.62\Fin\Zu2weit\world erstellt
color a
color c
echo world\* wird zu \\192.168.178.62\Fin\Zu2weit\world kopiert...
xcopy "world\*" "\\192.168.178.62\Fin\Zu2weit\world" /ehqcy
echo.
color a
) else (
color c
mkdir "\\192.168.178.62\Fin\Zu2weit\world"
echo \\192.168.178.62\Fin\Zu2weit\world erstellt
color a
color c
echo world\* wird zu \\192.168.178.62\Fin\Zu2weit\world kopiert...
xcopy "world\*" "\\192.168.178.62\Fin\Zu2weit\world" /ehqcy
echo.
color a
)
rem world_nether
if exist "\\192.168.178.62\Fin\Zu2weit\world_nether" (
color c
echo \\192.168.178.62\Fin\Zu2weit\world_nether wird gelöscht...
rd "\\192.168.178.62\Fin\Zu2weit\world_nether" /s /q
echo \\192.168.178.62\Fin\Zu2weit\world_nether gelöscht
color a
color c
mkdir "\\192.168.178.62\Fin\Zu2weit\world_nether"
echo \\192.168.178.62\Fin\Zu2weit\world_nether erstellt
color a
color c
echo world_nether\* wird zu \\192.168.178.62\Fin\Zu2weit\world_nether kopiert...
xcopy "world_nether\*" "\\192.168.178.62\Fin\Zu2weit\world_nether" /ehqcy
echo.
color a
) else (
color c
mkdir "\\192.168.178.62\Fin\Zu2weit\world_nether"
echo \\192.168.178.62\Fin\Zu2weit\world_nether erstellt
color a
color c
echo world_nether\* wird zu \\192.168.178.62\Fin\Zu2weit\world_nether kopiert...
xcopy "world_nether\*" "\\192.168.178.62\Fin\Zu2weit\world_nether" /ehqcy
echo.
color a
)
rem world_the_end
if exist "\\192.168.178.62\Fin\Zu2weit\world_the_end" (
color c 
echo \\192.168.178.62\Fin\Zu2weit\world_the_end wird gelöscht...
rd "\\192.168.178.62\Fin\Zu2weit\world_the_end" /s /q
echo \\192.168.178.62\Fin\Zu2weit\world_the_end gelöscht
color a
color c
mkdir "\\192.168.178.62\Fin\Zu2weit\world_the_end"
echo \\192.168.178.62\Fin\Zu2weit\world_the_end erstellt
color a
color c
echo world_the_end\* wird zu \\192.168.178.62\Fin\Zu2weit\world_the_end kopiert...
xcopy "world_the_end\*" "\\192.168.178.62\Fin\Zu2weit\world_the_end" /ehqcy
echo.
color a
) else (
color c
mkdir "\\192.168.178.62\Fin\Zu2weit\world_the_end"
echo \\192.168.178.62\Fin\Zu2weit\world_the_end erstellt
color a
color c
echo world_the_end\* wird zu \\192.168.178.62\Fin\Zu2weit\world_the_end kopiert...
xcopy "world_the_end\*" "\\192.168.178.62\Fin\Zu2weit\world_the_end" /ehqcy
echo.
color a
)
:exit