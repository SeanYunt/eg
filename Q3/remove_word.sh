#!/bin/sh

if [ $# -eq 0 ]
  then
    echo "No arguments supplied"
    exit 1
fi
if [ -z "$1" ]
  then
    echo "first arg expected is sentence wrapped in double quotes"
    exit 1
fi
if [ -z "$2" ]
  then
    echo "second arg expected is word"
    exit 1
fi
SENTENCE=$1
WORD=$2

echo $SENTENCE | sed -e "s/$WORD//g"