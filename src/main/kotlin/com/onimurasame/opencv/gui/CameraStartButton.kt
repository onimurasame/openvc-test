package com.onimurasame.opencv.gui

import javafx.event.EventHandler
import javafx.scene.control.Button
import org.springframework.stereotype.Component

@Component
class CameraStartButton: Button {

    constructor(buttonText: String) : super(buttonText) {
        this.onMouseClicked = EventHandler() {
            /*if (!videoCapture.isOpened) {
                videoCapture.open(0)

                val frameGrabber: Runnable = Runnable() {

                    fun run() {

                    }

                }
            }*/
        }
    }

}