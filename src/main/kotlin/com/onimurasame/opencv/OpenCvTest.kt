package com.onimurasame.opencv

import com.onimurasame.opencv.gui.CameraStartButton
import com.onimurasame.opencv.gui.LayoutGridPane
import com.onimurasame.opencv.gui.MainScene
import javafx.application.Application
import javafx.stage.Stage
import org.opencv.core.Core
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan
@Configuration
class OpenCvTest : Application() {

    @Autowired
    private lateinit var layoutGridPane: LayoutGridPane

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME)
            launch(OpenCvTest::class.java)
        }
    }

    override fun start(primaryStage: Stage?) {
        layoutGridPane.add(CameraStartButton("Start"), 2, 2)

        primaryStage?.title = "Open CV Test"
        primaryStage?.scene = MainScene(layoutGridPane)
        primaryStage?.show()

    }

}