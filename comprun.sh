#!/bin/bash
compileOutput="$(./compile.sh $* 2>&1)"
if [ -z "$compileOutput" ]; then
	./run.sh "$*"
else
	echo "$compileOutput"
fi
