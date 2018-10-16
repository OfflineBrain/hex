package ilv.hex.map

import ilv.hex.coordinates.CubeCoordinates

class Cell(val coordinates: CubeCoordinates) {

    fun costTo(current: Cell): Int {
        return coordinates.distanceTo(current.coordinates)
    }
}