package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"os"
	"strconv"
	"strings"
)

func main() {
	in := bufio.NewReader(os.Stdin)
	tc := readInt(in)
	count := 0
	for i := 1; i <= tc; i++ {
		if gcd(i, tc) == 1 {
			count = count + 1
		}
	}
	fmt.Println(count)
}

func abc(a int, b int) int {
	if a > b {
		a, b = b, a
	}
	return rand.Intn(b-a) + a
}

func gcd(a int, b int) int {
	if a < b {
		a, b = b, a
	}
	if a == b {
		return a
	}
	if a == 0 || b == 0 {
		if a != 0 {
			return a
		}
		return b
	}
	return gcd(a%b, b)
}

func readInt(in *bufio.Reader) int {
	nStr, _ := in.ReadString('\n')
	nStr = strings.ReplaceAll(nStr, "\r", "")
	nStr = strings.ReplaceAll(nStr, "\n", "")
	n, _ := strconv.Atoi(nStr)
	return n
}

func readLineNumbs(in *bufio.Reader) []string {
	line, _ := in.ReadString('\n')
	line = strings.ReplaceAll(line, "\r", "")
	line = strings.ReplaceAll(line, "\n", "")
	numbs := strings.Split(line, " ")
	return numbs
}

func readArrInt(in *bufio.Reader) []int {
	numbs := readLineNumbs(in)
	arr := make([]int, len(numbs))
	for i, n := range numbs {
		val, _ := strconv.Atoi(n)
		arr[i] = val
	}
	return arr
}

func readArrInt64(in *bufio.Reader) []int64 {
	numbs := readLineNumbs(in)
	arr := make([]int64, len(numbs))
	for i, n := range numbs {
		val, _ := strconv.ParseInt(n, 10, 64)
		arr[i] = val
	}
	return arr
}
