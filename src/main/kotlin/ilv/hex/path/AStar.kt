package ilv.hex.path

import ilv.hex.map.Cell
import ilv.hex.map.CellMap
import java.util.PriorityQueue

typealias Priority = Int

class AStar {
    private val map: CellMap = CellMap()
    private val frontier = PriorityQueue<Pair<Cell, Priority>>()
    private val cameFrom = HashMap<Cell, Cell>()
    private val pathCost = HashMap<Cell, Int>()


    fun buildPath(start: Cell, end: Cell): List<Cell> {
        frontier + (start to 0)
        cameFrom[start] = start
        pathCost[start] = 0

        while (frontier.isNotEmpty()) {
            val current = frontier.poll().first

            if (current == end) {
                break
            }

            map.neighbors(current).forEach {
                val newCost = pathCost[current]?.plus(it.costTo(current)) ?: 0
                if (newCost < (pathCost[it] ?: Int.MAX_VALUE)) {
                    pathCost[it] = newCost
                    val priority = newCost + it.coordinates.distanceTo(end.coordinates)
                    frontier + (it to priority)
                    cameFrom[it] = current
                }
            }
        }

        val cellPath = ArrayList<Cell>()

        cameFrom[end]?.also {
            var previous = it
            var next = cameFrom[previous] ?: previous
            cellPath + previous

            while (next != previous) {
                previous = next
                next = cameFrom[previous] ?: previous

                cellPath + previous
            }
        }


        return cellPath
    }
}