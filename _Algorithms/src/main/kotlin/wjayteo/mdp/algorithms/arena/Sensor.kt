package wjayteo.mdp.algorithms.arena

class Sensor {
    companion object {
        fun updateArenaSensor1(x1: Int, y1: Int, facing: Int, reading: Int) {
            var x: Int = x1
            var y: Int = y1
            val r: Int = reading.coerceIn(0, 3)
            if (r <= 0) return

            when (facing) {
                0   -> {
                    x += 1
                    y += 1
                    if (r == 1) Arena.setObstacle(x, y + r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y + r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y + offset)
                    }
                }

                90   -> {
                    x += 1
                    y -= 1
                    if (r == 1) Arena.setObstacle(x + r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x + r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x + offset, y)
                    }
                }

                180   -> {
                    x -= 1
                    y -= 1
                    if (r == 1) Arena.setObstacle(x, y - r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y - r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y - offset)
                    }
                }

                270   -> {
                    x -= 1
                    y += 1
                    if (r == 1) Arena.setObstacle(x - r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x - r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x - offset, y)
                    }
                }
            }
        }

        fun updateArenaSensor2(x1: Int, y1: Int, facing: Int, reading: Int) {
            var x: Int = x1
            var y: Int = y1
            val r: Int = reading.coerceIn(0, 3)
            if (r <= 0) return

            when (facing) {
                0   -> {
                    y += 1
                    if (r == 1) Arena.setObstacle(x, y + r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y + r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y + offset)
                    }
                }

                90   -> {
                    x += 1
                    if (r == 1) Arena.setObstacle(x + r, y)
                    else {
                        ///if (r <= 3) Arena.setObstacle(x + r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x + offset, y)
                    }
                }

                180   -> {
                    y -= 1
                    if (r == 1) Arena.setObstacle(x, y - r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y - r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y - offset)
                    }
                }

                270   -> {
                    x -= 1
                    if (r == 1) Arena.setObstacle(x - r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x - r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x - offset, y)
                    }
                }
            }
        }

        fun updateArenaSensor3(x1: Int, y1: Int, facing: Int, reading: Int) {
            var x: Int = x1
            var y: Int = y1
            val r: Int = reading.coerceIn(0, 3)
            if (r <= 0) return

            when (facing) {
                0   -> {
                    x -= 1
                    y += 1
                    if (r == 1) Arena.setObstacle(x, y + r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y + r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y + offset)
                    }
                }

                90   -> {
                    x += 1
                    y += 1
                    if (r == 1) Arena.setObstacle(x + r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x + r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x + offset, y)
                    }
                }

                180   -> {
                    x += 1
                    y -= 1
                    if (r == 1) Arena.setObstacle(x, y - r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y - r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y - offset)
                    }
                }

                270   -> {
                    x -= 1
                    y -= 1
                    if (r == 1) Arena.setObstacle(x - r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x - r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x - offset, y)
                    }
                }
            }
        }

        fun updateArenaSensor4(x1: Int, y1: Int, facing: Int, reading: Int) {
            var x: Int = x1
            var y: Int = y1
            val r: Int = reading.coerceIn(0, 3)
            if (r <= 0) return

            when (facing) {
                0 -> {
                    x -= 1
                    y += 1
                    if (r == 1) Arena.setObstacle(x - r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x - r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x - offset, y)
                    }
                }

                90 -> {
                    x += 1
                    y += 1
                    if (r == 1) Arena.setObstacle(x, y + r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y + r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y + offset)
                    }
                }

                180 -> {
                    x += 1
                    y -= 1
                    if (r == 1) Arena.setObstacle(x + r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x + r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x + offset, y)
                    }
                }

                270 -> {
                    x -= 1
                    y -= 1
                    if (r == 1) Arena.setObstacle(x, y - r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y - r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y - offset)
                    }
                }
            }
        }

        fun updateArenaSensor5(x1: Int, y1: Int, facing: Int, reading: Int) {
            var x: Int = x1
            var y: Int = y1
            val r: Int = reading.coerceIn(0, 3)
            if (r <= 0) return

            when (facing) {
                0 -> {
                    x -= 1
                    y -= 1
                    if (r == 1) Arena.setObstacle(x - r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x - r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x - offset, y)
                    }
                }

                90 -> {
                    x -= 1
                    y += 1
                    if (r == 1) Arena.setObstacle(x, y + r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y + r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y + offset)
                    }
                }

                180 -> {
                    x += 1
                    y += 1
                    if (r == 1) Arena.setObstacle(x + r, y)
                    else {
                        //if (r <= 3) Arena.setObstacle(x + r, y)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x + offset, y)
                    }
                }

                270 -> {
                    x += 1
                    y -= 1
                    if (r == 1) Arena.setObstacle(x, y - r)
                    else {
                        //if (r <= 3) Arena.setObstacle(x, y - r)
                        for (offset in r - 1 downTo 1) Arena.setExplored(x, y - offset)
                    }
                }
            }
        }

        fun updateArenaSensor6(x1: Int, y1: Int, facing: Int, reading: Int) {
            var x: Int = x1
            var y: Int = y1
            val r: Int = reading.coerceIn(0, 8)
            if (r <= 0) return

            when (facing) {
                0 -> {
                    x += 1
                    if (r <= 6) Arena.setObstacle(x + r, y)
                    for (offset in r - 1 downTo 1) Arena.setExplored(x + offset, y)
//                    if (r in 3..4) {
//                        if (!Arena.isObstacle(x + r, y)) {
//                            if (Arena.isSuspect(x + r, y)) {
//                                Arena.setObstacle(x + r, y)
//
//                                if (!Arena.isSuspect(x + (r + 1), y) && !Arena.isObstacle(x + (r + 1), y)) {
//                                    Arena.setExploredForced(x + (r + 2), y)
//                                }
//                            } else Arena.setObstacle(x + 1, y)
//                        }
//                    } else {
//                        if (r <= 6) Arena.setObstacle(x + r, y)
//                        for (offset in r - 1 downTo 1) Arena.setExplored(x + offset, y)
//                    }
                }

                90 -> {
                    y -= 1
                    if (r <= 6) Arena.setObstacle(x, y - r)
                    for (offset in 1 until r) Arena.setExplored(x, y - offset)
                }

                180 -> {
                    x -= 1
                    if (r <= 6) Arena.setObstacle(x - r, y)
                    for (offset in r - 1 downTo 1) Arena.setExplored(x - offset, y)
                }

                270 -> {
                    y += 1
                    if (r <= 6) Arena.setObstacle(x, y + r)
                    for (offset in r - 1 downTo 1) Arena.setExplored(x, y + offset)
                }
            }
        }
    }
}
