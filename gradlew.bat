@echo off
echo This is a mock gradlew.bat script
echo Arguments: %*
REM 여기서 원하는 명령어별로 처리 가능
if "%1"=="bootRun" (
    echo Mock running bootRun task...
) else (
    echo Unknown task %1
)