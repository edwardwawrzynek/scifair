@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  scifair startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and SCIFAIR_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\scifair.jar;%APP_HOME%\lib\antlr4-4.7.2.jar;%APP_HOME%\lib\pretty-print-2.0.2.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.3.61.jar;%APP_HOME%\lib\antlr4-runtime-4.7.2.jar;%APP_HOME%\lib\ST4-4.1.jar;%APP_HOME%\lib\antlr-runtime-3.5.2.jar;%APP_HOME%\lib\org.abego.treelayout.core-1.0.3.jar;%APP_HOME%\lib\javax.json-1.0.4.jar;%APP_HOME%\lib\icu4j-63.1.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.3.61.jar;%APP_HOME%\lib\kotlin-reflect-1.3.11.jar;%APP_HOME%\lib\kotlin-logging-1.6.22.jar;%APP_HOME%\lib\kotlin-stdlib-1.3.61.jar;%APP_HOME%\lib\logback-classic-1.3.0-alpha4.jar;%APP_HOME%\lib\slf4j-simple-1.6.1.jar;%APP_HOME%\lib\kotlin-logging-common-1.6.22.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.3.61.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\logback-core-1.3.0-alpha4.jar;%APP_HOME%\lib\slf4j-api-1.8.0-beta1.jar;%APP_HOME%\lib\javax.mail-1.6.0.jar;%APP_HOME%\lib\activation-1.1.jar

@rem Execute scifair
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %SCIFAIR_OPTS%  -classpath "%CLASSPATH%" compiler.Main %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable SCIFAIR_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%SCIFAIR_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
