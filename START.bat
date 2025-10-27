@echo off
echo ========================================
echo   TRIP MANAGEMENT SYSTEM - AUTO START
echo ========================================
echo.
echo Starting backend server...
echo Please wait...
echo.

cd /d "%~dp0"
call gradlew.bat bootRun

pause
