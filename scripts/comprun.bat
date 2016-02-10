@echo off
CALL scripts\compile.bat %1
echo Compilation finished. Trying to run...
CALL scripts\run.bat %1