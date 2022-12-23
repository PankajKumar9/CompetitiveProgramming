package GolangCode

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func CF_100() {

	in := bufio.NewReader(os.Stdin)

	a := readArrInt(in)

	fmt.Println(a[0] + a[1])

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
func readLineNumbs(in *bufio.Reader) []string {
	line, _ := in.ReadString('\n')
	line = strings.ReplaceAll(line, "\r", "")
	line = strings.ReplaceAll(line, "\n", "")
	numbs := strings.Split(line, " ")
	return numbs
}
