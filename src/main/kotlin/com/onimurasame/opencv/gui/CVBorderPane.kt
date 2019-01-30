package com.onimurasame.opencv.gui

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox

object CVBorderPane : BorderPane() {

    init {
        val bottomHbox = HBox()
        bottomHbox.alignment = Pos.CENTER
        bottomHbox.padding = Insets(25.0, 25.0, 25.0, 25.0)
        bottomHbox.children.add(CameraStartButton)

        this.bottom = bottomHbox
        this.center = CameraView.imageView
    }

}