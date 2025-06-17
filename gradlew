#!/bin/bash
echo "This is a mock gradlew script"
echo "Arguments: $@"

if [ "$1" == "bootRun" ]; then
  echo "Mock running bootRun task..."
else
  echo "Unknown task $1"
fi
