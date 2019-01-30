package com.onimurasame.opencv

import com.onimurasame.opencv.gui.CVBorderPane
import com.onimurasame.opencv.gui.MainScene
import javafx.application.Application
import javafx.stage.Stage
import org.opencv.core.Core

class OpenCvTest : Application() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME)
            launch(OpenCvTest::class.java)
        }
    }

    override fun start(primaryStage: Stage?) {
        primaryStage?.title = "Open CV Test"
        primaryStage?.scene = MainScene(CVBorderPane)
        primaryStage?.show()

    }

}