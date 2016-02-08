@echo off
CALL compile.bat %1
echo Compilation finished. Trying to run...
CALL run.bat %1