package ilv.hex.coordinates

enum class CubeDirection(val x: Int, val y: Int, val z: Int){
    UP(0, 1, -1),
    UP_RIGHT(1, 0, -1),
    DOWN_RIGHT(1, -1, 0),
    DOWN(0, -1, 1),
    DOWN_LEFT(-1, 0, 1),
    UP_LEFT(-1, 1, 0);

    fun toCoordinates(): CubeCoordinates {
        return CubeCoordinates.valueOf(x, y, z)
    }
}