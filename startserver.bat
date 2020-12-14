@echo off
chcp 65001>nul
"C:\Program Files (x86)\Minecraft Launcher\runtime\jre-x64\bin\java.exe" -Xms512M -Xmx2560M -jar paper_server_1.16.4-320.jar nogui
cls
color 4
echo.
echo.
echo Die Eingabeaufforderung wird automatisch geschlossen, nachdem ein Backup der Weltdateien erstellt wurde
timeout /t 2 /nobreak >nul

:question
echo Soll ein Backup erstellt werden? (y / n)
set /p choice=
for %%A in (Y N) do if /i "%choice%" == "%%A" goto choice%%A
echo Nur (y / n) sind verfügbar & goto question
:choiceN
goto exit

:choiceY
echo Backup wird erstellt...
rem world
if exist "\\Fritz-nas\fritz.nas\Zu2weit\world" (
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world wird gelöscht
rd "\\Fritz-nas\fritz.nas\Zu2weit\world" /s /q
echo \\Fritz-nas\fritz.nas\Zu2weit\world gelöscht
color a
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world wird erstellt
mkdir "\\Fritz-nas\fritz.nas\Zu2weit\world"
echo \\Fritz-nas\fritz.nas\Zu2weit\world erstellt
color a
color c
echo world\* wird zu \\Fritz-nas\fritz.nas\Zu2weit\world kopiert
xcopy "world\*" "\\Fritz-nas\fritz.nas\Zu2weit\world" /ehqcy
echo world\* wurde zu \\Fritz-nas\fritz.nas\Zu2weit\world kopiert
color a
) else (
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world wird erstellt
mkdir "\\Fritz-nas\fritz.nas\Zu2weit\world"
echo \\Fritz-nas\fritz.nas\Zu2weit\world erstellt
color a
color c
echo world\* wird zu \\Fritz-nas\fritz.nas\Zu2weit\world kopiert
xcopy "world\*" "\\Fritz-nas\fritz.nas\Zu2weit\world" /ehqcy
echo world\* wurde zu \\Fritz-nas\fritz.nas\Zu2weit\world kopiert
color a
)
rem world_nether
if exist "\\Fritz-nas\fritz.nas\Zu2weit\world_nether" (
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world_nether wird gelöscht
rd "\\Fritz-nas\fritz.nas\Zu2weit\world_nether" /s /q
echo \\Fritz-nas\fritz.nas\Zu2weit\world_nether gelöscht
color a
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world_nether wird erstellt
mkdir "\\Fritz-nas\fritz.nas\Zu2weit\world_nether"
echo \\Fritz-nas\fritz.nas\Zu2weit\world_nether erstellt
color a
color c
echo world_nether\* wird zu \\Fritz-nas\fritz.nas\Zu2weit\world_nether kopiert
xcopy "world_nether\*" "\\Fritz-nas\fritz.nas\Zu2weit\world_nether" /ehqcy
echo world_nether\* wurde zu \\Fritz-nas\fritz.nas\Zu2weit\world_nether kopiert
color a
) else (
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world_nether wird erstellt
mkdir "\\Fritz-nas\fritz.nas\Zu2weit\world_nether"
echo \\Fritz-nas\fritz.nas\Zu2weit\world_nether erstellt
color a
color c
echo world_nether\* wird zu \\Fritz-nas\fritz.nas\Zu2weit\world_nether kopiert
xcopy "world_nether\*" "\\Fritz-nas\fritz.nas\Zu2weit\world_nether" /ehqcy
echo world_nether\* wurde zu \\Fritz-nas\fritz.nas\Zu2weit\world_nether kopiert
color a
)
rem world_the_end
if exist "\\Fritz-nas\fritz.nas\Zu2weit\world_the_end" (
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world_the_end wird gelöscht
rd "\\Fritz-nas\fritz.nas\Zu2weit\world_the_end" /s /q
echo \\Fritz-nas\fritz.nas\Zu2weit\world_the_end gelöscht
color a
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world_the_end wird erstellt
mkdir "\\Fritz-nas\fritz.nas\Zu2weit\world_the_end"
echo \\Fritz-nas\fritz.nas\Zu2weit\world_the_end erstellt
color a
color c
echo world_the_end\* wird zu \\Fritz-nas\fritz.nas\Zu2weit\world_the_end kopiert
xcopy "world_the_end\*" "\\Fritz-nas\fritz.nas\Zu2weit\world_the_end" /ehqcy
echo world_the_end\* wurde zu \\Fritz-nas\fritz.nas\Zu2weit\world_the_end kopiert
color a
) else (
color c
echo \\Fritz-nas\fritz.nas\Zu2weit\world_the_end wird erstellt
mkdir "\\Fritz-nas\fritz.nas\Zu2weit\world_the_end"
echo \\Fritz-nas\fritz.nas\Zu2weit\world_the_end erstellt
color a
color c
echo world_the_end\* wird zu \\Fritz-nas\fritz.nas\Zu2weit\world_the_end kopiert
xcopy "world_the_end\*" "\\Fritz-nas\fritz.nas\Zu2weit\world_the_end" /ehqcy
echo world_the_end\* wurde zu \\Fritz-nas\fritz.nas\Zu2weit\world_the_end kopiert
color a
)
:exit