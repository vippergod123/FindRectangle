package com.duyts.examplekotlin

import kotlin.math.pow

data class Point(val x: Float, val y: Float) {
    override fun toString(): String {
        return String.format("[x:%s - y:%s]", x, y)
    }
}
class RectangleModel(
    private val pointA: Point,
    private val pointB: Point,
    private val pointC: Point
) {

    fun findLastPoint(): Point? {
        val AB = powDistanceOf(pointA, pointB) // AB^2
        val AC = powDistanceOf(pointA, pointC) // AC^2
        val BC = powDistanceOf(pointC, pointB) // BC^2

        if (isPointsOnTheLine(AB, BC, AC)) {
            return null
        }

        return when {
            AB == AC + BC -> {
                val midPoint = findMidPoint(pointA, pointB)
                Point(2 * midPoint.x - pointC.x, 2 * midPoint.y - pointC.y)
            }
            AC == AB + BC -> {
                val midPoint = findMidPoint(pointA, pointC)
                Point(2 * midPoint.x - pointB.x, 2 * midPoint.y - pointB.y)
            }
            BC == AB + AC -> {
                val midPoint = findMidPoint(pointC, pointB)
                Point(2 * midPoint.x - pointA.x, 2 * midPoint.y - pointA.y)
            }
            else -> {
                //It's not right-triangle => cannot make a rectangle
                return null
            }
        }

    }

    private fun isPointsOnTheLine(a: Float, b: Float, c: Float): Boolean {
        if ((a + b - c) == 2 * a * b ||
            (c + b - a) == 2 * c * b ||
            (a + c - b) == 2 * a * c
        ) {
            return true // is not triangle
        }
        return false
    }

    private fun powDistanceOf(A: Point, B: Point): Float {
        val x = (A.x - B.x).pow(2)
        val y = (A.y - B.y).pow(2)

        return x + y
    }

    private fun findMidPoint(A: Point, B: Point): Point {
        return Point((A.x + B.x) / 2, (A.y + B.y) / 2)
    }
}


