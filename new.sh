#!/bin/bash

customName="$1"  # Get the custom name as the first argument

# Create directory with custom name
mkdir "$customName"
cd "$customName" || exit

# Create main.go file
cat > main.go <<EOF
package main

import "fmt"

func main() {
    fmt.Println("hello world")
}
EOF

# Initialize Go module with custom name
go mod init "$customName"

# Exit the newly created directory
cd ..
