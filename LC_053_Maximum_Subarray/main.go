package main

import (
	"fmt"
	"math"
)

type Stack struct {
	data []int
}

func (s *Stack) Push(value int) {
	s.data = append(s.data, value)
}

func (s *Stack) Pop() (int, bool) {
	if len(s.data) == 0 {
		return 0, false // Stack is empty
	}
	index := len(s.data) - 1
	value := s.data[index]
	s.data = s.data[:index]
	return value, true
}
func (s *Stack) Peek() (int, bool) {
	if len(s.data) == 0 {
		return 0, false // Stack is empty
	}
	return s.data[len(s.data)-1], true
}

func main() {
	fmt.Println("hello world")
	x := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	// Output: 6
	fmt.Printf("ans= %v", maxSubArray(x))
	//right me max kitna h prefix sum k , us se uthayege

}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func maxSubArray(nums []int) int {
	preSum := []int{nums[0]}
	for i := 1; i < len(nums); i++ {
		preSum = append(preSum, preSum[i-1]+nums[i])
	}
	fmt.Printf("preSum = %v \n", preSum)
	// toBuy := true
	// boughtAt := 0
	a := math.MinInt + 1
	x := Stack{}
	x.Push(0)
	ans := 0
	min := 0
	for i, _ := range preSum {
		ans = max(ans, preSum[i]-min)
		if preSum[i] < min {
			min = preSum[i]
		}
	}

	// for i, _ := range preSum {
	// 	if toBuy {
	// 		if i == 0 {
	// 			if preSum[i+1] > preSum[i] {
	// 				boughtAt = preSum[0]
	// 				toBuy = false
	// 			}
	// 		} else if i != len(preSum)-1 {
	// 			if preSum[i+1] > preSum[i] && preSum[i] < preSum[i-1] {
	// 				boughtAt = preSum[i]
	// 				toBuy = false
	// 			}
	// 		} else {
	// 			break
	// 		}
	// 	} else {
	// 		if i != len(preSum)-1 && i != 0 {
	// 			if preSum[i+1] < preSum[i] && preSum[i] > preSum[i-1] {
	// 				a = max(a, preSum[i]-boughtAt)
	// 				toBuy = true
	// 			}
	// 		} else if i == len(preSum)-1 {
	// 			if preSum[i] > preSum[i-1] {
	// 				a = max(a, preSum[i]-boughtAt)
	// 				toBuy = true
	// 			}
	// 		} else {
	// 			break
	// 		}
	// 	}

	// }
	fmt.Printf("a= %v \n", ans)
	return a

}
