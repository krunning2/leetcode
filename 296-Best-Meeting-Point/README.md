为了保证总长度最小，我们只要保证每条路径尽量不要重复就行了，比如1->2->3<-4这种一维的情况，如果起点是1，2和4，那2->3和1->2->3这两条路径就有重复了。为了尽量保证右边的点向左走，左边的点向右走，那我们就应该去这些点中间的点作为交点。由于是曼哈顿距离，我们可以分开计算横坐标和纵坐标，结果是一样的。所以我们算出各个横坐标到中点横坐标的距离，加上各个纵坐标到中点纵坐标的距离，就是结果了。

对row不需要排序，因为已经是有序的了

对于1D 的情况， 就是找中点