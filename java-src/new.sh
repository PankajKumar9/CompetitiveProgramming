#!/bin/bash

# Get the value of the CustomName variable from the command line argument
CustomName="$1"

# Create the CustomName.java file with the provided code
echo "import java.util.*;

public class $CustomName {
    public static void main(String[] args) {

    }
}" > "$CustomName.java"

echo "File $CustomName.java created."
