package ilv.hex.coordinates

import kotlin.math.abs

class CubeCoordinates private constructor(val x: Int, val y: Int, val z: Int) {

    operator fun plus(right: CubeCoordinates): CubeCoordinates {
        return CubeCoordinates(x + right.x, y + right.y, z + right.z)
    }

    operator fun minus(right: CubeCoordinates): CubeCoordinates {
        return CubeCoordinates(x - right.x, y - right.y, z - right.z)
    }

    fun distanceTo(coordinates: CubeCoordinates): Int {
        return abs(x - coordinates.x) + abs(y - coordinates.y) + abs(z - coordinates.z)
    }

    fun neighbor(direction: CubeDirection): CubeCoordinates {
        return this + direction.toCoordinates()
    }

    companion object {
        public fun valueOf(x: Int, y: Int, z: Int): CubeCoordinates {
            assert(x + y + z == 0) { "Sum of coordinates should be equal to 0" }
            return CubeCoordinates(x, y, z)
        }
    }
}