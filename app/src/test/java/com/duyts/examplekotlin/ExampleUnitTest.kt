package com.duyts.examplekotlin

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val A = Point(1F,1F)
        val B = Point(3F,2F)
        val C = Point(1F,2F)
        val rectangleModel = RectangleModel(A,B,C);
        if (rectangleModel.findLastPoint() != null ) {
            println(rectangleModel.findLastPoint().toString())
        }
        else {
            println( "Cannot find last point!" )
        }
    }
}