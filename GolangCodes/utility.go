type DequeData = string

type deque struct {
	indexes []DequeData
}

func (d *deque) push(i DequeData) {
	d.indexes = append(d.indexes, DequeData)
}

func (d *deque) getFirst() DequeData {
	return d.indexes[0]
}

func (d *deque) popFirst() {
	d.indexes = d.indexes[1:]
}

func (d *deque) getLast() DequeData {
	return d.indexes[len(d.indexes)-1]
}

func (d *deque) popLast() {
	d.indexes = d.indexes[:len(d.indexes)-1]
}

func (d *deque) empty() bool {
	return 0 == len(d.indexes)
}
