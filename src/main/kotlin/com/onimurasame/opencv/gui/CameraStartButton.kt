package com.onimurasame.opencv.gui

import javafx.event.EventHandler
import javafx.scene.control.Button

object CameraStartButton : Button() {

    init {
        this.text = "Start Camera"
        this.onMouseClicked = EventHandler {
            println("Starting Camera...")
            CameraView.startCamera()
        }
    }

}