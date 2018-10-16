package ilv.hex.coordinates

class AxialCoordinates private constructor(val x: Int, val y: Int) {

    companion object {
        public fun valueOf(x: Int, y: Int): AxialCoordinates {
            return AxialCoordinates(x, y)
        }
    }
}